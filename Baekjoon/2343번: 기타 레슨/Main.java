import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] time = new int[n];
        int left = 0, right = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            time[i] = Integer.parseInt(st.nextToken());
            right += time[i];
            left = Math.max(left, time[i]);
        }

        while (left <= right) {
            int mid = (left + right) / 2;
            int cnt = 0;
            int sum = 0;

            for (int i = 0; i < n; i++) {
                if (sum + time[i] > mid) {
                    sum = 0;
                    cnt++;
                }
                sum += time[i];
            }

            if (cnt < m) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(left);
    }
}
