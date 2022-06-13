package DSA.TopicPractice.Graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class PrintAllPath {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = inputGraph();
        printAllPath(adj,0,6,new HashSet<>(),0 + "");
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

    private static void printAllPath(ArrayList<ArrayList<Integer>> adj, int source, int dest,HashSet<Integer> set,String pathSOFar) {

        if(source == dest) {
            System.out.println(pathSOFar);
            return;
        }

        set.add(source);

        for(int x : adj.get(source)) {
            if(!set.contains(x)) {
                printAllPath(adj,x,dest,set,pathSOFar+"->"+x);
            }
        }

        set.remove(source);

    }


}
