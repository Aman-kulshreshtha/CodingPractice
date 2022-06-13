package DSA.TopicPractice.RecursionBacktracking;

import java.util.ArrayList;

public class TargetSubsetSum {
    public static void main(String[] args) {

        int[] arr = { 10, 20, 30, 40, 50 };
        int target = 70;

        ArrayList<ArrayList<Integer>> ans = targetSubsetSum(arr, arr.length, target);

        for (ArrayList<Integer> a : ans) {
            System.out.println(a);
        }

    }

    private static ArrayList<ArrayList<Integer>> targetSubsetSum(int[] arr, int n, int target) {

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        if (n <= 0 || target < 0) {
            return ans;
        }

        if (target == 0) {
            ans.add(new ArrayList<Integer>());
            return ans;
        }

        if (n == 1) {
            if (arr[0] == target) {
                ArrayList<Integer> a = new ArrayList<>();
                a.add(arr[0]);
                ans.add(a);
                return ans;

            } else {
                return ans;
            }
        }

        ArrayList<ArrayList<Integer>> included = targetSubsetSum(arr, n - 1, target - arr[n - 1]);
        ArrayList<ArrayList<Integer>> excluded = targetSubsetSum(arr, n - 1, target);

        for (ArrayList<Integer> a : included) {
            a.add(arr[n - 1]);
            ans.add(a);
        }

        for (ArrayList<Integer> a : excluded) {

            ans.add(a);
        }

        return ans;

    }

}
