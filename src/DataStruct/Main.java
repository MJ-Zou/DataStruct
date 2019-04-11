package DataStruct;

import java.util.Arrays;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
//        int[] arr = {1, 2, 4, 1, 7, 8, 3, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
//        System.out.println(optt(arr, arr.length - 1));
//        System.out.println(opt(arr, arr.length - 1));

        int[] arr1 = {3, 34, 4, 12, 5, 2};
        int s = 13;
        System.out.println(subSet(arr1, arr1.length - 1, s));
        System.out.println(subSett(arr1, arr1.length - 1, s));


    }

    private static boolean subSet(int[] arr, int i, int s) {
        if (s == 0) {
            return true;
        }
        if (i == 0) {
            return arr[i] == s;
        }
        boolean a = subSet(arr, i - 1, s - arr[i]);
        boolean b = subSet(arr, i - 1, s);
        return a || b;
    }

    private static boolean subSett(int[] arr, int i, int s) {
        if (s == 0) {
            return true;
        }
        boolean[][] sub = new boolean[arr.length][s + 1];
        for (int j = 1; j < arr.length; j++) {
            sub[j][0] = true;
        }
        for (int k = 0; k <= s; k++) {
            sub[0][k] = arr[0] == k;
        }
        for (int j = 1; j < arr.length; j++) {
            for (int k = 1; k <= s; k++) {
                if (arr[j] > k) {
                    sub[j][k] = sub[j - 1][k];
                } else {
                    boolean a = sub[j - 1][k - arr[j]];
                    boolean b = sub[j - 1][k];
                    sub[j][k] = a || b;
                }
            }
        }
        return sub[i][s];
    }

    private static int opt(int[] arr, int i) {
        if (i == 0) {
            return arr[0];
        }
        if (i == 1) {
            return max(arr[0], arr[1]);
        }
        return max(opt(arr, i - 1), opt(arr, i - 2) + arr[i]);
    }

    private static int optt(int[] arr, int i) {
        int[] opt = new int[arr.length];
        opt[0] = arr[0];
        opt[1] = max(arr[0], arr[1]);
        for (int j = 2; j <= i; j++) {
            opt[j] = max(arr[j] + opt[j - 2], opt[j - 1]);
        }
        return opt[i];
    }

    private static int max(int a, int b) {
        return a > b ? a : b;
    }


}



