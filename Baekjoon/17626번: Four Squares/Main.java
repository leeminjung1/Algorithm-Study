import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(solve(Integer.parseInt(br.readLine())));
    }

    private static int solve(int n) {
        int max = (int) (Math.sqrt(n) + 1.5);
        for (int b = 0; b < max; ++b) {
            for (int c = b; c < max; ++c) {
                for (int d = c; d < max; ++d) {
                    if (b * b + c * c + d * d != n) {
                        continue;
                    }
                    if (c == 0) {
                        return 1;
                    }
                    if (b == 0) {
                        return 2;
                    }
                    return 3;
                }
            }
        }
        return 4;
    }
}
