package luogu;
import java.io.*;

public class P2249 {
    public static void main(String[] args) throws Exception {
        Reader sr=new Reader();
        int n = sr.nextInt();
        int m = sr.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sr.nextInt();
        }
        for (int i = 0; i < m; i++) {
            int a = sr.nextInt();
            System.out.print(search(arr,a,n)+" ");
        }
    }
    public static int search(int arr[], int target,int n) {
        int i = 0;
        int j = n-1;
        int candidate = -1;
        while (i < j) {
            int mid = (i + j) >> 1;
            if (target <= arr[mid]) {
                j = mid;
            } else if (arr[mid] < target) {
                i = mid + 1;
            }
        }
        if (arr[i] == target) {
            return i+1;
        }
        return candidate;
    }

    public static class Reader {
        StreamTokenizer sr=new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        public int nextInt() throws Exception{
            sr.nextToken();
            return (int) sr.nval;
        }
    }
}