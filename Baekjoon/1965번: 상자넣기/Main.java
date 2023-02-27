import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] dp = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = arr[0];
        int cnt = 1;
        int next, low, high, mid;
        for (int i = 1; i < n; i++) {
            next = arr[i];
            if (dp[cnt - 1] < next) {
                dp[cnt++] = next;
            } else {
                low = 0;
                high = cnt - 1;
                while (low < high) {
                    mid = (low + high) / 2;
                    if (dp[mid] < next) {
                        low = mid + 1;
                    } else {
                        high = mid;
                    }
                }
                dp[low] = next;
            }

        }
        System.out.println(cnt);
    }
}
