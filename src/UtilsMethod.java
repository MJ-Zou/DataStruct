import java.util.*;


//工具方法11
public class UtilsMethod {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int[] ints = toIntArr(s);// s="1 2 3 4"

        List<int[]> list = new ArrayList<>();
        allSort(ints, 0, ints.length - 1, list);

        List<LinkedList<Integer>> list1 = new ArrayList<>();
        combine(ints, list1);
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

    //全排列
    private static void allSort(int[] array, int begin, int end, List<int[]> list) {
        if (begin == end) {
            list.add(Arrays.copyOf(array, array.length));
            return;
        }
        for (int i = begin; i <= end; i++) {
            swap(array, begin, i);
            allSort(array, begin + 1, end, list);
            swap(array, begin, i);
        }
    }

    //交换
    private static void swap(int[] array, int a, int b) {
        int tem = array[a];
        array[a] = array[b];
        array[b] = tem;
    }

    //全组合
    private static void combine(int[] chs, List<LinkedList<Integer>> comb) {
        if (chs.length == 0) return;
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 1; i <= chs.length; i++) {
            combine(chs, 0, i, list, comb);
        }
    }

    private static void combine(int[] chs, int begin, int number, LinkedList<Integer> list, List<LinkedList<Integer>> comb) {
        if (number == 0) {
            LinkedList<Integer> l = new LinkedList<>(list);
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
}
