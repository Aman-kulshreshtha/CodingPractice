package DSA.TopicPractice.Graph;

import java.util.*;

public class CycleDetectionInDirectedGraph {

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

        System.out.println(isCycleDirectedDFS(adj));

        sc.close();
        System.exit(0);
    }

    private static boolean isCycleDirectedDFS(ArrayList<ArrayList<Integer>> adj) {

        boolean ans = false;
        boolean[] visited = new boolean[adj.size()];
        boolean[] dfsVisited = new boolean[adj.size()];

        for (int i = 0; i < adj.size(); i++) {
            if (!visited[i])
                ans |= dfsUtil(adj, i, visited, dfsVisited);
        }

        return ans;

    }

    private static boolean dfsUtil(ArrayList<ArrayList<Integer>> adj, int node, boolean[] visited,
            boolean[] dfsVisited) {
        if (visited[node]) {

            dfsVisited[node] = false;
            return false;
        }

        dfsVisited[node] = true;
        visited[node] = true;

        boolean ans = false;

        for (int x : adj.get(node)) {

            if (dfsVisited[x])
                return true;
            if (!visited[x]) {

                if (dfsVisited[x])
                    return true;

                ans |= dfsUtil((adj), x, visited, dfsVisited);

            }
        }

        dfsVisited[node] = false;
        return ans;
    }

}
