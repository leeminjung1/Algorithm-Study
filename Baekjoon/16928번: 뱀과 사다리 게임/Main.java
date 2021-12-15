import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static final int max = 100;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] board = new int[max + 1];
        int[] cnt = new int[max + 1];
        boolean[] visited = new boolean[max + 1];
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= max; i++) {
            board[i] = i;
        }
        for (int i = 0; i < n + m; i++) {
            st = new StringTokenizer(br.readLine());
            board[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        while (!queue.isEmpty()) {
            int i = queue.poll();
            for (int j = 1; j <= 6; j++) {
                if (i + j > max) break;
                int next = board[i + j];
                if(next <= max && !visited[next]) {
                    queue.offer(next);
                    visited[next] = true;
                    cnt[next] = cnt[i] + 1;
                    if (next == max) {
                        System.out.println(cnt[max]);
                        return;
                    }
                }
            }
        }
    }

}
