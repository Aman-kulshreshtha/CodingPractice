package contest.virtual.leetcode.weekly277;

import java.util.*;

public class A {

    public static void main(String[] args) {
    }
    private static int countElements(int[] nums) {
        int min = nums[0], max = nums[0];
        for(int x : nums) {
            min = Math.min(min,x);
            max = Math.max(max,x);
        }
        int ans = 0;
        for(int x : nums) {
            if(x != min && x != max) {
                ans++;
            }
        }

        return ans;
    }

    private static int[] rearrangeArray(int[] nums) {
       Queue<Integer> pos = new ArrayDeque<>(),neg = new ArrayDeque<>();
       for(int x : nums) {
           if(x > 0) pos.add(x);
           else neg.add(x);
       }

       int idx = 0;
       while(idx < nums.length) {
           nums[idx++] = pos.remove();
           nums[idx++] = neg.remove();
       }

       return nums;
//
    }

    private static List<Integer> findLonely(int[] nums) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> once = new HashSet<>();
        List<Integer> ans = new ArrayList<>();

        for(int x :  nums) {
            if(set.contains(x)) {
                once.remove(x);
            }else {
                set.add(x);
                once.add(x);
            }
        }

        for(int x : once) {
            if(!set.contains(x-1) && !set.contains(x+1)) {
                ans.add(x);
            }
        }
        return ans;
    }

    private static int maximumGood(int[][] statements) {
        //TODO: code the logic
        return 0;
    }

}
