package DSA.TopicPractice.Graph;
import java.util.*;
public class HasPath {


    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = inputGraph();
        System.out.println(hasPath(adj,0,6,new boolean[adj.size()]));

    }

    private static ArrayList<ArrayList<Integer>> inputGraph() {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int E = sc.nextInt();
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0 ; i < V ; i++) {
            adj.add(new ArrayList<>());
        }

        for(int i = 0 ; i < E; i++) {
            int a = sc.nextInt(),b = sc.nextInt();
            adj.get(b).add(a);
            adj.get(a).add(b);
        }

        return adj;
    }

    private static boolean hasPath(ArrayList<ArrayList<Integer>> adj, int source, int destination, boolean[] visited) {

        if(source == destination) {
            return true;
        }

        boolean ans = false;
        visited[source] = true;

        for(int x : adj.get(source)) {

            if(!visited[x]) {
                ans |= hasPath(adj,x,destination,visited);
            }
        }

        return ans;
    }
}
