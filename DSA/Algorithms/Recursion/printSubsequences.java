package DSA.Algorithms.Recursion;

import java.util.*;


public class printSubsequences {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 6, 5, 7, 9 };
        printSub(0, new ArrayList<>(), 0, arr, 8);
    }

    private static boolean printSub(int index, ArrayList<Integer> ans, int sum, int[] arr, int k) {

        if (index >= arr.length) {

            if (sum == k) {
                System.out.print("[ ");

                for (int x : ans) {
                    System.out.print(x + " ");

                }
                System.out.println("]");

                return true;
            }

            return false;
        }

        ans.add(arr[index]);
        if(printSub(index + 1, ans, sum + arr[index], arr, k)) {
            return true;
        }else {
            ans.remove(ans.size() - 1);
            return printSub(index + 1, ans, sum, arr, k);
        }

    }
}