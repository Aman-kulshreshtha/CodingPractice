package StriverDSASheet.day1;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
    private static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();

        if(numRows == 0) {
            return ans;
        }

        if(numRows == 1) {
            ans.add(List.of(1));
            return ans;
        }

        if(numRows == 2) {
            ans.add(List.of(1,1));
            return ans;
        }

        List<List<Integer>> prev = generate(numRows-1);

        List<Integer> a = new ArrayList<>();
        a.add(1);
        List<Integer> prevList = prev.get(prev.size()-1);

        for(int i = 0 ; i < prevList.size()-1;i++) {
            a.add( prevList.get(i) + prevList.get(i+1) );
        }

        a.add(1);

        prev.add(a);
        return prev;

    }
}
