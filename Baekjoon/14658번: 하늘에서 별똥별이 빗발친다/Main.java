import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        st.nextToken();
        st.nextToken();
        int l = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] stars = new int[k][2];
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            stars[i] = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
        }

        int max = 0;
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < k; j++) {
                int cnt = 0;
                for (int o = 0; o < k; o++) {
                    if (stars[i][0] <= stars[o][0] && stars[o][0] <= stars[i][0] + l && stars[j][1] <= stars[o][1] && stars[o][1] <= stars[j][1] + l) {
                        cnt++;
                    }
                }
                max = Math.max(max, cnt);
            }
        }

        System.out.println(k - max);
    }
}
