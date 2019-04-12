import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println(GetUglyNumber_Solution(100));
    }


    private static int GetUglyNumber_Solution(int index) {
        int num = 0;
        int n = 0;
        while (num < index) {
            n++;
            while (!isUgly(n)) {
                n++;
            }
            num++;
        }
        return n;
    }

    private static boolean isUgly(int n) {
        while (n % 2 == 0) {
            n = n / 2;
        }
        while (n % 3 == 0) {
            n = n / 3;
        }
        while (n % 5 == 0) {
            n = n / 5;
        }
        return n == 1;
    }

}
