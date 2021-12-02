import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println(Math.min(powerOfN(5, n), powerOfN(2, n)));
    }
    private static int powerOfN(int n, int x) {
        int cnt = 0;
        while (x >= n) {
            cnt += x/n;
            x /= n;
        }
        return cnt;
    }
}
