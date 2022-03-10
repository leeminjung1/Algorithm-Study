import java.io.*;
import java.util.Arrays;

public class Main {

    static char[][] star;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        star = new char[n][(n << 1) - 1];

        for (char[] chars : star) {
            Arrays.fill(chars, ' ');
        }

        make(n, 0, n - 1);
        for (char[] s : star) {
            bw.write(s);
            bw.write("\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static void make(int n, int y, int x) {
        if (n == 3) {
            star[y][x] = '*';
            star[y + 1][x + 1] = '*';
            star[y + 1][x - 1] = '*';
            for (int i = -2; i < 3; i++) {
                star[y + 2][x + i] = '*';
            }
            return;
        }

        n >>= 1;
        make(n, y, x);
        make(n, y + n, x - n);
        make(n, y + n, x + n);
    }
}
