package DSA.TopicPractice.Graph;

import java.util.*;

public class BFS {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int V = sc.nextInt(), E = sc.nextInt();

        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            int a = sc.nextInt(), b = sc.nextInt();
            adj.get(a).add(b);
            adj.get(b).add(a);
        }

        bfs2(adj);
        sc.close();
        System.exit(0);
    }

    private static ArrayList<Integer> bfs(List<List<Integer>> adj) {
        int V = adj.size();
        boolean[] visited = new boolean[V];
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                q.add(i);
                while (!q.isEmpty()) {
                    int n = q.remove();
                    visited[n] = true;
                    ans.add(n);
                    for (int x : adj.get(n)) {
                        if (!visited[x]) {
                            q.add(x);
                        }
                    }
                }
            }
        }
        return ans;
    }

    private static void bfs2(List<List<Integer>> adj) {

        Queue<Integer> q = new ArrayDeque<>();

        boolean[] visited = new boolean[adj.size()];

        for (int i = 0; i < adj.size(); i++) {

            if (!visited[i]) {

                StringBuilder ans = new StringBuilder();
                q.add(i);
                while (!q.isEmpty()) {
                    int node = q.remove();
                    if (!visited[node]) {
                        visited[node] = true;
                        ans.append(node + "->");
                    }

                    for (int x : adj.get(node)) {
                        if (!visited[x]) {
                            q.add(x);
                        }
                    }
                }

                System.out.println(ans.toString().substring(0, ans.toString().length() - 2));

            }
        }

    }
}
