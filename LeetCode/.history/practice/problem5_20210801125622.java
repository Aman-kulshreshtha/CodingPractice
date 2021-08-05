import java.util.*;

class Problem5 {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
    }
     public String longestPalindrome(String s) {
        StringBuilder sb = new StringBuilder(s);
        sb = sb.reverse();
        String ans = "";
        int max = 0;
        String b = sb.reverse().toString();
        for(int i = 0 ; i < s.length() ; i++) {
            for(int j = i+1 ; j <= s.length(); j++) {
                if(b.contains(s.substring(i,j))) {
                    System.out.println(s.substring(i,j));
                    if(s.substring(i,j).length() > max ){
                        max = s.substring(i,j).length();
                        ans = s.substring(i,j);
                    }
                }
            }
        }
        
        return ans;
        
    }
    

}

