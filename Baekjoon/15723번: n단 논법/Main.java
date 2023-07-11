import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[][] arr = new boolean[26][26];
        for (int i = 0; i < 26; i++) {
            arr[i][i] = true;
        }

        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            arr[s.charAt(0) - 'a'][s.charAt(5) - 'a'] = true;
        }

        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                for (int k = 0; k < 26; k++) {
                    if (arr[j][i] && arr[i][k]) {
                        arr[j][k] = true;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            String s = br.readLine();

            if (arr[s.charAt(0) - 'a'][s.charAt(5) - 'a']) {
                sb.append("T");
            } else {
                sb.append("F");
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }
}
