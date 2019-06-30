package Test;

import java.util.LinkedList;
import java.util.Scanner;

public class WeBank1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int[] ints = toIntArr(s);
        long n = ints[0];
        int m = ints[1];

        if (n == 1) {
            System.out.println(" ");
            System.out.println(1);
            return;
        }
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int loc = 0;
        while (list.size() > 1) {
            if (loc >= list.size()) {
                loc = 0;
            }
            for (int i = 0; i < m - 1; i++) {
                loc = loc + 1;
                if (loc >= list.size()) {
                    loc = 0;
                }
            }
            if (list.size() == 2) {
                System.out.print(list.remove(loc) + 1);
            } else {
                System.out.print(list.remove(loc) + 1 + " ");
            }

        }
        System.out.println();
        System.out.println(list.getFirst() + 1);


    }


    //带空格的字符串转数组
    private static int[] toIntArr(String str) {
        String[] strings = str.split(" ");
        int[] arr = new int[strings.length];
        for (int i = 0; i < strings.length; i++) {
            arr[i] = new Integer(strings[i]);
        }
        return arr;
    }


}
