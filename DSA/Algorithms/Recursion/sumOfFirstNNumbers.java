package DSA.Algorithms.Recursion;

public class sumOfFirstNNumbers {
    public static void main(String[] args) {
        printSum(6, 0);

    }

    private static void printSum(int i, int sum) {
        if (i < 0) {
            System.out.println(sum);
            return;
        }

        printSum(i - 1, sum + i);

    }
}