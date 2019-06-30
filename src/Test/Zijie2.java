package Test;

import java.util.Scanner;

public class Zijie2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = Integer.valueOf(sc.nextLine());
        String str = sc.nextLine();
        System.out.println(str);
        int[] scores = toIntArr(str);
        int[] nums = new int[len];
        nums[0] = 1;
        for (int i = 1; i < len; i++) {
            if (scores[i] > scores[i - 1]) {
                nums[i] = nums[i - 1] + 1;
            } else {
                nums[i] = 1;
            }
        }
        for (int i = len - 2; i >= 0; i--) {
            if (scores[i] > scores[i + 1] && nums[i] <= nums[i + 1]) {
                nums[i] = nums[i + 1] + 1;
            }
        }
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        System.out.println(sum);

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
