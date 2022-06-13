package StriverDSASheet.day2;

import java.util.ArrayList;

public class MergeIntervals {
    private static int[][] merge(int[][] intervals) {
        ArrayList<Pair> ans = new ArrayList<>();

        for(int[] interval:intervals) {
            boolean merged = false;
            for(Pair p : ans) {

                if(overlap(interval,p)) {
                    
                }

            }
        }

        return null;
    }

    private static boolean overlap(int[] interval,Pair p) {
        int a= Math.min(interval[0],interval[1]),
        b = Math.max(interval[0],interval[1]),
        c =Math.min(p.first,p.second),
        d =Math.max(p.first,p.second);


        if(a<= c && c <= b && b <= d) return true;
        if(c <= a && a <= d && d <= b) return true;
        if(a <= c && d <= b) return true;
        if(c <= a && b <= d) return true;

        return false;
    }
}

class Pair {
    int first;
    int second;

    public Pair(int f , int s) {
        first = f;
        second = s;
    }
}