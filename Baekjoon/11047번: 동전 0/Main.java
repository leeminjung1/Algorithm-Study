import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Throwable {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] coin = new int[n];
        for (int i = 0; i < n; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }
        int sum = 0;
        for (int i = n - 1; i >= 0; i--) {
            if(coin[i] > k) continue;
            sum += k/coin[i];
            k -= coin[i] * (k / coin[i]);
            if(k == 0) {
                System.out.println(sum);
                return;
            }
        }
    }
}
