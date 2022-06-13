package contest.virtual.Codeforces.round766;

import java.util.*;

public class C {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {

            int n = sc.nextInt();
            Map<Integer, List<Integer>> adj = new HashMap<>();

            for (int i = 1; i <= n; i++) {
                adj.put(i, new ArrayList<>());
            }

            ArrayList<Edge> edges = new ArrayList<>();

            for (int i = 0; i < n - 1; i++) {

                int a = sc.nextInt(), b = sc.nextInt();
                edges.add(new Edge(Math.min(a, b), Math.max(a, b)));
                adj.get(a).add(b);
                adj.get(b).add(a);

            }

            boolean isPossible = true;

            for (int i = 1; i <= n; i++) {
                if (adj.get(i).size() > 2) {
                    isPossible = false;
                    break;
                }
            }

            if (!isPossible) {
                System.out.println("-1");

            } else {

                Set<Integer> two = new HashSet<>();
                Set<Integer> three = new HashSet<>();

                for (Edge e : edges) {

                    int a = e.first;
                    int b = e.second;

                    if (!two.contains(a) && !two.contains(b)) {

                        e.weight = 2;
                        two.add(a);
                        two.add(b);

                    } else if (!three.contains(a) && !three.contains(b)) {

                        three.add(a);
                        three.add(b);
                        e.weight = 3;

                    } else if (two.contains(a) && two.contains(b)) {
                        e.weight = 3;
                        three.add(a);
                        three.add(b);
                    } else if (three.contains(a) && three.contains(b)) {
                        e.weight = 2;
                        two.add(a);
                        two.add(b);
                    } else {
                        System.out.println("-1");
                        break;

                    }

                }

                for (Edge e : edges) {
                    System.out.print(e.weight + " ");

                }

                System.out.println();

            }

        }

    }

}

class Edge {

    int first;
    int second;
    int weight;

    public Edge(int f, int s) {
        first = f;
        second = s;
        weight = -1;
    }
}