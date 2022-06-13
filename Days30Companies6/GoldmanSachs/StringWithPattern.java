package Days30Companies6.GoldmanSachs;

import java.util.*;

public class StringWithPattern {
    public static void main(String[] args) {
        
        int a;


    }

    static String printMinNumberForPattern(String S){
        int n = S.length();
        int[] num = new int[n+1];
        int number = 1 ;
        
        int idx = 0 ; 
        while(true) {

            while(S.charAt(idx) != 'D' && idx < n ) {
                idx++;
                number++;
            }
        
            if(idx == n) {
                
                idx = 0 ; 
                while(idx < n ) {
                    num[idx++] = number++;               
                }
                break;
            
            }else {

                int start = idx;
                
                while(S.charAt(idx) == 'D' && idx < n) {
                    idx++;
                }

                number = fillTrench(num, start, idx, number);
                idx++;
                
            }

        }
       
        return "";
    }

    private static int fillTrench(int[] num, int i, int j, int number) {

        for (int ptr = j; ptr >= i; ptr--) {
            num[ptr] = number++;
        }

        return number;
    }

}
