import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] h = new int[n];
        st = new StringTokenizer(br.readLine());
        int min = 0;
        int max = 0;
        for (int i = 0; i < n; i++) {
            if((h[i] = Integer.parseInt(st.nextToken())) > max) max = h[i];
        }

        while (min < max) {
            int mid = (min + max) / 2;
            long sum = 0;
            for (int i : h) {
                if (i - mid > 0) sum += i - mid;
            }
            if (sum < m) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }
        System.out.println(min - 1);
    }
}
