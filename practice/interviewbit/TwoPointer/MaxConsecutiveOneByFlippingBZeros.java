package practice.interviewbit.TwoPointer;

/**
 * MaxConsecutiveOneByFlippingBZeros
 */

import java.util.*;
import java.io.*;

public class MaxConsecutiveOneByFlippingBZeros {

    public static void main(String[] args) {

        ArrayList<Integer> A = new ArrayList<>();
        A.add(1);
        A.add(0);

        System.out.println(solve(A, 4));

    }

    private static int solve(ArrayList<Integer> A, int B) {
        int l = 0;
        int r = 0;
        int flips = 0;
        int ans = 0;
        int count = 0;

        while (r < A.size()) {

            if (A.get(r) == 1) {
                count++;
                r++;
            } else {

                if (flips == B) {
                    // can't flip

                    ans = Math.max(count, ans);

                    while (l < r && A.get(l) != 0) {
                        l++;
                        count--;
                    }
                    l++;
                    count--;
                    flips--;

                }

                // can flip
                count++;
                flips++;
                r++;

            }
        }
        return ans;
    }
}