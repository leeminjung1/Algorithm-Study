import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class priorityQueue {
    private static class Pair implements Comparable<Pair> {
        int first, second;
        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
        @Override
        public int compareTo(Pair o) {
            if (this.first == o.first) return this.second < o.second ? -1 : 1;
            return this.first < o.first ? -1 : 1;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());
            if (x == 0) {
                if(pq.isEmpty()) sb.append(x).append('\n');
                else sb.append(pq.poll().second).append('\n');
                continue;
            } pq.add( new Pair(Math.abs(x), x) );
        }
        System.out.println(sb);
    }
}
