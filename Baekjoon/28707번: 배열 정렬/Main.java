import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static class Route implements Comparable<Route>{
        int[] node;
        int cost;
        public Route(int[] node, int cost) {
            this.node = node;
            this.cost = cost;
        }

        @Override
        public int compareTo(Route o) {
            return this.cost - o.cost;
        }
    }

    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        int m = Integer.parseInt(br.readLine());
        int[][] moveLists = new int[m][3];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                moveLists[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        HashSet<Integer> set = new HashSet<>();
        Queue<Route> pq = new PriorityQueue<>();
        pq.offer(new Route(A, 0));

        while (!pq.isEmpty()) {
            Route cur = pq.poll();
            if (set.contains(arrToInt(cur.node))) {
                continue;
            }

            set.add(arrToInt(cur.node));

            if (isSorted(cur.node)) {
                System.out.println(cur.cost);
                return;
            }

            for (int i = 0; i < m; i++) {
                int[] tmp = swap(cur.node, moveLists[i][0], moveLists[i][1]);
                int cc = moveLists[i][2] + cur.cost;
                pq.add(new Route(tmp, cc));
            }
        }

        System.out.println(-1);
    }

    public static int arrToInt(int[] arr) {
        int res = 0;
        for (int i : arr) {
            res = res * 10 + i;
        }
        return res;
    }

    public static int[] swap(int[] arr, int l, int r) {
        int[] tmp = Arrays.copyOf(arr, arr.length);
        tmp[l - 1] = arr[r - 1];
        tmp[r - 1] = arr[l - 1];
        return tmp;
    }

    public static boolean isSorted(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }
}
