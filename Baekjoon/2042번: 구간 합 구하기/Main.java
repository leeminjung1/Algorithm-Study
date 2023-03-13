import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Math.*;

public class Main {
    public static long[] arr, tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int length = (int) pow(2, ceil(log(n) / log(2)) + 1);
        arr = new long[n + 1];
        tree = new long[length];
        for (int i = 1; i <= n; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

        makeTree(1, 1, n);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m + k; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            if (a == 1) {
                update(b, c - arr[b], 1, 1, n);
                arr[b] = c;
            } else {
                sb.append(find(1, 1, n, b, c)).append("\n");
            }
        }
        System.out.print(sb);
    }

    private static void update(int idx, long value, int node, int start, int end) {
        if (idx < start || idx > end) {
            return;
        }

        tree[node] += value;

        if (start != end) {
            update(idx, value, node * 2, start, (start + end) / 2);
            update(idx, value, node * 2 + 1, (start + end) / 2 + 1, end);
        }
    }

    private static long find(int node, int start, int end, int left, long right) {
        if (start > right || end < left) {
            return 0;
        }

        if (left <= start && end <= right) {
            return tree[node];
        }

        int mid = (start + end) / 2;
        return find(node * 2, start, mid, left, right) + find(node * 2 + 1, mid + 1, end, left, right);
    }

    private static long makeTree(int idx, int start, int end) {
        if (start == end) {
            return tree[idx] = arr[start];
        }
        int mid = (start + end) / 2;
        return tree[idx] = makeTree(idx * 2, start, mid) + makeTree(idx * 2 + 1, mid + 1, end);
    }

}
