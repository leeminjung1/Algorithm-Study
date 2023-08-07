import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int MAX = 1000001;
        int n = Integer.parseInt(br.readLine());
        int[] x = new int[n];
        boolean[] cards = new boolean[MAX];
        int[] scores = new int[MAX];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            x[i] = Integer.parseInt(st.nextToken());
            cards[x[i]] = true;
        }

        for (int i = 0; i < n; i++) {
            int cur = x[i];
            for (int j = 2 * cur; j < MAX; j += cur) {
                if (cards[j]) {
                    scores[cur]++;
                    scores[j]--;
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(scores[x[i]]).append(' ');
        }
        System.out.println(sb);
    }
}
