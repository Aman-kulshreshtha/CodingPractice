package Days30Companies6.GoldmanSachs;

// Problem link https://practice.geeksforgeeks.org/problems/print-anagrams-together/1/

import java.util.*;

/**
 * Group amagrams together
 * Given a list of Strings youi must group the anagrams together
 * and return the groups
 * Submitted correctly
 */

public class PrintAnagrams {
    public static void main(String[] args) {

    }

    public List<List<String>> anagrams(String[] string_list) {
        List<List<String>> ans = new ArrayList<>();
        for (String s : string_list) {
            boolean added = false;
            for (List<String> li : ans) {
                if (isAnagram(s, li.get(0))) {
                    added = true;
                    li.add(s);
                }
            }
            if (!added) {
                List<String> li = new ArrayList<String>();
                li.add(s);
                ans.add(li);
            }
        }
        return ans;
    }

    private static boolean isAnagram(String s1, String s2) {
        int n1 = s1.length(), n2 = s2.length();
        if (n1 != n2)
            return false;

        int[] chars = new int[256];
        char[] str1 = s1.toCharArray();
        char[] str2 = s2.toCharArray();

        for (char ch : str1) {
            chars[ch]++;
        }

        for (char ch : str2) {
            chars[ch]--;
        }

        boolean ans = true;
        for (int x : chars) {
            if (x != 0) {
                ans = false;
                break;
            }
        }

        return ans;

    }
}
