package DSA.Algorithms.Recursion;

import java.util.*;

public class GenerateParanthesis {
    public static void main(String[] args) {
        System.out.println(AllParenthesis(3));
    }
    private static  List<String> AllParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        solve(n,new StringBuilder(),ans,0,0);
        return ans;
    }

    private static void solve(int n , StringBuilder sb , List<String> ans , int open , int close) {
        if(open == n && close == n ) {
            ans.add(sb.toString());
            return;
        }

        if(open >n || close>n ) {
            return ;
        }


        if(open == close) {
            sb.append("(");
            solve(n,sb,ans,open+1,close);
            sb.deleteCharAt(sb.length()-1);

        }else  {
            sb.append("(");
            solve(n,sb,ans,open+1,close);
            sb.deleteCharAt(sb.length()-1);
            sb.append(")");
            solve(n,sb,ans,open,close+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }

}
