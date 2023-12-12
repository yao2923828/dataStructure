package luogu;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class P5738 {
    public static void main(String[] args) {
        Scanner sr = new Scanner(System.in);
        int n = sr.nextInt();//n<=100
        int m = sr.nextInt();//m<=20

        int[][] arr = new int[n][m];
        double [] maxmax = new double[n];
        int[] max1 = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sr.nextInt();
                max1[i] = max1[i] + arr[i][j];
            }
        }
        double maxScore=0;
        for (int i = 0; i < n; i++) {
            int max=0,min=Integer.MAX_VALUE;
            for (int j = 0; j < m; j++) {
                if (arr[i][j] > max) {
                    max=arr[i][j];
                }
                if (arr[i][j] < min) {
                    min=arr[i][j];
                }
            }
            BigDecimal bd1 = new BigDecimal(max1[i] - max - min);

            maxmax[i] = bd1.divide(new BigDecimal(m - 2),3,RoundingMode.HALF_UP).doubleValue();
            if(maxmax[i]>maxScore){
                maxScore=maxmax[i];
            }
        }
        System.out.println(String.format("%.2f", maxScore));
    }
}
