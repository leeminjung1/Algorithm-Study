import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Math.*;

public class Main {
    public static int min, max;
    public static int[] arr,minST, maxST;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int length = (int) pow(2, ceil(log(n) / log(2)) + 1);
        arr = new int[n + 1];
        minST = new int[length];
        maxST = new int[length];
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        makeTree(1, 1, n);
        
        StringBuilder sb = new StringBuilder();
        while (m-- > 0) {
            min = 1_000_000_000;
            max = 0;
            st = new StringTokenizer(br.readLine());
            find(1, 1, n, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            sb.append(min).append(" ").append(max).append("\n");
        }
        System.out.print(sb);
    }

    private static void find(int idx, int start, int end, int left, int right) {
        if (start > right || end < left) {
            return;
        }

        if (left <= start && end <= right) {
            min = min(min, minST[idx]);
            max = max(max, maxST[idx]);
            return;
        }

        int mid = (start + end) / 2;
        find(idx * 2, start, mid, left, right);
        find(idx * 2 + 1, mid + 1, end, left, right);
    }

    private static void makeTree(int idx, int start, int end) {
        if (start == end) {
            minST[idx] = maxST[idx] = arr[start];
            return;
        }

        int mid = (start + end) / 2;
        makeTree(idx * 2, start, mid);
        makeTree(idx * 2 + 1, mid + 1, end);
        minST[idx] = min(minST[idx * 2], minST[idx * 2 + 1]);
        maxST[idx] = max(maxST[idx * 2], maxST[idx * 2 + 1]);
    }
}
