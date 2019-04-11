package DataStruct;

import java.math.BigInteger;
import java.util.*;

public class Binary {

    //通过整数生成二进制
    static List<Integer> toBinary(int num) {
        LinkedList<Integer> list = new LinkedList<>();
        if (num == 0) {
            list.add(0);
        }
        if (num < 0) {
            num = -num;
            //求出源码
            while (num != 0) {
                list.addFirst(num % 2);
                num = num / 2;
            }
            list.addFirst(1);
            System.out.println(list);
            //求出反码
            list = (LinkedList<Integer>) reverse(list);
            System.out.println(list);
            //加一得到补码
            list= (LinkedList<Integer>) addOne(list);
            return list;
        } else {
            while (num != 0) {
                list.addFirst(num % 2);
                num = num / 2;
            }
            list.addFirst(0);
            return list;
        }
    }

    //源码变反码 含符号位不变
    static List<Integer> reverse(LinkedList<Integer> num) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(num.get(0));
        for (int i = 1; i < num.size(); i++) {
            list.add(1 - num.get(i));
        }
        return list;
    }

    //加一
    static List<Integer> addOne(LinkedList<Integer> num) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(num.get(0));

        boolean flag = false;
        if (num.getLast()==1&&flag==true){
            list.add(1,1);
            flag=true;
        }
        else if (num.getLast()==1&&flag==false){
            list.add(1,0);
            flag=true;
        }
        else if (num.getLast()==0&&flag==true){
            list.add(1,0);
            flag=true;
        }
        else if (num.getLast()==0&&flag==false){
            list.add(1,1);
            flag=false;
        }

        for (int i = num.size()-2; i >0; i--) {
            if (num.get(i)==1&&flag==true){
                list.add(1,0);
                flag=true;
            }
            else if (num.get(i)==1&&flag==false){
                list.add(1,1);
                flag=false;
            }
            else if (num.get(i)==0&&flag==true){
                list.add(1,1);
                flag=false;
            }
            else if (num.get(i)==0&&flag==false){
                list.add(1,0);
                flag=false;
            }
        }
        return list;
    }

    public static void main(String[] args) {
//        System.out.println(toBinary(97));
//        System.out.println(toBinary(-2147483648));
    }
}
