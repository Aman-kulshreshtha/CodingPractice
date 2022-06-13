package Days30Companies6.microsoft;

import java.util.ArrayList;
import java.util.List;



public class PrerequisiteTasks {

    private static boolean isPossible(int N, int[][] prerequisites)
    {
        boolean[] visited = new boolean[N];
        boolean[] dfsVis = new boolean[N];
        boolean[] isCycle = new boolean[1];
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0 ; i < N ; i++) {
            adj.add(new ArrayList<>());
        }
        for(int[] pre : prerequisites) {
            adj.get(pre[0]).add(pre[1]);
        }
        solve(isCycle,adj,visited,dfsVis);
        return isCycle[0];

    }

    private static void solve(boolean[] isCycle, List<List<Integer>> adj, boolean[] visited,boolean[] dfsVis) {
        int N = adj.size();
        for(int i = 0 ; i < N; i++) {
            if(!visited[i]) {
                dfs(i,adj,visited,dfsVis,isCycle);
            }
        }
    }

    private static void dfs(int i ,List<List<Integer>> adj, boolean[] visited,boolean[] dfsVis,boolean[] isCycle) {
        visited[i] = true;
        dfsVis[i] = true;
        if(isCycle[0]) return;

        for(int x : adj.get(i)) {
            if(!visited[x]) {
                dfs(x, adj,visited,dfsVis,isCycle);
            }else if(dfsVis[x] && visited[x])  {
                isCycle[0] = true;
                return;
            }
        }

        dfsVis[i] = false;
    }
}
