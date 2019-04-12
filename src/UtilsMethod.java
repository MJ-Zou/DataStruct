import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


//工具方法11
public class UtilsMethod {

    public static void main(String[] args) {
        int[] ints = toIntArr("1 2 3 4");

        List<int[]> list = new ArrayList<>();
        allSort(ints, 0, ints.length - 1, list);

        String[] chs = {"1", "2", "3"};
        List<LinkedList<String>> linkedLists = new ArrayList<>();
        combine(chs, linkedLists);
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
    static void combine(String chs[], List<LinkedList<String>> comb) {
        if (chs.length == 0) return;
        LinkedList<String> list = new LinkedList<>();
        for (int i = 1; i <= chs.length; i++) {
            combine(chs, 0, i, list, comb);
        }
    }

    private static void combine(String[] chs, int begin, int number, LinkedList<String> list, List<LinkedList<String>> comb) {
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
}
