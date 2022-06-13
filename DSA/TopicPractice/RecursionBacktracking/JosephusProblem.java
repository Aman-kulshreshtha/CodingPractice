package DSA.TopicPractice.RecursionBacktracking;

public class JosephusProblem {
    public static void main(String[] args) {

        System.out.println(josephus(7, 4));

    }

    private static int josephus(int n, int k) {

        if (n == 1)
            return 0;

        int death = (k - 1) % n;

        int nextStart = (death + 1) % n;

        int ans = josephus(n - 1, k);

        int res = (nextStart + ans) % n;

        return res;
    }

}
