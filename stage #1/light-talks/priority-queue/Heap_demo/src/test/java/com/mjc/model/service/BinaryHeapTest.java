package com.mjc.model.service;

import com.mjc.demo.service.BinaryHeap;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class BinaryHeapTest {

    @Test
    void test() {
        BinaryHeap heap = new BinaryHeap();
        int[] result = heap.build(new int[]{10, 5, 8, 20, 2, 7});
        System.out.println(Arrays.toString(result));
    }
}
