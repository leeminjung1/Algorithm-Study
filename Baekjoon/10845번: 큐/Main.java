import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] queue = new int[n];
        StringBuilder sb = new StringBuilder();
        int front = 0;
        int end = 0;
        while (n-- > 0) {
            String s = br.readLine();
            if (s.equals("pop")) {
                if (front >= end) sb.append(-1).append('\n');
                else {
                    sb.append(queue[front]).append('\n');
                    front++;
                }
                continue;
            }
            if (s.equals("size")) {
                sb.append(end - front).append('\n');
                continue;
            }
            if (s.equals("empty")) {
                if (front >= end) sb.append(1).append('\n');
                else sb.append(0).append('\n');
                continue;
            }
            if (s.equals("front")) {
                if (front >= end) sb.append(-1).append('\n');
                else sb.append(queue[front]).append('\n');
                continue;
            }
            if (s.equals("back")) {
                if (front >= end) sb.append(-1).append('\n');
                else sb.append(queue[end - 1]).append('\n');
                continue;
            }
            int x = Integer.parseInt(s.substring(5));
            queue[end] = x;
            end++;
        }
        System.out.println(sb);
    }
}
