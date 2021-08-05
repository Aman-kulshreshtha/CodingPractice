package Competitions;

import java.util.*;

public class Subsets2 {
    
    
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
         
        HashSet<Integer> set = new HashSet<Integer>(); 
        List<List<Integer>> ans = solve(nums, nums.length, set);
        return ans;
    }
    private static  List<List<Integer>> solve(int[] nums,int n,HashSet<Integer> set) {
        if(n == 0) {

            List<Integer> a = new ArrayList<>();

            List<List<Integer>> ans = new ArrayList<List<Integer>>();
            ans.add(a);
            return ans;
            
        }else {
            
            List<List<Integer>> ans = solve(nums,n-1,set);
            int size = ans.size();
            for(int i = 0 ; i < size; i++) {
                if(ans.get(i).indexOf(nums[n-1]) != -1 || !set.contains(nums[n-1]) ) {
                   List<Integer> ne = new ArrayList<>();
                    ne.addAll(ans.get(i));
                    ne.add(nums[n-1]);
                    set.add(nums[n-1]);
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