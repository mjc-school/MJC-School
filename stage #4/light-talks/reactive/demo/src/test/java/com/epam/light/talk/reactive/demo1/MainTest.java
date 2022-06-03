package com.epam.light.talk.reactive.demo1;

import org.junit.jupiter.api.Test;
import org.reactivestreams.Subscriber;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

class MainTest {

    @Test
    public void justTest() {
        Mono<Integer> mono = Mono.just(1);

        System.out.println(mono);

//        mono.subscribe();
//        mono.subscribe(
//                item -> System.out.println("Received: " + item),
//                e -> System.out.println(e.getMessage()),
//                () -> System.out.println("Completed without error"));
    }

    @Test
    public void mapTest() {
        Mono.just(1)
                .map(i -> i / 2.)
                .subscribe(System.out::println);
    }

    @Test
    public void mapExceptionTest() {
        Mono.just(1)
                .map(i -> i / 0)
                .subscribe(System.out::println);
    }

    @Test
    public void fromSupplierTest() {
        System.out.println("Creating Mono.just");
        Mono.just(emitSomeDataUsingLotsOfTime());

        System.out.println("Creating Mono.fromSupplier");
        Mono<String> stringMono = Mono.fromSupplier(this::emitSomeDataUsingLotsOfTime);
        System.out.println("Subscribing to supplier mono");
        stringMono.subscribe(System.out::println);
    }

    private String emitSomeDataUsingLotsOfTime() {
        System.out.println("time consuming data computations...");
        return "data";
    }

    @Test
    public void fluxTest() {
        Flux<Integer> flux = Flux.just(1, 2, 3);

        flux.subscribe(
                item -> System.out.println("Received: " + item),
                e -> System.out.println(e.getMessage()),
                () -> System.out.println("Completed without error"));
    }

    @Test
    public void fluxFilterMultipleSubscribersTest() {
        Flux<Integer> integers = Flux.just(1, 2, 3, 4).filter(i -> i % 2 == 0);

        integers.subscribe(i -> System.out.println("Sub1 : " + i));
        integers.subscribe(i -> System.out.println("Sub2 : " + i));
    }

    @Test
    public void streamMultipleSubscribersTest() {
        List<Integer> list = List.of(1, 2, 3, 4);
        Flux<Integer> flux = Flux.fromStream(list.stream());

        flux.subscribe(i -> System.out.println("Sub1 : " + i));
        flux.subscribe(i -> System.out.println("Sub2 : " + i));
    }

    @Test
    public void rangeFluxTest() {
        Flux.range(1, 10)
                .log()
                .map(i -> i * 2)
                .subscribe(this::dataConsumer);
    }

    @Test
    public void fluxVsListTest() {
        List<String> list = giveStringBlocking();
        System.out.println(list);

//        Flux<String> flux = giveStringReactive();
//        flux.subscribe(this::dataConsumer);
    }

    private Flux<String> giveStringReactive() {
        return Flux.range(1, 5)
                .map(i -> getString());
    }

    private List<String> giveStringBlocking() {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add(getString());
        }
        return list;
    }

    private String getString() {
        sleep(1);
        return String.valueOf(System.currentTimeMillis());
    }

    @Test
    public void monoToFluxTest() {
        Mono<Integer> mono = Mono.just(1);

        Flux.from(mono).subscribe(this::dataConsumer);
    }

    @Test
    public void nextMethodTest() {
        Flux.range(1, 10)
                .filter(i -> i % 2 == 0)
                .next()
                .subscribe(this::dataConsumer);
    }

    @Test
    public void doHooksTest() {
        Flux.range(1, 3)
//                .map(i -> i/0)
                .doFirst(() -> System.out.println("doFirst 1"))
                .doOnSubscribe(subscription -> System.out.println("doOnSub 1: " + subscription))
                .doOnNext(item -> System.out.println("doOnNext : " + item))
                .doOnError(e -> System.out.println("doOnError : " + e))
                .doOnComplete(() -> System.out.println("doOnComplete"))
                .doOnCancel(() -> System.out.println("doOnCancel"))
                .doOnRequest((count) -> System.out.println("doOnRequest : " + count))
                .doOnTerminate(() -> System.out.println("doOnTerminate"))
                .doFinally((signalType -> System.out.println("doFinally with signal : " + signalType)))
                .doOnSubscribe(subscription -> System.out.println("doOnSub 2: " + subscription))
                .doFirst(() -> System.out.println("doFirst 2"))
                .take(2)
                .doFinally((signalType -> System.out.println("doFinally with signal 2: " + signalType)))
                .subscribe(this::dataConsumer);
    }

    @Test
    public void errorsTest() {
        Flux.range(1, 10)
                .log()
                .map(i -> {
                    if (i == 3) {
                        throw new RuntimeException();
                    }
                    return i;
                })
//                .onErrorReturn(1)
//                .onErrorResume(e -> fallback())
                .subscribe(this::dataConsumer);
    }

    private Mono<Integer> fallback() {
        return Mono.fromSupplier(() -> {
            System.out.println("calculating..");
            return 23;
        });
    }

    @Test
    public void handleEmptyTest() {
        Flux.range(1, 10)
                .filter(i -> i > 100)
//                .defaultIfEmpty(2)
//                .switchIfEmpty(fallback())
                .log()
                .subscribe(this::dataConsumer);
    }

    @Test
    public void flatMapTest() {
        int userId = 1;
        Mono.just(userId)
                .map(this::getOrderByUserId)
//                .flatMap(this::getOrderByUserId)
//                .flatMapMany(this::getOrdersByUserId)
                .subscribe(this::dataConsumer);
    }

    private Mono<String> getOrderByUserId(Integer userId) {
        return Mono.just("order3");
    }

    private Flux<String> getOrdersByUserId(Integer userId) {
        return Flux.just("order1", "order2", "order3");
    }

    @Test
    public void currentThreadTest() {
        Flux<Integer> flux = Flux.range(1, 10)
                .map(i -> {
                    System.out.println("map operator in thread " + Thread.currentThread().getName());
                    return i;
                });
        flux.subscribe();

//        Runnable runnable = () -> flux.subscribe(this::dataConsumer);
//
//        for (int i = 0; i < 2; i ++) {
//            new Thread(runnable).start();
//        }
//
//        sleep(1);
    }

    @Test
    public void subscribeOnTest() {
        Flux.range(1, 10)
                .map(i -> {
                    System.out.println("map 1 operator in thread " + Thread.currentThread().getName());
                    return i;
                })
                .subscribeOn(Schedulers.boundedElastic())
                .doFirst(() -> System.out.println("doFirst callback in thread " + Thread.currentThread().getName()))
                .subscribe();


        sleep(1);
    }

    private void sleep(int seconds) {
        try {
            Thread.sleep(seconds * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void dataConsumer(Object item) {
        System.out.println("Received: " + item);
    }
}