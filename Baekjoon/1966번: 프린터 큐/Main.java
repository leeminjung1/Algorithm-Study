import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int[] weight = new int[10];
            int max = -1;
            LinkedList<int[]> queue = new LinkedList<>();
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                int v = Integer.parseInt(st.nextToken());
                queue.offer(new int[]{i, v});
                max = Math.max(v, max);
                weight[v]++;
            }
            int cnt = 0;
            while (!queue.isEmpty()) {
                int[] current = queue.poll();
                if (current[1] < max) {
                    queue.offer(current);
                    continue;
                }
                cnt++;
                if (m == current[0]) {
                    sb.append(cnt).append('\n');
                    break;
                }
                if (--weight[max] == 0) {
                    for(int j = max - 1; j > 0; j--) {
                        if(weight[j] > 0) {
                            max = j;
                            break;
                        }
                    }
                }
            }
        }
        System.out.println(sb);
    }
}
