package DataStruct;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FullyArranged {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4};
        List<int[]> list = new ArrayList<>();
        allSort(array, 0, array.length - 1, list);
        System.out.println(list);
    }

    static void allSort(int[] array, int begin, int end, List<int[]> list) {

        //打印数组的内容
        if (begin == end) {
            list.add(Arrays.copyOf(array, array.length));
            return;
        }
        //把子数组的第一个元素依次和第二个、第三个元素交换位置
        for (int i = begin; i <= end; i++) {
            swap(array, begin, i);
            allSort(array, begin + 1, end, list);
            //交换回来
            swap(array, begin, i);
        }
        return;
    }

    static void swap(int[] array, int a, int b) {
        int tem = array[a];
        array[a] = array[b];
        array[b] = tem;
    }

}
