import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static class Child {
        int parent;
        int sum;

        public Child(int parent, int sum) {
            this.parent = parent;
            this.sum = sum;
        }
    }

    public static Child[] children;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        children = new Child[n + 1];
        int[] dp = new int[k];

        st = new StringTokenizer(br.readLine());
        children[0] = new Child(0, 0);
        for (int i = 1; i < n + 1; i++) {
            children[i] = new Child(-1, Integer.parseInt(st.nextToken()));
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            merge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        for (Child c : children) {
            if (c.parent >= 0) continue;

            for (int j = k - 1; j >= -c.parent; j--) {
                dp[j] = Math.max(dp[j], dp[j + c.parent] + c.sum);
            }
        }
        
        System.out.println(dp[k - 1]);
    }

    public static void merge(int a, int b) {
        if (a > b) {
            int tmp = b;
            b = a;
            a = tmp;
        }

        a = find(a);
        b = find(b);

        if (a == b) {
            return;
        }

        children[a].parent += children[b].parent;
        children[a].sum += children[b].sum;
        children[b].parent = a;
    }

    public static int find(int x) {
        if (children[x].parent < 0) {
            return x;
        }

        return children[x].parent = find(children[x].parent);
    }
}
