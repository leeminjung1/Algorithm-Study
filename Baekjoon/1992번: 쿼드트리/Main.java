import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[][] data;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        data = new int[n][n];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                data[i][j] = s.charAt(j) - '0';
            }
        }

        QuadTree(0, 0, n);
        System.out.println(sb);
    }

    private static void QuadTree(int r, int c, int size) {
        if (isPossible(r, c, size)) {
            sb.append(data[r][c]);
            return;
        }
        sb.append('(');
        size /= 2;
        QuadTree(r, c, size);
        QuadTree(r, c + size, size);
        QuadTree(r + size, c, size);
        QuadTree(r + size, c + size, size);
        sb.append(')');
    }

    private static boolean isPossible(int r, int c, int size) {
        int flag = data[r][c];
        for (int i = r; i < r + size; i++) {
            for (int j = c; j < c + size; j++) {
                if (data[i][j] != flag) return false;
            }
        }
        return true;
    }
}
