package Netease;

import java.util.*;

public class Netease1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] strs = str.split(" ");
        List<String> list = new ArrayList<>();
        for (String s : strs) {
            boolean flag = true;
            List<String> ss = new ArrayList<>();
            int j = 0;
            for (int i = 0; i < s.length(); i++) {
                if (!(Character.isDigit(s.charAt(i)) || Character.isLetter(s.charAt(i)))) {
                    flag = false;
                    ss.add(s.substring(j, i));
                    ss.add(s.substring(i, i + 1));
                    j = i + 1;
                }
            }
            ss.add(s.substring(j));
            if (!flag) {
                Collections.reverse(ss);
                s = ss.toString();
                s = s.substring(1, s.length() - 1);
                s = s.replace(", ", "");
            }

//            if (s.charAt(s.length() - 1) < 65 || s.charAt(s.length() - 1) > 122) {
//                s = s.charAt(s.length() - 1) + s.substring(0, s.length() - 1);
//            }

            list.add(s);

        }
        Collections.reverse(list);
        String result = list.toString();
        result = result.substring(1, result.length() - 1);
        result = result.replace(", ", " ");
        System.out.println(result);
    }
}
