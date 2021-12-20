import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Shark {
        int x, y, size, fishCnt;

        public Shark(int x, int y, int size, int fishCnt) {
            this.x = x;
            this.y = y;
            this.size = size;
            this.fishCnt = fishCnt;
        }
    }

    static int N;
    static Shark shark;
    static int[][] map;
    static int[][] move = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    shark = new Shark(i, j, 2, 0);
                    map[i][j] = 0;
                }
            }
        }
        System.out.println(bfs());
    }

    private static int bfs() {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(shark.x, shark.y));
        boolean[][] visit = new boolean[N][N];
        visit[shark.x][shark.y] = true;
        int ans = 0;
        int time = 0;
        while (!queue.isEmpty()) {
            boolean fish = false;
            int fi = N;
            int fj = N;
            int qSize = queue.size();
            for (int s = 0; s < qSize; s++) {
                Point p = queue.poll();
                for (int d = 0; d < 4; d++) {
                    int x = p.x + move[d][0];
                    int y = p.y + move[d][1];
                    if (x < 0 || x >= N || y < 0 || y >= N || map[x][y] > shark.size || visit[x][y]) continue;
                    queue.add(new Point(x, y));
                    visit[x][y] = true;
                    if (map[x][y] > 0 && map[x][y] < shark.size) {
                        fish = true;
                        if (x == fi && y < fj) {
                            fj = y;
                        } else if (x < fi) {
                            fi = x;
                            fj = y;
                        }
                    }
                }
            }
            time++;
            if (fish) {
                map[fi][fj] = 0;
                if (shark.size == shark.fishCnt + 1) {
                    shark = new Shark(fi, fj, shark.size + 1, 0);
                } else {
                    shark = new Shark(fi, fj, shark.size, shark.fishCnt + 1);
                }
                queue = new LinkedList<>();
                visit = new boolean[N][N];
                queue.add(new Point(fi, fj));
                visit[fi][fj] = true;
                ans += time;
                time = 0;
            }
        }
        return ans;
    }

}

