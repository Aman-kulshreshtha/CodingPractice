package DSA.TopicPractice.RecursionBacktracking;

// print permutations
import java.util.ArrayList;
import java.util.Scanner;

public class PrintPermutation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(printPermutation(s));
    }

    private static ArrayList<String> printPermutation(String s) {
        ArrayList<String> ans = new ArrayList<>();

        if(s.isEmpty()) {
            return ans;
        }

        if(s.length() == 1) {
            ans.add(s);
            return ans;
        }


        for (int i = 0; i < s.length(); i++) {
            StringBuilder string = new StringBuilder();

            for(int j = 0 ; j < s.length(); j++) {
                if(j != i) {
                    string.append(s.charAt(j));
                }
            }

//            System.out.println(s.charAt(i)+" + "+string.toString());

            ArrayList<String> perm = printPermutation(string.toString());

            for(String p : perm) {
                ans.add(s.charAt(i)+p);
            }

        }

        return ans;

    }
}
