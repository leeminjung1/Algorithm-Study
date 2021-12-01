import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] deque = new int[10000];
        int front = 0;
        int back = 0;
        int size = 0;
        StringBuilder sb = new StringBuilder();
        while (n-- > 0) {
            String[] s = br.readLine().split(" ");
            if (s[0].equals("push_front")) {
                deque[front] = Integer.parseInt(s[1]);
                front = (front - 1 + 10000) % 10000;
                size++;
                continue;
            }
            if (s[0].equals("push_back")) {
                back = (back + 1) % 10000;
                size++;
                deque[back] = Integer.parseInt(s[1]);
                continue;
            }
            if (s[0].equals("pop_front")) {
                if (size == 0) {
                    sb.append(-1).append('\n');
                    continue;
                }
                sb.append(deque[(front + 1) % 10000]).append('\n');
                front = (front + 1) % 10000;
                size--;
                continue;
            }
            if (s[0].equals("pop_back")) {
                if (size == 0) {
                    sb.append(-1).append('\n');
                    continue;
                }
                sb.append(deque[back]).append('\n');
                back = (back - 1 + 10000) % 10000;
                size--;
                continue;
            }
            if (s[0].equals("size")) {
                sb.append(size).append('\n');
                continue;
            }
            if (s[0].equals("empty")) {
                sb.append(size == 0 ? 1 : 0).append('\n');
                continue;
            }
            if (s[0].equals("front")) {
                if (size == 0) {
                    sb.append(-1).append('\n');
                    continue;
                }
                sb.append(deque[(front + 1) % 10000]).append('\n');
                continue;
            }
            if (s[0].equals("back")) {
                if (size == 0) {
                    sb.append(-1).append('\n');
                    continue;
                }
                sb.append(deque[back]).append('\n');
            }
        }
        System.out.println(sb);
    }
}
