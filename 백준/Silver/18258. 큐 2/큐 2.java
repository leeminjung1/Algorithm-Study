import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int[] queue = new int[2 * n + 1];
        int front = 0;
        int back = 0;
        while (n-- > 0) {
            String s = br.readLine();
            if (s.contains("push")) {
                int x = Integer.parseInt(String.valueOf(s.split(" ")[1]));
                queue[back] = x;
                back++;
            } else if (s.equals("front")) {
                if (queue[front] == 0) {
                    sb.append("-1").append('\n');
                } else {
                    sb.append(queue[front]).append('\n');
                }
            } else if (s.equals("back")) {
                if (queue[front] == 0) {
                    sb.append("-1").append('\n');
                } else {
                    sb.append(queue[back - 1]).append('\n');
                }
            } else if (s.equals("size")) {
                sb.append(back - front).append('\n');
            } else if (s.equals("pop")) {
                if (queue[front] == 0) {
                    sb.append("-1").append('\n');
                } else {
                    sb.append(queue[front]).append('\n');
                    queue[front] = 0;
                    front++;
                }
            } else {
                sb.append(queue[front] == 0 ? "1" : "0").append('\n');
            }
        }
        System.out.println(sb);
    }
}
