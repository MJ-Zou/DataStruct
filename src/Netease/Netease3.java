package Netease;

import java.util.*;

public class Netease3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String[] str1s = str1.split(" ");
        Long num = new Long(str1s[0]);
        Long maxW = new Long(str1s[1]);

        String str2 = sc.nextLine();
        int[] weights = toIntArr(str2);
        List<int[]> list = new ArrayList<>();
        allSort(weights, 0, weights.length - 1, list);

        int bad = 0;
        for (int[] w : list) {
            int i = 0;
            int curW = 0;
            while (i < num) {
                if (i == num - 1) {
                    i++;
                    curW++;
                } else {
                    if (w[i] + w[i + 1] <= maxW) {
                        i = i + 2;
                        curW++;
                    } else {
                        i++;
                        curW++;
                    }
                }
            }
            if (curW > bad) {
                bad = curW;
            }
        }
        System.out.println(bad);
    }

    //带空格的字符串转数组
    static int[] toIntArr(String str) {
        String[] strings = str.split(" ");
        int[] arr = new int[strings.length];
        for (int i = 0; i < strings.length; i++) {
            arr[i] = new Integer(strings[i]);
        }
        return arr;
    }

    //全排列
    static void allSort(int[] array, int begin, int end, List<int[]> list) {
        if (begin == end) {
            list.add(Arrays.copyOf(array, array.length));
            return;
        }
        for (int i = begin; i <= end; i++) {
            swap(array, begin, i);
            allSort(array, begin + 1, end, list);
            swap(array, begin, i);
        }
        return;
    }

    //交换
    static void swap(int[] array, int a, int b) {
        int tem = array[a];
        array[a] = array[b];
        array[b] = tem;
    }
}
