package DSA.TopicPractice.RecursionBacktracking;

import java.util.ArrayList;

public class PrintEncodings {
    public static void main(String[] args) {
        System.out.println(printEncodings("123"));
    }

    private static ArrayList<String> printEncodings(String s) {

        ArrayList<String> ans = new ArrayList<>();

        if(s.isEmpty()) {
            return ans;
        }


        int encoding = 'A' + Integer.parseInt("" + s.charAt(0)) - 1;

        if(s.length() == 2) {

        }

        if(s.length() == 1) {
            ans.add((char) encoding +"");
            return ans;
        }


        if(s.charAt(0) == '0') {

            return ans;
        }

        ArrayList<String> enc1 = printEncodings(s.substring((1)));

        for(String en : enc1) {
            char e = (char) encoding;

            ans.add(e+en);
        }

        if( Integer.parseInt(s.substring(0,2)) <= 26) {
            ArrayList<String> enc2 = printEncodings(s.substring((2)));

            for(String en : enc2) {
                char e = (char) ('A' + Integer.parseInt( s.substring(0,2)) - 1);

                ans.add(e+en);
            }
        }

        return ans;

    }
}
