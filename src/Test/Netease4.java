package Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Netease4 {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String str = sc.nextLine();
//        int[] weights = toIntArr(str);
        int[] weights={3,1,5,8};


        List<int[]> list = new ArrayList<>();
        int[] shunxu = new int[weights.length];
        for (int i = 0; i < weights.length; i++) {
            shunxu[i] = i;
        }
        allSort(shunxu, 0, weights.length - 1, list);

        int max = 0;
        for (int[] sx : list) {
            List<Integer> eggs = new ArrayList<>();
            for (int w : weights) {
                eggs.add(w);
            }
            int value = 0;
            for (int i : sx) {
                value += eggs.get(i) * getPre(i - 1, eggs) * getNext(i+1, eggs);
                eggs.set(i, -1);
            }
            if (value > max) {
                max = value;
            }
        }
        System.out.println(max);
    }

    private static Integer getPre(int i, List<Integer> eggs) {
        if (i == -1) {
            return 1;
        } else {
            while (i > -1) {
                if (eggs.get(i) == -1) {
                    i--;
                } else {
                    return eggs.get(i);
                }
            }
            return 1;
        }
    }

    private static Integer getNext(int i, List<Integer> eggs) {
        if (i == eggs.size()) {
            return 1;
        } else {
            while (i < eggs.size()) {
                if (eggs.get(i) == -1) {
                    i++;
                } else {
                    return eggs.get(i);
                }
            }
            return 1;
        }
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
