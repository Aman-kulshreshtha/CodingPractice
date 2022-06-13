package DSA.Algorithms.Recursion;

public class reverseArray {

    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4, 5, 6 };
        reverseArray(arr, 0, arr.length - 1);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    private static void reverseArray(int[] arr, int i, int j) {

        if (i >= j)
            return;

        reverseArray(arr, i + 1, j - 1);
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

        return;
    }

}
