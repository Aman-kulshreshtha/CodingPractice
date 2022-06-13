package DSA.AdityaVermaPlaylist.Heap;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Sort_A_K_SortedArray {
    public static void main(String[] args) {
        // Scanner sc = new Scanner(System.in);
        // int n = sc.nextInt();
        // int k = sc.nextInt();
        // int[] arr = new int[n];
        // for (int i = 0; i < n; i++) {
        // arr[i] = sc.nextInt();
        // }

        // sortKSorted(arr, k);

        // for (int i = 0; i < n; i++) {
        // System.out.print(arr[i] + " ");
        // }

        // System.out.println();

        // sc.close();
        System.exit(0);

    }

    private static void sortKSorted(int[] arr, int k) {
        PriorityQueue<Integer> minh = new PriorityQueue<>();
        int j = 0;

        for (int x : arr) {
            minh.add(x);
            if (minh.size() > k) {
                arr[j++] = minh.poll();
            }
        }

        while (!minh.isEmpty()) {
            arr[j++] = minh.poll();
        }

    }

}
