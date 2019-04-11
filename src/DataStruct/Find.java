package DataStruct;

import java.util.ArrayList;
import java.util.List;

public class Find {
    //*************************无序查找*********************************//
    //改进顺序查找 不用for循环反复判断
    static int shunxu(List<Integer> list, int x) {
        int n = list.size();
        list.set(0, x);
        int i = n - 1;
        while (list.get(i) != x) {
            i--;
        }
        return i;
    }

    //****************************有序查找**************************************//
    //折半/二分查找
    static int zheban(List<Integer> list, int x) {
        int n = list.size();
        int min = 0;
        int max = n - 1;

        while (min <= max) {
            int loc = (min + max) / 2;
//            差值查找/按比例查找，适合大量均匀数据
//            int loc = min + (max - min) *
//                    (x - list.get(min)) / (list.get(max) - list.get(min));
            //斐波那契查找
            if (list.get(loc) == x) {
                return loc;
            } else if (list.get(loc) > x) {
                max = loc - 1;
            } else if (list.get(loc) < x) {
                min = loc + 1;
            }
        }
        return -1;
    }

    //创建数组
    static List<Integer> createList(String string) {
        List list = new ArrayList();
        String[] split = string.split(",");
        for (String str : split) {
            list.add(Integer.parseInt(String.valueOf(str)));
        }
        return list;
    }

    public static void main(String[] args) {
        List<Integer> list = createList("-1,879,454,5,17,4531,132,4");
        System.out.println(list);
        System.out.println(shunxu(list, 4531));

        list = createList("1,12,123,1234,4567,8451,9412");
        System.out.println(list);
        System.out.println(zheban(list, 12));
    }
}
