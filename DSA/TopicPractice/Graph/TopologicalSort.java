package DSA.TopicPractice.Graph;

import java.util.*;

public class TopologicalSort {

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

        System.out.println(topoSort(adj));

        sc.close();
        System.exit(0);

    }

    private static ArrayList<Integer> topoSort(ArrayList<ArrayList<Integer>> adj) {
        Stack<Integer> st = new Stack<>();
        ArrayList<Integer> ans = new ArrayList<>();
        boolean[] visited = new boolean[adj.size()];
        for (int i = 0; i < adj.size(); i++) {
            if (!visited[i]) {
                dfsUtil(adj, i, st, visited);
            }
        }

        while (!st.isEmpty()) {
            ans.add(st.pop());
        }

        return ans;

    }

    private static void dfsUtil(ArrayList<ArrayList<Integer>> adj, int node, Stack<Integer> st, boolean[] visited) {

        if (!visited[node]) {

            visited[node] = true;

            for (int x : adj.get(node)) {
                dfsUtil(adj, x, st, visited);
            }

            st.push(node);
        }

    }

}
