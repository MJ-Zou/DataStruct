package Huawei;

import java.util.*;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> input = new ArrayList<>();
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            if(s.equals(".")){
                break;
            }
            input.add(s);
        }

        Set<String> result1 = new LinkedHashSet<>();
        List<String> result2 = new ArrayList<>();
        List<String> result3 = new ArrayList<>();

        char c;
        boolean flag;
        for (String str : input) {
            flag = true;
            for (int i = 0; i < str.length(); i++) {
                c = str.charAt(i);
                if (!(Character.isLetter(c) || Character.isDigit(c))) {
                    result2.add(str);
                    flag = false;
                    break;
                }
            }
            if (flag) {
                result1.add(str);
            }
        }

        for (String str : result1) {
            char[] chars = str.toCharArray();
            LinkedList<Character> s = new LinkedList<>();
            for (char cc : chars) {
                s.add(cc);
            }
            for (int i = 0; i < 10; i++) {
                s.addLast(s.removeFirst());
            }
            StringBuilder newStr = new StringBuilder();
            for (char cc : s) {
                newStr.append(cc);
            }
            result3.add(newStr.toString());
        }

        List<String> result4 = new ArrayList<>(result3);
        Collections.sort(result4);

        shuChu(result1);
        shuChu(result2);
        shuChu(result3);
        shuChu(result4);
    }

    private static void shuChu(Collection co) {
        String r = co.toString();
        r = r.replace(", ", " ");
        r = r.substring(1, r.length() - 1);
        System.out.println(r);
    }


}
