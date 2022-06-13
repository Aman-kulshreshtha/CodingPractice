package contest.codechef.lunchTimeJan;
import java.util.*;

public class A {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();

            if(k < 2) {
                if(n == 1) {
                    System.out.println("1");
                }else {
                    System.out.println("-1");
                }

            }else {

                int[] ans = new int[n];
                int i = 0;
                for(int z = 1 ; z < k;z++ ) {
                    ans[i++] = z;
                }

                for(int z = n ; i < n ; z--,i++) {
                    ans[i] = z;
                }

                for(int x : ans) {
                    System.out.print(x+ " ");
                }
                System.out.println();
            }


        }
    }
}
