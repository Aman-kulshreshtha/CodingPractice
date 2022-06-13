package practice.leetcode.medium;

import java.util.*;

class Solution {
    public int numSplits(String s) {

        HashSet<Character> set = new HashSet<>();

        int n = s.length();
        int[] left = new int[n];
        int[] right = new int[n];

        for (int i = 0; i < s.length(); i++) {
            if (!set.contains(s.charAt(i))) {
                set.add(s.charAt(i));
            }

            left[i] = set.size();
        }

        set.clear();

        for (int i = n - 1; i >= 0; i--) {

            if (!set.contains(s.charAt(i))) {
                set.add(s.charAt(i));
            }

            right[i] = set.size();
        }

        int ans = 0;
        for (int i = 0; i < n - 1; i++) {
            if (left[i] == right[i + 1])
                ans++;
        }

        return ans;

    }
}