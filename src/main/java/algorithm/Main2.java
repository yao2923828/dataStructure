package algorithm;

import java.util.Arrays;
import java.util.Scanner;

public class Main2 {
        public static void main(String[] args) {
            Scanner sr = new Scanner(System.in);
            int[] arr = new int[3];
            String [] numStrs=sr.nextLine().split(" ");
            for(int i=0;i<numStrs.length;i++){
                arr[i]=Integer.parseInt(numStrs[i]);
            }
            Arrays.sort(arr);
            String a = sr.nextLine();
            for (int i = 0; i <= 2; i++) {
                char ch = a.charAt(i);
                if (ch == 'A') {
                    System.out.print(arr[0] + " ");
                } else if (ch == 'B') {
                    System.out.print(arr[1] + " ");
                } else {
                    System.out.print(arr[2] + " ");
                }
            }
        }
}
