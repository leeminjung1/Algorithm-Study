import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class DFS {
    private static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        answer = Integer.MAX_VALUE;
        dfs(n, k, 0);
        System.out.println(answer);
    }

    private static void dfs(int n, int k, int count) {
        if( n >= k ) {
            count += n - k;
            answer = Math.min(answer, count);
            return;
        }

        dfs(n, n, count + k - n);

        if( n == 0 ) {
            n = 1;
            count++;
        }

        if( k % 2 == 1 ) {
            dfs(n, k + 1, count + 1);
            dfs(n, k - 1, count + 1);
        }
        else {
            dfs(n, k / 2, count + 1);
        }

    }
}
