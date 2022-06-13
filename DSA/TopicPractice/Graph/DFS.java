package DSA.TopicPractice.Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class DFS {

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

        printDFS(adj);
        sc.close();
        System.exit(0);
    }

    private static void printDFS(List<List<Integer>> adj) {

        Stack<Integer> st = new Stack<>();

        boolean[] visited = new boolean[adj.size() + 1];
        for (int i = 0; i < adj.size(); i++) {

            if (!visited[i]) {

                StringBuilder ans = new StringBuilder();

                visited[i] = true;
                st.push(i);

                while (!st.isEmpty()) {
                    int node = st.pop();
                    ans.append(node + "->");
                    for (int x : adj.get(node)) {
                        if (!visited[x]) {
                            visited[x] = true;
                            st.push(x);
                        }
                    }
                }

                String a = ans.toString();
                System.out.println(a.substring(0, a.length() - 2));

            }

        }

    }

    private static void dfs(ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> ans, int node, boolean[] visited) {
        if (!visited[node]) {
            visited[node] = true;

            ans.add(node);

            for (int x : adj.get((node))) {
                if (!visited[x]) {
                    dfs(adj, ans, x, visited);
                }
            }

        }
    }

}
