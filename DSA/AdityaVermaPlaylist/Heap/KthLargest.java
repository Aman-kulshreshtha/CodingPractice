package DSA.AdityaVermaPlaylist.Heap;

import java.util.PriorityQueue;
import java.util.Scanner;

public class KthLargest {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(kthLargest(arr, k));
        sc.close();

    }

    private static int kthLargest(int[] arr, int k) {

        // creating a minHeap
        PriorityQueue<Integer> maxh = new PriorityQueue<>();

        // traverse array
        for (int x : arr) {
            // add to heap
            maxh.add(x);

            // if size of heap is greater than k make it equal to k
            if (maxh.size() > k) {
                maxh.poll();
            }
        }

        // return ans
        if (maxh.size() == k)
            return maxh.peek();
        else
            return -1;
    }

}
