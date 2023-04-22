import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long[] solutions = new long[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            solutions[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(solutions);
        
        long min = 3_000_000_000L;
        int[] ans = new int[3];
        for (int i = 0; i < n - 2; i++) {
            int l = i + 1;
            int r = n - 1;
            while (l < r) {
                long sum = solutions[i] + solutions[l] + solutions[r];

                if (Math.abs(sum) < min) {
                    min = Math.abs(sum);
                    ans[0] = i;
                    ans[1] = l;
                    ans[2] = r;
                }
                if (sum == 0) {
                    i = n - 2;
                    break;
                }
                if (sum > 0) {
                    r--;
                } else {
                    l++;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int a : ans) {
            sb.append(solutions[a]).append(' ');
        }
        System.out.println(sb);
    }
}
