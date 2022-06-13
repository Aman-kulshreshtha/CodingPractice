package DSA.TopicPractice.Graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.*;

public class CycleDetectionUndirectedGraph {

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

        System.out.println(hasCycle(adj));

        sc.close();
        System.exit(0);

    }

    private static boolean hasCycle(List<List<Integer>> adj) {

        boolean[] visited = new boolean[adj.size()];
        int[] parent = new int[adj.size()];

        Queue<Integer> q = new ArrayDeque<>();

        for (int i = 0; i < adj.size(); i++) {

            if (!visited[i]) {

                visited[i] = true;
                q.add(i);

                while (!q.isEmpty()) {

                    int node = q.remove();
                    for (int x : adj.get(node)) {
                        parent[x] = node;
                        if (visited[x] && parent[node] != x) {
                            return true;
                        }

                        if (!visited[x]) {
                            visited[x] = true;
                            q.add(x);
                        }
                    }
                }
            }
        }

        return false;

    }

}
