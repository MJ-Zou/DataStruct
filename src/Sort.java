import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sort {

    //***********************************************//
    //1.冒泡排序
    private static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    //2.选择排序
    private static void selectSort(int[] arr) {
        int n = arr.length;
        int min;
        int i_min;
        for (int i = 0; i < n - 1; i++) {
            min = arr[i];
            i_min = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < min) {
                    min = arr[j];
                    i_min = j;
                }
            }
            if (i != i_min) {
                swap(arr, i, i_min);
            }
        }
    }

    //3.直接插入排序
    private static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int j = i;
            while (j > 0 && arr[j] < arr[j - 1]) {
                swap(arr, j, j - 1);
                j--;
            }
        }
    }

    //**************************************************************//
    //4.希尔排序(改进直接插入排序)
    static void xier(List<Integer> list) {
        int n = list.size();
        int increment = n;
        while (increment > 1) {
            increment = increment / 3 + 1;
            for (int i = 0; i + increment < n; i++) {
                if (list.get(i + increment) < list.get(i)) {
                    swap(list, i, i + increment);
                }
            }
        }
    }

    /*
    5.堆排序(改进选择排序)
        大顶堆
    */
    /*

    6.归并排序
        二合一
    */

    //7.快速排序(改进冒泡排序)
    static void kuaisu(List<Integer> list) {
        int n = list.size();
        subKuaisu(list, 0, n - 1);
    }

    static void subKuaisu(List<Integer> list, int start, int stop) {
        if (stop - start < 1) {
            return;
        }
        int base = list.get(start);
        int i = start;
        int j = stop;
        while (i != j) {
            while (list.get(j) >= base && j > i) {
                j--;
            }
            while (list.get(i) <= base && i < j) {
                i++;
            }
            if (i == j) {
                break;
            }
            swap(list, i, j);
        }
        swap(list, i, start);

        subKuaisu(list, start, i - 1);
        subKuaisu(list, i + 1, stop);

    }


    //创建数组
    static List<Integer> createList(String string) {
        List list = new ArrayList();
        char[] chars = string.toCharArray();
        for (char c : chars) {
            list.add(Integer.parseInt(String.valueOf(c)));
        }
        return list;
    }

    //交换
    static void swap(List<Integer> list, int i, int j) {
        int temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr1 = {5, 4, 6, 8, 5, 4, 1, 8, 6};
        System.out.println(Arrays.toString(arr1));
        bubbleSort(arr1);
        System.out.println(Arrays.toString(arr1));

        int[] arr2 = {1, 7, 3, 2, 8, 1, 5, 3, 7, 1, 3, 78, 4, 6, 8, 9};
        System.out.println(Arrays.toString(arr2));
        selectSort(arr2);
        System.out.println(Arrays.toString(arr2));

        int[] arr3 = {4, 0, 5, 7, 3, 2, 89, 3, 6, 1};
        System.out.println(Arrays.toString(arr3));
        insertionSort(arr3);
        System.out.println(Arrays.toString(arr3));
//
//        list = createList("12371865477984132");
//        System.out.println(list);
//        xier(list);
//        System.out.println(list);
//
//        list = createList("71358758146");
//        System.out.println(list);
//        kuaisu(list);
//        System.out.println(list);
    }
}
