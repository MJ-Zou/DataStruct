import java.util.*;


public class Main {


    static void combine(String chs[], List<LinkedList<String>> comb) {
        if (chs.length == 0) return;
        LinkedList<String>list=new LinkedList<>();
        for (int i = 1; i <= chs.length; i++) {
            combine(chs, 0, i, list, comb);
        }
    }

    static void combine(String[] chs, int begin, int number, LinkedList<String>list, List<LinkedList<String>> comb) {
        if (number == 0) {
            LinkedList<String> l = new LinkedList<>(list);
            comb.add(l);
            return;
        }
        if (begin == chs.length) {
            return;
        }
        list.push(chs[begin]);
        combine(chs, begin + 1, number - 1, list, comb);
        list.pop();
        combine(chs, begin + 1, number, list, comb);
    }


    public static void main(String[] args) {
        String[] s = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "10", "11"};
        List<LinkedList<String>> list = new ArrayList<>();
        combine(s, list);
        System.out.println(list.size());
    }

}



