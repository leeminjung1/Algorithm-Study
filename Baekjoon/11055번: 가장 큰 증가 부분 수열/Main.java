import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];
        int[] lis = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            lis[i] = arr[i];
        }

        int max = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                if (arr[j] < arr[i]) lis[i] = Math.max(lis[i], lis[j] + arr[i]);
                max = Math.max(max, lis[i]);
                System.out.println(Arrays.toString(lis));
            }
        }

        System.out.println(max);

    }
}
