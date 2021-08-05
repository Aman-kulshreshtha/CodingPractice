import java.util.*;

class Solution {
    
    
    public static  List<List<Integer>> subsetsWithDup(int[] nums) {
         List<List<Integer>> ans = solve(nums,nums.length);
        return ans;
    }
    private static  List<List<Integer>> solve(int[] nums,int n) {
        if(n == 0) {
            List<Integer> a = new ArrayList<>();
            List<List<Integer>> ans = new ArrayList<List<Integer>>();
            return ans;
            
        }else {
            
            List<List<Integer>> ans = solve(nums,n-1);
            
            for(List<Integer> combination : ans) {
                if(combination.indexOf(nums[n-1]) == -1) {
                   List<Integer> ne = new ArrayList<>();
                    ne.addAll(combination);
                    ne.add(nums[n-1]);
                    ans.add(ne);
                    System.out.println(ne);
                }
            }
            
            return ans;
            
            
        }
    }

    public static void main(String[] args) {
        
    }
    
   
}