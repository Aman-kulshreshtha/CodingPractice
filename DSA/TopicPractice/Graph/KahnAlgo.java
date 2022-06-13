package DSA.TopicPractice.Graph;

import java.util.*;

public class KahnAlgo {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int V = sc.nextInt(), E = sc.nextInt();

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            int a = sc.nextInt(), b = sc.nextInt();
            adj.get(a).add(b);

        }

        System.out.println(topo(adj));

        sc.close();
        System.exit(0);

    }

    private static ArrayList<Integer> topo(ArrayList<ArrayList<Integer>> adj) {

        ArrayList<Integer> ans = new ArrayList<>();
        int n = adj.size();

        Queue<Integer> q = new ArrayDeque<>();
        int[] inDegree = new int[n];
        for (int i = 0; i < n; i++) {
            for (int x : adj.get(i)) {
                inDegree[x]++;
            }
        }
        for (int i = 0; i < n; i++) {

            if (inDegree[i] == 0) {
                q.add(i);
            }

        }
        while (!q.isEmpty()) {
            int node = q.remove();
            ans.add(node);
            for (int x : adj.get(node)) {
                inDegree[x]--;
                if (inDegree[x] == 0) {
                    q.add(x);
                }
            }
        }

        return ans;
    }

}
