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
        int[][] a = new int[n][m];
        int[][] b = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                a[i][j] = br.read() - '0';
            }
            br.read();
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                b[i][j] = br.read() - '0';
            }
            br.read();
        }

        int cnt = 0;

        for (int i = 0; i < n - 2; i++) {
            for (int j = 0; j < m - 2; j++) {
                if (a[i][j] != b[i][j]) {
                    cnt++;
                    for (int k = 0; k < 3; k++) {
                        for (int l = 0; l < 3; l++) {
                            a[i + k][j + l] = a[i + k][j + l] == 0 ? 1 : 0;
                        }
                    }

                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i][j] != b[i][j]) {
                    System.out.println(-1);
                    return;
                }
            }
        }

        System.out.println(cnt);

    }
}
