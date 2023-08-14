import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static String[] memo = new String[13];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String s;
        memo[0] = "-";
        while ((s = br.readLine()) != null ) {
            sb.append(dfs(Integer.parseInt(s))).append('\n');
        }
        System.out.print(sb);
    }

    public static String dfs(int n) {
        if (memo[n] != null) {
            return memo[n];
        }

        String prev = dfs(n - 1);

        return memo[n] = prev.concat(" ".repeat(prev.length())).concat(prev);
    }
}
