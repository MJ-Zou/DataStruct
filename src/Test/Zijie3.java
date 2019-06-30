package Test;

import java.util.Scanner;

public class Zijie3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        int[] ints = toIntArr(str1);
        int len=ints[0];
        int start=ints[1];
        int[] scores = toIntArr(str2);
        if (scores[start-1]==0){
            System.out.println(-1);
        }

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
