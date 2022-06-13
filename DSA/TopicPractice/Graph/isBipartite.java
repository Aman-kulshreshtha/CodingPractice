package DSA.TopicPractice.Graph;

import java.util.*;

public class isBipartite {

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

        System.out.println(isBipartiteGraphBFS(adj));

        sc.close();
        System.exit(0);

    }

    private static boolean isBipartiteGraphBFS(List<List<Integer>> adj) {
        Queue<Integer> q = new ArrayDeque<>();
        int[] color = new int[adj.size()];
        Arrays.fill(color, -1);
        int currColor = 0;

        for (int i = 0; i < adj.size(); i++) {
            if (color[i] == -1) {
                color[i] = currColor;
                System.out.println("coloured " + i + " color: " + currColor);

                q.add(i);
                while (!q.isEmpty()) {
                    int node = q.remove();
                    currColor = color[node];

                    for (int x : adj.get(node)) {

                        if (color[x] == -1) {
                            color[x] = (currColor == 0) ? 1 : 0;
                            System.out.println("coloured " + x + " color: " + color[x]);
                            q.add(x);
                        } else {

                            if (color[node] == color[x])
                                return false;

                        }

                    }

                }

            }
        }

        for (int x : color) {
            System.out.print(x + " ");

        }
        System.out.println();

        return true;

    }
}
