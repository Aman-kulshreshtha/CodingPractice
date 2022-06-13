package DSA.Algorithms.Recursion;

import java.util.ArrayList;
import java.util.List;

public class StairPaths {

    public static void main(String[] args) {
        List<String> ans = getMazePaths(3,3);
        for(String s : ans) {
            System.out.println(s);
        }
    }

    private static List<String> stairPaths(int N) {
        StringBuilder sb = new StringBuilder();
        List<String> ans = new ArrayList<>();
        solve(3,0,ans,sb);

        return ans;
    }

    private static List<String> getMazePaths(int m,int n ) {
        if(m == 1 && n == 1) {
            List<String> ans = new ArrayList<>();
            ans.add("");
            return ans;
        }if(m <= 0 || n <= 0) {
            return new ArrayList<String>();
        }

        List<String> bottom = getMazePaths(m-1,n);
        List<String> right = getMazePaths(m,n-1);
        List<String> ans = new ArrayList<>();
        for(String raste : bottom) {
            ans.add("v" + raste);
        }
        for(String raste : right) {
            ans.add("h" + raste);
        }
        return ans;
    }

    private static void solve(int N , int i, List<String> ans , StringBuilder sb ) {

        if(i == N) {
            ans.add(sb.toString());
            return;
        }

        if(i > N ) {
            return;
        }

        sb.append("1");
        solve(N,i+1,ans,sb);
        sb.deleteCharAt(sb.length()-1);
        sb.append("2");
        solve(N,i+2,ans,sb);
        sb.deleteCharAt(sb.length()-1);
        sb.append("3");
        solve(N,i+3,ans,sb);
        sb.deleteCharAt(sb.length()-1);
    }
}
