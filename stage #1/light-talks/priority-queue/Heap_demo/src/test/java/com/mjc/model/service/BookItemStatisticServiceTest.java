package com.mjc.model.service;

import com.mjc.demo.model.BookItem;
import com.mjc.demo.service.ItemStatisticService;
import org.junit.jupiter.api.Test;

import java.util.List;

class BookItemStatisticServiceTest {

    private final ItemStatisticService itemStatisticService = new ItemStatisticService();

    @Test
    void test1() {
        final List<BookItem> bookItems = itemStatisticService.getTopPopularBookItems(getItems(), 5);
        bookItems.forEach(System.out::println);
    }

    @Test
    void test2() {
        final List<BookItem> bookItems = itemStatisticService.getTopPopularBookItemsHeap(getItems(), 2);
        bookItems.forEach(System.out::println);
    }

    public List<BookItem> getItems() {
        final BookItem firstBookItem =  new BookItem(11L, "Alice in Wonderland");
        final BookItem secondBookItem =  new BookItem(12L, "Green Mile");
        final BookItem thirdBookItem =  new BookItem(13L, "Tom Sawyer");
        final BookItem fourthBookItem =  new BookItem(14L, "It");
        final BookItem fifthBookItem =  new BookItem(15L, "The Great Gatsby");
        final BookItem sixthBookItem =  new BookItem(16L, "The man and the sea");
        return List.of(
                firstBookItem, secondBookItem, thirdBookItem, fourthBookItem,
                fifthBookItem, sixthBookItem, fourthBookItem, firstBookItem,
                thirdBookItem, firstBookItem, secondBookItem, fourthBookItem,
                sixthBookItem, secondBookItem, sixthBookItem, secondBookItem,
                sixthBookItem, sixthBookItem, sixthBookItem, fourthBookItem,
                fourthBookItem
        );
    }
}
