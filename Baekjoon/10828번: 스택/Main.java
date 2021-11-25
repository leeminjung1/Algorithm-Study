import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] stack = new int[n];
        int size = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            if (s.equals("pop")) {
                if(size == 0) sb.append("-1").append('\n');
                else {
                    sb.append(stack[size - 1]).append('\n');
                    size--;
                }
                continue;
            }
            if (s.equals("size")) {
                sb.append(size).append('\n');
                continue;
            }
            if (s.equals("empty")) {
                if(size == 0) sb.append("1").append('\n');
                else sb.append("0").append('\n');
                continue;
            }
            if (s.equals("top")) {
                if(size == 0) sb.append("-1").append('\n');
                else sb.append(stack[size - 1]).append('\n');
                continue;
            }
            stack[size] = Integer.parseInt(s.substring(5));
            size++;
        }
        System.out.println(sb);
    }
}
