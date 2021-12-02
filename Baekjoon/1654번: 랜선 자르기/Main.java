import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        long [] l = new long [k];

        long sum = 0;
        long min = 0;
        
        for (int i = 0; i < k; i++) {
            sum += (l[i] = Long.parseLong(br.readLine()));
        }
        long max = sum / n + 1;
        while (min < max - 1) {
            long mid = (max + min) / 2;
            long cnt = 0;
            for (long value : l) {
                cnt += value / mid;
            }
            if (cnt < n) {
                max = mid;
            } else {
                min = mid;
            }
        }
        System.out.println(min);
    }
}
