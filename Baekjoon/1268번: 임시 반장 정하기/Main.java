import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n + 1][5];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i + 1][0] = Integer.parseInt(st.nextToken());
            arr[i + 1][1] = Integer.parseInt(st.nextToken());
            arr[i + 1][2] = Integer.parseInt(st.nextToken());
            arr[i + 1][3] = Integer.parseInt(st.nextToken());
            arr[i + 1][4] = Integer.parseInt(st.nextToken());
        }

        int[] cnt = new int[n + 1];
        for (int i = 1; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (arr[i][0] == arr[j][0]
                    || arr[i][1] == arr[j][1]
                    || arr[i][2] == arr[j][2]
                    || arr[i][3] == arr[j][3]
                    || arr[i][4] == arr[j][4]) {
                    cnt[i]++;
                    cnt[j]++;
                }
            }
        }

        int ans = 1;
        int max = 0;
        for (int i = 1; i <= n; i++) {
            if (cnt[i] > max) {
                max = cnt[i];
                ans = i;
            }
        }

        System.out.println(ans);
    }
}
