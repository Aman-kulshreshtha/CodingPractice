package DSA.TopicPractice.Graph;

import java.util.*;

import contest.codeforces.round768.A;

public class ShortestPath {

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
            adj.get(b).add(a);
        }

        System.out.println(shortestDistance(adj, 1, 5));

        sc.close();
        System.exit(0);
    }

    private static ArrayList<Integer> shortestDistance(ArrayList<ArrayList<Integer>> adj, int source, int destination) {
        // undirected graph

        int[] parent = new int[adj.size()];
        parent[source] = -1;

        Queue<Integer> q = new ArrayDeque<>();
        int[] dist = new int[adj.size()];

        Arrays.fill(dist, -1);
        dist[source] = 0;
        q.add(source);
        boolean[] visited = new boolean[adj.size()];

        while (!q.isEmpty()) {
            int node = q.remove();

            if (!visited[node]) {
                visited[node] = true;
                for (int x : adj.get(node)) {

                    if (!visited[x]) {

                        if (dist[x] == -1) {

                            dist[x] = dist[node] + 1;
                            parent[x] = node;

                        } else {
                            if (dist[node] + 1 < dist[x]) {
                                dist[x] = dist[node] + 1;
                                parent[x] = node;
                            }
                        }

                        q.add(x);

                    }

                }

            }

        }

        Stack<Integer> ans = new Stack<>();
        for (int i = destination; i != -1; i = parent[i]) {
            ans.push(i);
        }
        ArrayList<Integer> a = new ArrayList<>();
        while (!ans.isEmpty()) {
            a.add(ans.pop());
        }
        return a;
    }

}
