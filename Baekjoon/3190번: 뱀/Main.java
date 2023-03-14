import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int[][] dir = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] board = new int[n + 1][n + 1];
        for (int[] ints : board) {
            Arrays.fill(ints, -1);
        }

        int k = Integer.parseInt(br.readLine());
        StringTokenizer st;
        while (k-- > 0) {
            st = new StringTokenizer(br.readLine());
            board[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = -2;
        }
        int l = Integer.parseInt(br.readLine());
        int[] t = new int[10001];
        while (l-- > 0) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            char c = st.nextToken().charAt(0);
            if (c == 'D') {
                t[x] = 1;
            } else if (c == 'L') {
                t[x] = 3;
            }
        }

        int s = 1;
        int si = 1, sj = 1, ei = 1, ej = 1;
        int d = 0;
        board[si][sj] = d;
        for (; s <= 10000; s++) {
            int nx = si + dir[d][0];
            int ny = sj + dir[d][1];

            if (nx <= 0 || ny <= 0 || nx > n || ny > n || board[nx][ny] >= 0) {
                break;
            }

            if (board[nx][ny] != -2) {
                int tail = board[ei][ej];
                board[ei][ej] = -1;
                ei += dir[tail][0];
                ej += dir[tail][1];
            }
            d = (d + t[s]) % 4;
            board[nx][ny] = d;
            si = nx;
            sj = ny;
        }

        System.out.println(s);
    }
}
