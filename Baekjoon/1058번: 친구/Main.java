import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[][] info = new char[n][n];
        int[] count = new int[n];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                info[i][j] = s.charAt(j);
            }
        }

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (info[i][j] == 'Y') {
                    count[i]++;
                    count[j]++;
                } else {
                    for (int k = 0; k < n; k++) {
                        if (info[i][k] == 'Y' && info[k][j] == 'Y') {
                            count[i]++;
                            count[j]++;
                            break;
                        }
                    }
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, count[i]);
        }
        System.out.println(ans);
    }
}
