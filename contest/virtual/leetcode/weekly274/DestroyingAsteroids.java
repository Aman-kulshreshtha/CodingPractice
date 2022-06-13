package contest.virtual.leetcode.weekly274;

import java.util.*;

public class DestroyingAsteroids {
    public static void main(String[] args) {
        int mass = 5;
        int[] asteroids = { 4, 9, 23, 4 };
        System.out.println(asteroidsDestroyed(mass, asteroids));

    }

    public static boolean asteroidsDestroyed(int mass, int[] asteroids) {

        Arrays.sort(asteroids);

        int extra = 0;
        int[] sum = new int[asteroids.length];
        sum[0] = asteroids[0];
        for (int i = 1; i < asteroids.length; i++) {
            sum[i] = sum[i - 1] + asteroids[i];
        }

        int ans = binSearch(asteroids, 0, asteroids.length - 1, mass);

        while (ans >= 0 && ans < asteroids.length - 1) {
            extra = sum[ans] - extra;

            int newKey = mass + extra;
            ans = binSearch(asteroids, ans + 1, asteroids.length - 1, newKey);

        }

        if (ans == -1)
            return false;
        else
            return true;

    }

    private static int binSearch(int[] arr, int l, int r, int key) {
        int ans = -1;
        while (l <= r) {

            int mid = l + (r - l) / 2;
            if (arr[mid] <= key) {
                ans = mid;
                l = mid + 1;
            } else
                r = mid - 1;
        }

        return ans;

    }

}
