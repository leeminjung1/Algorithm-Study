import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static int[][] board;
    static List<int[]> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        board = new int[9][9];
        for (int i = 0; i < 9; i++) {
            String s = br.readLine();
            for (int j = 0; j < 9; j++) {
                board[i][j] = s.charAt(j) - '0';
                if (board[i][j] == 0) {
                    list.add(new int[]{i, j});
                }
            }
        }

        dfs(0);
    }

    private static void dfs(int idx) {
        if (list.size() == idx || idx == 81) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    System.out.print(board[i][j]);
                }
                System.out.println();
            }
            System.exit(0);
        }

        boolean[] visit = new boolean[10];
        int x = list.get(idx)[0];
        int y = list.get(idx)[1];
        for (int i = 0; i < 9; i++) {
            visit[board[x][i]] = true;
            visit[board[i][y]] = true;
        }

        int ix = x / 3 * 3;
        int iy = y / 3 * 3;
        for (int i = ix; i < ix + 3; i++) {
            for (int j = iy; j < iy + 3; j++) {
                visit[board[i][j]] = true;
            }
        }

        for (int i = 1; i < 10; i++) {
            if (!visit[i]) {
                board[x][y] = i;
                dfs(idx + 1);
                board[x][y] = 0;
            }
        }
    }
}
