package practice.leetcode.medium;

import java.util.*;



class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

class Solution {

    public int deepestLeavesSum(TreeNode root) {

        int[] arr = new int[2];
        
        solve(root, 0, arr);
        
        return arr[1];
        
    }
    
     private static void solve(TreeNode root,int level, int[] arr) {
        if(root == null) return;

        solve(root.left,level+1,arr);
        
        if(arr[0] == level) {
            arr[1] += root.val;
        }

        if(level > arr[0]) {
            arr[0] = level;
            arr[1] = root.val;
        }

        solve(root.right,level+1,arr);

        return;
        
    }

}
