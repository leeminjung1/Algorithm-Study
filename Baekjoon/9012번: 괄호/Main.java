import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Throwable {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            if(isVPS(s)) sb.append("YES").append('\n');
            else sb.append("NO").append('\n');
        }
        System.out.println(sb);
    }

    private static boolean isVPS(String s) {
        char[] stack = s.toCharArray();
        int size = 0;
        for (int i = 0; i < s.length(); i ++) {
            if (stack[i] == '(') size++;
            else size--;
            if (size < 0) return false;
        }
        return size == 0;
    }
}
