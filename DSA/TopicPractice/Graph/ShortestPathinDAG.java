package DSA.TopicPractice.Graph;

import java.util.*;

public class ShortestPathinDAG {

    private static int shortestPath(ArrayList<ArrayList<Pair>> adj, int source, int dest) {
        ArrayList<Integer> topoSort = topo(adj);

        int[] dist = new int[adj.size()];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source] = 0;

        return -1;
    }

    private static ArrayList<Integer> topo(ArrayList<ArrayList<Pair>> adj) {

        int n = adj.size();
        int[] inDegree = new int[adj.size()];
        ArrayList<Integer> result = new ArrayList<>();

        for (ArrayList<Pair> li : adj) {
            for (Pair p : li) {
                inDegree[p.first]++;
            }
        }

        Queue<Integer> q = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {

            int node = q.remove();
            result.add(node);

            for (Pair x : adj.get(node)) {
                inDegree[x.first]--;
                if (inDegree[x.first] == 0) {
                    q.add(x.first);
                }
            }

        }
        return result;
    }

}

class Pair {
    int first, second;

    Pair(int f, int s) {
        first = f;
        second = s;
    }
}