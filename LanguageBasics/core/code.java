package LanguageBasics.core;

import java.util.Scanner;

public class code {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.println(sc.nextInt());
        }

        sc.close();
        System.exit(0);
    }
}