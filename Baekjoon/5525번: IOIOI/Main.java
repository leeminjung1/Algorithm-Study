import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        char[] s = br.readLine().toCharArray();
        int result = 0;
        int cnt = 0;
        for (int i = 1; i < m - 1; i++) {
            if (s[i - 1] == 'I' && s[i] == 'O' && s[i + 1] == 'I') {
                cnt++;
                if (cnt == n) {
                    cnt--;
                    result++;
                }
                i++;
            } else cnt = 0;
        }
        System.out.println(result);
    }
}
