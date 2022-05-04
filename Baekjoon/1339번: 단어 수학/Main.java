import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[26];
        while (n-- > 0) {
            String s = br.readLine();
            int m = 1;
            int len = s.length();
            for (int i = len - 1; i >= 0; i--) {
                a[s.charAt(i) - 'A'] += m;
                m *= 10;
            }
        }

        Arrays.sort(a);

        int sum = 0;
        for (int i = 0; i < 9; i++) {
            sum += a[25 - i] * (9 - i);
        }
        System.out.println(sum);
    }
}
