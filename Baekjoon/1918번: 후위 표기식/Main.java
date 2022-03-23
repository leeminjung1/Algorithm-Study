import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] str = br.readLine().toCharArray();
        char[] stack = new char[str.length];
        int top = -1;
        StringBuilder sb = new StringBuilder();
        for (char c : str) {
            int p = priority(c);
            if (p == 0) {
                sb.append(c);
            } else if (p == -1) {
                if (c == ')') {
                    while (top >= 0 && stack[top] != '(') {
                        sb.append(stack[top--]);
                    }
                    --top;
                } else {
                    stack[++top] = c;
                }
            } else {
                while (top >= 0 && priority(stack[top]) >= p) {
                    sb.append(stack[top--]);
                }
                stack[++top] = c;
            }
        }
        while (top >= 0) {
            sb.append(stack[top--]);
        }
        System.out.println(sb);
    }

    private static int priority(char c) {
        if (c >= 'A' && c <= 'Z') return 0;
        if (c == '+' || c == '-') return 1;
        if (c == '*' || c == '/') return 2;
        return -1;
    }
}
