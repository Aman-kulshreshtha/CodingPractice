package DSA.Algorithms.Recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LetterCombination {
    private static List<String> letterCombinations(String digits) {
        HashMap<Character,String> map = new HashMap<>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");

        return generate(digits,digits.length(),map);

    }

    private static List<String> generate(String digit,int n,HashMap<Character,String> map ) {
        if(n == 0) {
            List<String> ans = new ArrayList<>();
            ans.add("");
            return ans;
        }

        List<String> prev = generate(digit,n-1,map);
        List<String> ans = new ArrayList<>();
        for(String s : prev ) {
            String symbols = map.get(digit.charAt(n-1));
            for(int i = 0 ; i < symbols.length(); i++) {
                ans.add(s+symbols.charAt(i));
            }
        }

        return ans;
    }
}
