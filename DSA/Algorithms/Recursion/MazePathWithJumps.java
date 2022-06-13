package DSA.Algorithms.Recursion;

import java.util.ArrayList;
import java.util.List;

public class MazePathWithJumps {
    public static void main(String[] args) {
        for(String s : getMazePathWithJumps(2,2)) {
            System.out.println(s);
        }
    }
    private static List<String> getMazePathWithJumps(int m , int n ) {
        if(m == 1 && n == 1) {
            List<String> ans = new ArrayList<>();
            ans.add("");
            return ans;
        }

        if( m <= 0 || n <= 0) {
            List<String> ans = new ArrayList<>();
            return ans;
        }

        List<String> ans = new ArrayList<>();

        for(int option = 1; option <= n ; option++) {
            for(String s : getMazePathWithJumps(m,n-option)) {
                ans.add("h"+option+" "+ s);
            }
        }

        for(int option = 1; option <= m ; option++) {
            for(String s : getMazePathWithJumps(m-option,n)) {
                ans.add("v"+option+" "+ s);
            }
        }

        for(int option = 1; option <= Math.min(m,n) ; option++) {
            for(String s : getMazePathWithJumps(m-option,n-option)) {
                ans.add("d"+option+" "+ s);
            }
        }

        return ans;

    }
}
