import java.io.*;
import java.util.*;

public class Main {

    static class Pos {
        int r, c;

        public Pos(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    static int ans = Integer.MAX_VALUE;
    static int N, M;
    static int nHouse, nChicken;
    static int[] selected;
    static int[][] distance = new int[13][100];
    static Pos[] chicken, house;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        chicken = new Pos[13];
        house = new Pos[100];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                char c = s.charAt(2 * j);
                if (c == '1') {
                    house[nHouse++] = new Pos(i, j);
                } else if (c == '2') {
                    chicken[nChicken++] = new Pos(i, j);
                }
            }
        }

        for (int i = 0; i < nChicken; i++) {
            for (int j = 0; j < nHouse; j++) {
                distance[i][j] = Math.abs(chicken[i].r - house[j].r) + Math.abs(chicken[i].c - house[j].c);
            }
        }

        selected = new int[M];
        dfs(0, 0);

        System.out.println(ans);

    }

    private static void dfs(int start, int depth) {
        if (depth == M) {
            updateMin();
            return;
        }

        for (int i = start; i < nChicken; i++) {
            selected[depth] = i;
            dfs(i + 1, depth + 1);
        }

    }

    private static void updateMin() {
        int sum = 0;

        for (int i = 0; i < nHouse; i++) {
            int min = 101;
            for (int j = 0; j < M; j++) {
                if (distance[selected[j]][i] < min) {
                    min = distance[selected[j]][i];
                }
            }
            sum += min;
        }

        if (sum < ans) ans = sum;
    }

}
