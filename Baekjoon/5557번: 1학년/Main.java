import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int max = 21;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        long[] a = new long[max];
        long[] b = new long[max];

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        a[Integer.parseInt(st.nextToken())] = 1;
        for (int i = 1; i < n - 1; i++) {
            int number = Integer.parseInt(st.nextToken());

            for (int j = 0; j < max; j++) {
                if (a[j] == 0) continue;

                if (j + number < max) {
                    b[j + number] += a[j];
                }
                if (j - number >= 0) {
                    b[j - number] += a[j];
                }
            }

            for (int j = 0; j < max; j++) {
                a[j] = b[j];
                b[j] = 0;
            }
        }

        System.out.println(a[Integer.parseInt(st.nextToken())]);
    }
}
