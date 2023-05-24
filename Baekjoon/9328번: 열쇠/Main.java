import java.util.*;
import java.io.*;

public class Main {

    static int t;
    static int h, w;
    static char[][] map;
    static boolean[][] visited;
    static boolean[] keys;
    static int[][] dir = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            h = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            map = new char[h + 4][w + 4];
            visited = new boolean[h + 4][w + 4];
            keys = new boolean[26];

            Arrays.fill(map[0], '*');
            Arrays.fill(map[h + 3], '*');
            Arrays.fill(map[1], '.');
            Arrays.fill(map[h + 2], '.');
            for (int i = 1; i < h + 3; i++) {
                map[i][0] = '*';
                map[i][w + 3] = '*';
                map[i][1] = '.';
                map[i][w + 2] = '.';
            }

            for (int i = 2; i < h + 2; i++) {
                for (int j = 2; j < w + 2; j++) {
                    map[i][j] = (char) br.read();
                }
                br.read();
            }

            int c;
            while ((c = br.read()) > 32) {
                if (c != '0') keys[c - 'a'] = true;
            }

            sb.append(bfs()).append('\n');
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    private static int bfs() {
        Queue<int[]> queue = new LinkedList<>();
        Queue<int[]>[] gates = new LinkedList[26];
        for (int i = 0; i < 26; i++) {
            gates[i] = new LinkedList<>();
        }

        queue.offer(new int[] {1, 1});
        visited[1][1] = true;

        int result = 0;
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int[] d : dir) {
                int ny = cur[0] + d[0];
                int nx = cur[1] + d[1];

                if (visited[ny][nx] || map[ny][nx] == '*') continue;

                char c = map[ny][nx];

                if (c >= 'a') {
                    keys[c - 'a'] = true;
                    while (!gates[c - 'a'].isEmpty()) {
                        queue.offer(gates[c - 'a'].poll());
                    }
                } else if (c >= 'A') {
                    if (keys[c - 'A']) {
                        queue.offer(new int[]{ny, nx});
                    } else {
                        gates[c - 'A'].offer(new int[]{ny, nx});
                    }
                    visited[ny][nx] = true;
                    continue;
                } else if (c == '$') {
                    result++;
                }

                visited[ny][nx] = true;
                queue.offer(new int[]{ny, nx});
            }
        }

        return result;
    }
}
