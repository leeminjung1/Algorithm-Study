import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        LinkedList<Integer> dequeue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            dequeue.offer(i);
        }
        int[] arr = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int cnt = 0;
        for (int i = 0; i < m; i++) {
            int targetIdx = dequeue.indexOf(arr[i]);
            int halfIdx = dequeue.size() / 2;
            if (dequeue.size() % 2 == 0) halfIdx -= 1;

            if (targetIdx <= halfIdx) {
                for (int j = 0; j < targetIdx; j++) {
                    dequeue.offer(dequeue.pollFirst());
                    cnt++;
                }
            }
            else {
                for (int j = 0; j < dequeue.size() - targetIdx; j++) {
                    dequeue.offerFirst(dequeue.pollLast());
                    cnt++;
                }
            }
            dequeue.pollFirst();
        }
        System.out.println(cnt);
    }
}
