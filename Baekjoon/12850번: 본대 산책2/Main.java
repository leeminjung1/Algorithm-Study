import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static final int MOD = 1000000007;
    static long[][] arr = {
            {0, 1, 0, 0, 0, 0, 0, 1},
            {1, 0, 1, 0, 0, 0, 0, 1},
            {0, 1, 0, 1, 0, 0, 1, 1},
            {0, 0, 1, 0, 1, 0, 1, 0},
            {0, 0, 0, 1, 0, 1, 0, 0},
            {0, 0, 0, 0, 1, 0, 1, 0},
            {0, 0, 1, 1, 0, 1, 0, 1},
            {1, 1, 1, 0, 0, 0, 1, 0}};
    static int n = 8;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int d = Integer.parseInt(br.readLine());
        long[][] ans = pow(d);
        System.out.println(ans[0][0]);
    }

    public static long[][] pow(int d) {
        if (d == 1) {
            return arr;
        }
        long[][] tmp = pow(d / 2);
        tmp = multiply(tmp, tmp);
        if (d % 2 == 1) {
            tmp = multiply(tmp, arr);
        }
        return tmp;
    }


    public static long[][] multiply(long[][] A, long[][] B) {
        long[][] C = new long[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    C[i][j] = (C[i][j] + (A[i][k] * B[k][j]) % MOD) % MOD;
                }
            }
        }

        return C;
    }
}
