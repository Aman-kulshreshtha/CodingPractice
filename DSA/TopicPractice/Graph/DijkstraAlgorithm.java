package DSA.TopicPractice.Graph;

import java.util.*;

public class DijkstraAlgorithm {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int V = sc.nextInt(), E = sc.nextInt();

        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt();
            adj.get(a).add(new Pair(b, c));
            adj.get(b).add(new Pair(a, c));
        }

        System.out.println(dijkstra(V, adj, 1));

        sc.close();
        System.exit(0);
    }

    private static ArrayList<Integer> dijkstra(int V, ArrayList<ArrayList<Pair>> adj, int S) {

        int n = adj.size();
        int[] dist = new int[n];

        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[S] = 0;

        Set<Integer> visited = new HashSet<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>((o1, o2) -> o1.first - o2.first);
        pq.add(new Pair(0, S));
        while (!pq.isEmpty()) {
            Pair current = pq.remove();
            visited.add(current.second);

            for (Pair x : adj.get(current.second)) {
                if (!visited.contains(x.first)) {

                    if (dist[current.second] + x.second < dist[x.first]) {
                        dist[x.first] = dist[current.second] + x.second;
                        pq.add(new Pair(dist[x.first], x.first));
                    }

                }
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();
        for (int x : dist) {
            ans.add(x);
        }

        System.out.println(ans);

        return ans;
    }
}

class Pair {
    int first, second;

    Pair(int f, int s) {
        first = f;
        second = s;
    }
}
