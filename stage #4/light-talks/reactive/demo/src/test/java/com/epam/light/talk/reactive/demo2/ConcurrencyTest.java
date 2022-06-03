package com.epam.light.talk.reactive.demo2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.LoggerFactory;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;

public class ConcurrencyTest {

    private static Logger LOGGER = (Logger) LoggerFactory.getLogger(ConcurrencyTest.class);

    @BeforeEach
    public void setUp() {

        Logger rootLogger = (Logger) LoggerFactory.getLogger(Logger.ROOT_LOGGER_NAME);
        rootLogger.setLevel(Level.INFO);
    }

    @Test
    public void makeManyConcurrentRequests() throws InterruptedException {
        WebClient webClient = WebClient.builder().build();

        Flux.range(0, 256)
                .log()
                .flatMap(i -> webClient.get()
                        .uri("http://localhost:8080/employees/" + i)
                        .retrieve()
                        .bodyToMono(String.class))
                .doOnNext(LOGGER::info)
                .subscribe();
        Thread.sleep(5_000);
    }
}
