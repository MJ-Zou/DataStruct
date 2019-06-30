package Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Zijie1 {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int len=sc.nextInt();
        List<Integer>list=new ArrayList<>(len);
        int i=0;
        while (i<len){
            i++;
            list.add(sc.nextInt());
        }
        int k=sc.nextInt();
        if (k>=len){
            System.out.println("null");
            return;
        }
        System.out.println(list.get(len-1-k));
    }
}
