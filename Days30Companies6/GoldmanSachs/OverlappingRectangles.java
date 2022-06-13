package Days30Companies6.GoldmanSachs;

// Problem link https://practice.geeksforgeeks.org/problems/overlapping-rectangles1924/1/

import java.util.*;

public class OverlappingRectangles {

    int doOverlap(int L1[], int R1[], int L2[], int R2[]) {
        boolean ans1 = isOverlap(L1[0], R1[0], L2[0], R2[0]);
        boolean ans2 = isOverlap(L1[1], R1[1], L2[1], R2[1]);

        if (ans1 && ans2)
            return 1;
        else if (ans1 && (L1[1] == L2[1] || L1[1] == R2[1] || R1[1] == L2[1] || R1[1] == R2[1]))
            return 1;
        else if (ans2 && (L1[0] == L2[0] || L1[0] == R2[0] || R1[0] == L2[0] || R1[0] == R2[0]))
            return 1;
        else
            return 0;

    }

    private static boolean isOverlap(int x1, int y1, int x2, int y2) {
        if ((Math.min(x1, y1) < x2 && x2 < Math.max(x1, y1)) || (Math.min(x1, y1) < y2 && y2 < Math.max(x1, y1)))
            return true;

        if ((Math.min(x2, y2) < x1 && x1 < Math.max(x2, y2)) || (Math.min(x2, y2) < y1 && y1 < Math.max(x2, y2)))
            return true;

        return false;
    }
}
