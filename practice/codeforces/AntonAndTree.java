package practice.codeforces;

import java.util.*;

public class AntonAndTree {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int v = sc.nextInt();

        int[] color = new int[v];
        for (int i = 0; i < v; i++) {
            color[i] = sc.nextInt();
        }

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < v; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < v - 1; i++) {
            int a = sc.nextInt(), b = sc.nextInt();
            adj.get(a - 1).add(b - 1);
            adj.get(b - 1).add(a - 1);
        }

        boolean[] visBlack = new boolean[v];
        boolean[] visWhite = new boolean[v];

        for (int i = 0; i < v; i++) {
            if (color[i] == 0) {
                visWhite[i] = true;
            } else {
                visBlack[i] = true;
            }
        }

        int ans1 = 0, ans2 = 0;

        // coloring white to black ans stored in ans1
        // using visBlack array

        for (int i = 0; i < v; i++) {
            if (!visBlack[i]) {
                dfs(adj, i, visBlack);
                ans1++;
            }

        }

        System.out.println(ans1);

        // coloring black vertices white ans stored in ans2
        // using visWhite array
        for (int i = 0; i < v; i++) {
            if (!visWhite[i]) {
                dfs(adj, i, visWhite);
                ans2++;
            }

        }
        System.out.println(ans2);

        System.out.println(Math.min(ans1, ans2));

        sc.close();
        System.exit(0);
    }

    private static void dfs(List<List<Integer>> adj, int s, boolean[] visArr) {

        visArr[s] = true;
        for (int x : adj.get(s)) {
            if (!visArr[x]) {
                dfs(adj, x, visArr);
            }
        }
        return;

    }
}
