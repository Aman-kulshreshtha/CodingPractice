package Days30Companies6.adobe;

import java.util.*;
public class NextGreaterPalindrome {

    public static void main(String[] args) {
        String num = "9213129";
        System.out.println(nextPalin(num));


    }

    public static String nextPalin(String N)
    {
        boolean found = false;
        StringBuilder ans = new StringBuilder();
        int n = N.length();
        char[] str= N.toCharArray();
        int mid = (n/2)-1;

        if(nextPermutation(str,0,mid)) {
            for(int i = 0; i <= mid; i++) {
                str[n-1-i] = str[i];
            }

            for(char ch : str) {
                ans.append(ch);
            }

            return ans.toString();

        }else {
            return "-1";
        }


    }


    private static boolean nextPermutation(char[] str, int start, int end) {

        int j = end-1;

        //find the peek and j points the element to the left of peek in case of no peek j becomes equal to start
        while(j >= start) {
            if(str[j] < str[j+1]) {
                break;
            }else {
                j--;
            }
        }

        //if j == start no peek that means return a false;
        if(j < start) return false;

        //find next element just greater than j this will always exist
        int k = end;
        while(k > j && str[j] >=  str[k]) {
            k--;
        }

        //interchange j and k
        char temp = str[j];
        str[j] = str[k];
        str[k] = temp;


        //reverse everything after j
        for(j =j+1; j < end;j++,end--) {
            temp = str[j];
            str[j] = str[end];
            str[end] = temp;
        }

        return true;
    }
}
