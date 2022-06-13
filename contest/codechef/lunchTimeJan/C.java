package contest.codechef.lunchTimeJan;

import java.util.Scanner;
import java.util.*;
public class C {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);


        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(1,0);
        map.put(2,(1^2) + (2^1));

        for(int i = 3 ; i <= 10000000; i+= 2) {
            int x = map.get(i-1);
            map.put(i, x+ (i^i));
            map.put(i+1,x+2*(i^(i+1)));
        }
        int t = sc.nextInt();

        while(t-- > 0) {
            System.out.println(map.get(sc.nextInt()));
        }

    }
}
