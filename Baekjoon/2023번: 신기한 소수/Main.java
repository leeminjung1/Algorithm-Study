import java.io.IOException;

public class Main {
    static int n;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        n = System.in.read() + 1 - '1';
        dfs(2, 1);
        dfs(3, 1);
        dfs(5, 1);
        dfs(7, 1);
        System.out.println(sb);
    }

    static void dfs(int num, int digit) {
        if (digit == n) {
            sb.append(num).append('\n');
            return;
        }
        for (int i = 1; i < 10; i++) {
            int tmp = 10 * num + i;
            if (isPrime(tmp)) {
                dfs(tmp, digit + 1);
            }
        }
    }

    static boolean isPrime(int n) {
        if (n < 2) return false;

        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }
}
