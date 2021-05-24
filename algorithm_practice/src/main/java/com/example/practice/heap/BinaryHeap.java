package com.example.practice.heap;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class BinaryHeap {
    private static final int d = 2;
    private final int[] heap;
    private int heapSize;

    /**
     * This will initialize our heap with default size. 
     */
    public BinaryHeap(int capacity) {
        heapSize = 0;
        heap = new int[capacity + 1];
        Arrays.fill(heap, -1);
        System.out.println(Arrays.toString(heap));
    }

    public boolean isEmpty() {
        return heapSize == 0;
    }

    public boolean isFull() {
        return heapSize == heap.length;
    }

    private int parent(int i) {
        return (i - 1) / d;
    }

    private int kthChild(int i, int k) {
        return d * i + k;
    }

    /**
     * Inserts new element in to heap * Complexity: O(log N) * As worst case scenario, we need to traverse till the root 
     */
    public void insert(int x) {
        if (isFull()) {
            throw new NoSuchElementException("Heap is full, No space to insert new element");
        }
        heap[heapSize] = x;
        heapSize++;
        heapifyUp(heapSize - 1);
    }

    /**
     * Deletes element at index x * Complexity: O(log N) 
     */
    public int delete(int x) {
        if (isEmpty()) {
            throw new NoSuchElementException("Heap is empty, No element to delete");
        }
        int maxElement = heap[x];
        heap[x] = heap[heapSize - 1];
        heapSize--;
        heapifyDown(x);
        return maxElement;
    }

    /**
     * Maintains the heap property while inserting an element. 
     */
    private void heapifyUp(int i) {
        int insertValue = heap[i];
        while (i > 0 && insertValue > heap[parent(i)]) {
            heap[i] = heap[parent(i)];
            i = parent(i);
        }
        heap[i] = insertValue;
    }

    /**
     * Maintains the heap property while deleting an element. 
     */
    private void heapifyDown(int i) {
        int child;
        int temp = heap[i];
        while (kthChild(i, 1) < heapSize) {
            child = maxChild(i);
            if (temp >= heap[child]) {
                break;
            }
            heap[i] = heap[child];
            i = child;
        }
        heap[i] = temp;
    }

    private int maxChild(int i) {
        int leftChild = kthChild(i, 1);
        int rightChild = kthChild(i, 2);
        return heap[leftChild] > heap[rightChild] ? leftChild : rightChild;
    }

    /**
     * Prints all elements of the heap 
     */
    public void printHeap() {
        System.out.print("nHeap = ");
        for (int i = 0; i < heapSize; i++) System.out.print(heap[i] + " ");
        System.out.println();
    }

    /**
     * This method returns the max element of the heap. * complexity: O(1) 
     */
    public int findMax() {
        if (isEmpty()) throw new NoSuchElementException("Heap is empty.");
        return heap[0];
    }

    public static void main(String[] args) {
        BinaryHeap maxHeap = new BinaryHeap(10);
        maxHeap.insert(110);
        maxHeap.insert(100);
        maxHeap.insert(90);
        maxHeap.insert(40);
        maxHeap.insert(80);
        maxHeap.insert(20);
        maxHeap.insert(60);

        maxHeap.insert(10);
        maxHeap.insert(30);
        maxHeap.insert(50);
        maxHeap.insert(70);

        maxHeap.printHeap();
        int max = maxHeap.findMax();
        System.out.println("max:" + max);
        boolean empty = maxHeap.isEmpty();
        System.out.println("empty:" + empty);
        boolean full = maxHeap.isFull();
        System.out.println("full:" + full);

        maxHeap.delete(5);
        maxHeap.printHeap();
        maxHeap.delete(2);
        maxHeap.printHeap();
    }
}