package DSA.AdityaVermaPlaylist.Heap;

import java.util.*;

public class HeapIntro {
    public static void main(String[] args) {

        // Creating a heap using Collections Framework
        // by default this is a min heap

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        minHeap.add(10);
        minHeap.add(5);
        minHeap.add(15);

        // when we remove element smallest is removed first

        System.out.println(minHeap.poll()); // removes 5

        // to create a max heap
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        maxHeap.add(10);
        maxHeap.add(5);
        maxHeap.add(15);

        // when we remove an element we get the maximum
        System.out.println(maxHeap.poll());

        System.exit(0);

    }
}