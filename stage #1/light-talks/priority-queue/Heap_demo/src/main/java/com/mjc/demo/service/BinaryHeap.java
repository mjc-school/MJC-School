package com.mjc.demo.service;

public class BinaryHeap {

    private int[] heap;
    private int currentSize;

    public int[] build(int[] input) {
        currentSize = input.length;
        heap = new int[input.length];
        for (int i = 0; i < input.length; i++) {
            heap[i] = input[i];
            siftUp(i);
        }

        return heap;
    }

    public int getMin() {
        int min = heap[0];
        currentSize--;
        heap[0] = heap[currentSize];
        siftDown(0);

        return min;
    }

    private void siftUp(int index) {
        while (index > 0 && heap[getParentIndex(index)] > heap[index]) {
            swap(index, getParentIndex(index));
            index = getParentIndex(index);
        }
    }

    private void siftDown(int index) {
        while (true) {
            int leftIndex = getLeftChildIndex(index);
            int rightIndex = getRightChildIndex(index);
            int smallestIndex = index;

            if (leftIndex < heap.length && heap[leftIndex] < heap[index]) {
                smallestIndex = leftIndex;
            }

            if (rightIndex < heap.length && heap[rightIndex] < heap[smallestIndex]) {
                smallestIndex = rightIndex;
            }

            if (smallestIndex == index) {
                break;
            }

            swap(smallestIndex, index);
            index = smallestIndex;
        }
    }

    private int getParentIndex(int index) {
        return (index - 1) / 2;
    }

    private int getLeftChildIndex(int index) {
        return index * 2 + 1;
    }

    private int getRightChildIndex(int index) {
        return index * 2 + 2;
    }

    private void swap(int firstIndex, int secondIndex) {
        int temp = heap[firstIndex];
        heap[firstIndex] = heap[secondIndex];
        heap[secondIndex] = temp;
    }
}
