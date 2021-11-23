import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();

        maxHeap.offer(Integer.MIN_VALUE);
        minHeap.offer(Integer.MAX_VALUE);

        for (int i = 0; i < n; i++) {
            Integer x = Integer.valueOf(br.readLine());
            if (x <= minHeap.peek()) maxHeap.add(x);
            else minHeap.add(x);

            int sizeDiff = minHeap.size() - maxHeap.size();
            if (sizeDiff > 1) {
                maxHeap.add(minHeap.poll());
            } else if (sizeDiff < -1) {
                minHeap.add(maxHeap.poll());
            }

            Integer top = maxHeap.peek();
            if(minHeap.size() > maxHeap.size()) top = minHeap.peek();

            sb.append(top).append('\n');
        }
        System.out.println(sb);
    }
}
