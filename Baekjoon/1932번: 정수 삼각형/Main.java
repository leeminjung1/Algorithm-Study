import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] sum = new int[2][n];

        sum[0][0] = Integer.parseInt(br.readLine()); // first

        for (int i = 1; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            sum[1][0] = Integer.parseInt(st.nextToken()) + sum[0][0];
            for (int j = 1; j <= i; j++) {
                sum[1][j] = Integer.parseInt(st.nextToken()) + Math.max(sum[0][j], sum[0][j-1]);
            }
            sum[0] = sum[1].clone();
        }

        int max = sum[0][0];
        for (int j = 1; j < n; j++) {
            max = Math.max(max, sum[0][j]);
        }
        System.out.println(max);

    }

}
