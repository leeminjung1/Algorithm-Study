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
        int[][] node = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) node[i][j] = 0;
                else node[i][j] = 5001;
            }
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            node[a][b] = node[b][a] = 1;
        }

        // 플로이드 와샬 알고리즘
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                if (k == i) continue;
                for (int j = 1; j <= n; j++) {
                    if (j == k || j == i) continue;
                    // 최단경로 초기화
                    node[i][j] = Math.min(node[i][j], node[i][k] + node[k][j]);
                }
            }
        }

        int min = Integer.MAX_VALUE;
        int person = 0;
        // 케빈 베이컨의 수가 가장 작은 인덱스를 탐색
        for (int i = 1; i <= n; i++) {
            int total = 0;
            for (int j = 1; j <= n; j++) {
                total += node[i][j];
            }
            if (min > total) {
                min = total;
                person = i;
            }
        }
        System.out.println(person);

    }
}
