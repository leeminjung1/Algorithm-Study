import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Building {
        int num;
        Building pre;

        public Building(int num, Building pre) {
            this.num = num;
            this.pre = pre;
        }
    }

    static int n;
    static int[] dp, time;
    static Building[] build;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        build = new Building[n + 1];
        time = new int[n + 1];
        dp = new int[n + 1];

        for (int i = 1; i < n + 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());
            while (true) {
                int x = Integer.parseInt(st.nextToken());
                if (x == -1) {
                    break;
                }
                build[i] = new Building(x, build[i]);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < n + 1; i++) {
            sb.append(dfs(i)).append('\n');
        }
        System.out.println(sb);
    }

    private static int dfs(int num) {
        if (dp[num] != 0) {
            return dp[num];
        }

        dp[num] = time[num];

        int need = 0;

        for (Building pre = build[num]; pre != null; pre = pre.pre) {
            need = Math.max(need, dfs(pre.num));
        }

        return dp[num] += need;
    }
}
