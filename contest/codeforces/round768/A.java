package contest.codeforces.round768;
import java.util.*;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t--> 0) {

            int n = sc.nextInt();
            int[] a = new int[n];
            int[] b= new int[n];
            int maxA= Integer.MIN_VALUE;
            int maxB = Integer.MIN_VALUE;

            for (int i = 0; i < n; i++) {

                a[i] = sc.nextInt();
                maxA = Math.max(maxA,a[i]);

            }

            for (int i = 0; i < n; i++) {
                b[i] = sc.nextInt();
                maxB = Math.max(maxB,b[i]);
            }

            if(maxA > maxB) {
                boolean isSwapped = false;
                int index;
                do {
                    index = 0;
                    for(int i = 0 ; i < n ; i++) {
                        if(b[i] > b[index]) {
                            index = i;
                        }
                    }

                    if(a[index] < b[index]) {
                        int temp = a[index];
                        a[index] = b[index];
                        b[index] = temp;
                        isSwapped = true;
                    }
                }while(isSwapped);
                System.out.println(maxA*b[index]);

            }else {
                boolean isSwapped = false;
                int index;
                do {
                    index = 0;
                    for(int i = 0 ; i < n ; i++) {
                        if(b[i] > a[index]) {
                            index = i;
                        }
                    }

                    if(b[index] < a[index]) {
                        int temp = a[index];
                        a[index] = b[index];
                        b[index] = temp;
                        isSwapped = true;
                    }
                }while(isSwapped);
                System.out.println(maxB*a[index]);
            }


        }

    }
}
