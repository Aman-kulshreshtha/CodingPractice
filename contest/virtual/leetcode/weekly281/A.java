package contest.virtual.leetcode.weekly281;

import java.util.*;
public class A {
    public static void main(String[] args) {

    }

    public int countEven(int num) {
        int count=0;
        for(int i = 1;i <= num ; i++) {
            int sum = digSUm(i);
            if(sum%2 == 0) {
                count++;
            }
        }
        return count;
    }

    private static int digSUm(int n ) {
        int sum = 0;

        while(n != 0) {
            sum += n%10;
            n = n/10;
        }
        return sum;
    }
}
