package Competitions;

import java.util.*;

public class Subsets2 {
    
    
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
         List<List<Integer>> ans = solve(nums,nums.length);
        return ans;
    }
    private static  List<List<Integer>> solve(int[] nums,int n) {
        if(n == 0) {

            List<Integer> a = new ArrayList<>();

            List<List<Integer>> ans = new ArrayList<List<Integer>>();
            ans.add(a);
            return ans;
            
        }else {
            
            List<List<Integer>> ans = solve(nums,n-1);
            
            for(int i = 0 ; i < ans.size(); i++) {
                if(ans.get(i).indexOf(nums[n-1]) == -1) {
                   List<Integer> ne = new ArrayList<>();
                    ne.addAll(ans.get(i));
                    ne.add(nums[n-1]);
                    ans.add(ne);
                    System.out.println(ne);
                }
            }
            
            return ans;
            
            
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,2,3};
        subsetsWithDup(nums);
    }
    
   
}