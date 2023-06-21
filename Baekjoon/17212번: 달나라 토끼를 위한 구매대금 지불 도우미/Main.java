import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int q = n / 7;
        int r = n % 7;
        int[] dp = new int[]{0, 1, 1, 1, 2, 1, 2};

        if (n == 3) {
            System.out.println(2);
        } else {
            System.out.println(q + dp[r]);
        }
    }
}
