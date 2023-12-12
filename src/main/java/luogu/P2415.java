package luogu;

import java.util.Scanner;

public class P2415 {
    public static void main(String[] args) {
        Scanner sr = new Scanner(System.in);
        while (sr.hasNext()){
            String inputStr=sr.next();
        }
        int n = sr.nextInt();
        int a = 2;
        for (int i = 4; i <= n; i += 2) {
            while (a <= i) {
                int b = i - a;
                if (zhishu(a) && zhishu(b) && a <= b) {
                    System.out.println(i + "=" + a + "+" + b);
                    a += 1;
                    break;

                } else {
                    a += 1;
                }
            }
            a = 2;
        }
    }

    public static boolean zhishu(int num) {
        int i = 2;
        int qwe = (int) Math.sqrt(num);
        while (i <= qwe) {
            if (num % i == 0) {
                return false;
            }
            i++;
        }
        return true;
    }
}
