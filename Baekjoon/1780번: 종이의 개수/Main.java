import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] matrix;
    static int zero = 0, one = 0, minus = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        matrix = new int[n][n];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        check(0, 0, n);
        System.out.println(minus);
        System.out.println(zero);
        System.out.println(one);
    }

    private static void check(int r, int c, int size) {
        int flag = matrix[r][c];
        for (int i = r; i < r + size; i++) {
            for (int j = c; j < c + size; j++) {
                if (matrix[i][j] != flag) {
                    size /= 3;
                    for (int a = 0; a < 3; a++) {
                        for (int b = 0; b < 3; b++) {
                            check(r + a * size, c + b * size, size);
                        }
                    }
                    return;
                }
            }
        }
        if (flag == 1) one++;
        if (flag == 0) zero++;
        if (flag == -1) minus++;
    }
}
