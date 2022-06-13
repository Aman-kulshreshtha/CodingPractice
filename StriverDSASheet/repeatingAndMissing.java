package StriverDSASheet;

import java.util.*;

public class repeatingAndMissing {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> arr = new ArrayList<>();

        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            arr.add(sc.nextInt());
        }

        System.out.println(missingAndRepeating(arr, n));

    }

    public static Pair<Integer, Integer> missingAndRepeating(ArrayList<Integer> arr, int n) {

        int repeating = -1;
        for (int i = 0; i < n;) {
            if (arr.get(i) != i + 1) {
                int prev = arr.get(i);
                swap(arr, i, arr.get(i) - 1);
                if (prev == arr.get(i)) {
                    repeating = prev;
                    i++;
                }
            } else {
                i++;
            }
        }

        System.out.println(repeating);
        return null;
    }

    private static void swap(ArrayList<Integer> arr, int i, int j) {

        int temp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, temp);

    }

}

