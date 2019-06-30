package Test;

import java.util.*;

public class WeBank3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
        String s = sc.nextLine();
        int[] ints = toIntArr(s);

        for (int i : ints) {
            int k = i;
            int sum = 0;
            boolean b = true;
            Set<Integer> set = new HashSet<>();
            set.add(k);
            while (k != 1) {
                if (k % 2 == 0) {
                    k = k / 2;
                } else {
                    k = 3 * k + 1;
                }
                b = set.add(k);
                sum++;
                if (!b) {
                    System.out.println(-1);
                    break;
                }
            }
            if (!b){
                continue;
            }
            System.out.println(sum);
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
