package Test;

import java.util.*;

public class Huawei1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Integer n = new Integer(sc.nextLine());
        List<String> input = new ArrayList<>();
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            if(s.equals(".")){
                break;
            }
            input.add(s);
        }

        List<int[]> list = new ArrayList<>();
        for (String s : input) {
            list.add(toIntArr(s));
        }

        List<Integer> result = new ArrayList<>();
        int st = 0;
        int row = 0;
        int flag = 1;
        while (true) {
            for (int i = st; i < st + n; i++) {
                if (i < list.get(row).length) {
                    result.add(list.get(row)[i]);
                    flag =  0;
                } else {
                    break;
                }
            }
            row++;
            if (flag == 1 && row == list.size()) {
                break;
            }
            if (row == list.size()) {
                st = st + n;
                row = 0;
                flag = 1;
            }
        }
        String s = result.toString();
        s = s.replace(" ", "");
        s=s.substring(1, s.length() - 1);
        System.out.println(s);
    }


    private static int[] toIntArr(String str) {
        String[] strings = str.split(",");
        int[] arr = new int[strings.length];
        for (int i = 0; i < strings.length; i++) {
            arr[i] = new Integer(strings[i]);
        }
        return arr;
    }


}
