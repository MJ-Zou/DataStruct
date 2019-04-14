package DataStruct;

import java.util.Arrays;

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
        int j;
        for (int i = 1; i < n; i++) {
            j = i;
            while (j > 0 && arr[j - 1] > arr[j]) {
                swap(arr, j - 1, j);
                j--;
            }
        }
    }

    //**************************************************************//
    //4.希尔排序(改进直接插入排序)
    private static void shellSort(int[] arr) {
        int n = arr.length;
        int increment = n / 2;
        int j;
        while (increment > 0) {
            for (int i = 0; i + increment < n; i++) {
                j = i;
                while (j >= 0 && arr[j] > arr[j + increment]) {
                    swap(arr, i, i + increment);
                    j = j - increment;
                }
            }
            increment = increment / 2;
        }
    }


    // 5.堆排序(改进选择排序)
    private static void heapSort(int[] arr) {

    }


    //6.归并排序
    private static void mergingSort(int[] arr) {
        int len = arr.length;
        int i;
        int incre = 1;
        while (incre < len) {
            i = 0;
            while (i + incre < len) {
                merging(arr, i, i + incre, i + 2 * incre - 1);
                i = i + 2 * incre;
            }
            incre *= 2;
        }
    }

    //归并
    private static void merging(int[] arr, int l, int m, int r) {
        if (r > arr.length) {
            r = arr.length - 1;
        }
        int len1 = m - l;
        int len2 = r - m + 1;
        int[] a = new int[len1];
        int[] b = new int[len2];
        System.arraycopy(arr, l, a, 0, len1);
        System.arraycopy(arr, m, b, 0, len2);
        int i = 0, j = 0, k = 0;
        while (k < len1 + len2) {
            try {
                arr[l + k] = a[i] < b[j] ? a[i++] : b[j++];
            } catch (Exception e) {
                if (i == len1) {
                    arr[l + k] = b[j++];
                } else {
                    arr[l + k] = a[i++];
                }
            } finally {
                k++;
            }
        }
    }

    //7.快速排序(改进冒泡排序)
    private static void quickSort(int[] arr, int start, int stop) {
        if (start >= stop) {
            return;
        }
        int mid = arr[start];
        int low = start;
        int high = stop;
        while (low < high) {
            while (mid <= arr[high] && low < high) {
                high--;
            }
            while (arr[low] <= mid && low < high) {
                low++;
            }
            if (low < high) {
                swap(arr, low, high);
            }

        }
        swap(arr, low, start);
        quickSort(arr, start, low - 1);
        quickSort(arr, high + 1, stop);
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        System.out.println("冒泡");
        int[] arr1 = {5, 4, 6, 8, 5, 4, 1, 8, 6};
        System.out.println(Arrays.toString(arr1));
        bubbleSort(arr1);
        System.out.println(Arrays.toString(arr1));

        System.out.println("选择");
        int[] arr2 = {1, 7, 3, 2, 8, 1, 5, 3, 7, 1, 3, 78, 4, 6, 8, 9};
        System.out.println(Arrays.toString(arr2));
        selectSort(arr2);
        System.out.println(Arrays.toString(arr2));

        System.out.println("插入");
        int[] arr3 = {4, 0, 5, 7, 3, 2, 89, 3, 6, 1};
        System.out.println(Arrays.toString(arr3));
        insertionSort(arr3);
        System.out.println(Arrays.toString(arr3));

        System.out.println("希尔");
        int[] arr4 = {1, 2, 3, 71, 8, 65, 47, 7, 9, 8, 4, 1, 3, 2};
        System.out.println(Arrays.toString(arr4));
        shellSort(arr4);
        System.out.println(Arrays.toString(arr4));

        System.out.println("归并");
        int[] arr = {0, 7, 8, 9, 8, 2, 1, 3, 4, 5, 0, 8};
        System.out.println(Arrays.toString(arr));
        mergingSort(arr);
        System.out.println(Arrays.toString(arr));

        System.out.println("快速");
        int[] arr5 = {7, 1, 3, 5, 87, 5, 8, 1, 4, 6};
        System.out.println(Arrays.toString(arr5));
        quickSort(arr5, 0, arr5.length - 1);
        System.out.println(Arrays.toString(arr5));


    }
}
