package com.mjc.demo.service;

import com.mjc.demo.model.BookItem;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class ItemStatisticService {

    // n - bookItems size
    // complexity - n * log n
    public List<BookItem> getTopPopularBookItems(List<BookItem> bookItems, int size) {
        final Map<BookItem, Integer> frequency = countFrequency(bookItems);
        return frequency.entrySet()
                .stream()
                .sorted(Map.Entry.<BookItem, Integer>comparingByValue().reversed())
                .limit(size)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    // n - bookItems size
    // k - input size
    // complexity - n * log k
    public List<BookItem> getTopPopularBookItemsHeap(List<BookItem> bookItems, int size) {
        final Map<BookItem, Integer> frequency = countFrequency(bookItems);
        record QueueItem(BookItem item, int count) implements Comparable<QueueItem> {
            @Override
            public int compareTo(QueueItem item) {
                return Integer.compare(this.count, item.count);
            }
        }
        PriorityQueue<QueueItem> queue = new PriorityQueue<>();
        frequency.forEach(((item, count) -> {
            queue.add(new QueueItem(item, count));
            if (queue.size() > size) {
                queue.remove();
            }
        }));

        return queue.stream().map(queueItem -> queueItem.item).toList();
    }

    private Map<BookItem, Integer> countFrequency(List<BookItem> bookItems) {
        final Map<BookItem, Integer> frequency = new HashMap<>();
        bookItems.forEach(bookItem -> frequency.compute(bookItem, (i, prev) -> prev == null ? 1 : prev + 1));
        return frequency;
    }
}
