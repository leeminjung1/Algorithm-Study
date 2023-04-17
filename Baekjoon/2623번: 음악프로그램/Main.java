import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] cntPre = new int[n + 1];
        List<List<Integer>> nexts = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            nexts.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());;
            for (int j = 0; j < t - 1; j++) {
                nexts.get(x).add(x = Integer.parseInt(st.nextToken()));
                cntPre[x]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (cntPre[i] == 0) {
                queue.add(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            Integer cur = queue.poll();

            sb.append(cur).append('\n');

            for (Integer next : nexts.get(cur)) {
                if (--cntPre[next] == 0) {
                    queue.add(next);
                }
            }
        }

        if (sb.length() < n) {
            System.out.print("0");
        } else {
            System.out.print(sb);
        }
    }
}
