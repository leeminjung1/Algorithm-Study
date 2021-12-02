import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String s = br.readLine();
            if(s.equals(".")) break;
            sb.append(isVPS(s)).append('\n');
        }
        System.out.println(sb);
    }

    private static String isVPS(String s) {
        char[] stack = new char[s.length()];
        int size = 0;
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[') {
                stack[size] = c;
                size++;
                continue;
            }
            if (c == ')') {
                if (size == 0 || stack[size - 1] != '(') {
                    return "no";
                }
                size--;
                continue;
            }
            if (c == ']') {
                if (size == 0 || stack[size - 1] != '[') {
                    return "no";
                }
                size--;
            }
        }
        return size == 0 ? "yes" : "no";
    }
}
