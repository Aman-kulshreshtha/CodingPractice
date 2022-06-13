package contest.codechef.codeDrive;

import java.util.*;

public class q3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int ans = 0;

            int n = sc.nextInt();
            // System.out.println(getAll(n));

            List<List<Integer>> allArrays = getAll(n);

            if (n <= 2)
                System.out.println(0);
            else {

                for (List<Integer> arr : allArrays) {
                    int x = 0;
                    for (int i = 1; i < arr.size() - 1; i++) {
                        if ((arr.get(i) > arr.get(i - 1) && arr.get(i) > arr.get(i + 1))
                                || (arr.get(i) < arr.get(i - 1) && arr.get(i) < arr.get(i + 1))) {
                            x++;
                        }
                    }
                    ans += x;
                }
                System.out.println(ans);

            }

        }

    }

    private static List<List<Integer>> getAll(int n) {
        List<List<Integer>> ans = new ArrayList<>();
        if (n <= 0)
            return ans;
        else if (n == 1) {
            List<Integer> a = new ArrayList<>();
            a.add(0);
            List<Integer> b = new ArrayList<>();
            b.add(1);
            List<Integer> c = new ArrayList<>();
            c.add(2);
            ans.add(a);
            ans.add(b);
            ans.add(c);
            return ans;

        } else {
            List<List<Integer>> prev = getAll(n - 1);
            List<List<Integer>> prev2 = new ArrayList<>();
            prev2.addAll(prev);
            List<List<Integer>> prev3 = new ArrayList<>();
            prev3.addAll(prev);

            for (List<Integer> l : prev) {
                ArrayList<Integer> temp = new ArrayList<>(l);
                temp.add(0);
                ans.add(temp);
            }
            for (List<Integer> l : prev2) {
                ArrayList<Integer> temp = new ArrayList<>(l);
                temp.add(1);
                ans.add(temp);
            }
            for (List<Integer> l : prev3) {
                ArrayList<Integer> temp = new ArrayList<>(l);
                temp.add(2);
                ans.add(temp);
            }

            return ans;
        }
    }
}
