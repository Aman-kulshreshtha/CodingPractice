package contest.codechef.starter23;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t =sc.nextInt();
        while(t-- > 0) {
            int x = sc.nextInt();
            int sum = 3*x;
            int a = 1,b = 2, c = sum-3;
            System.out.println(a +" "+b+ " "+c);

        }
    }
}
