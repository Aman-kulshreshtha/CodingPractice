package DSA.TopicPractice.Graph;

import java.util.*;

public class PrimsAlgorithm {

    private static void MST(ArrayList<ArrayList<ArrayList<Integer>>> adj) {
        int n = adj.size();

        int[] parent = new int[n];
        boolean[] mst = new boolean[n];
        int[] key = new int[n];
        Arrays.fill(key, Integer.MAX_VALUE);

    }

}

class Pair {
    int vertex, weight;

    Pair(int v, int w) {
        vertex = v;
        weight = w;
    }
}
