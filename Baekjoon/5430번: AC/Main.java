import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String s = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String[] arr = new String[n];
            StringTokenizer st = new StringTokenizer(br.readLine(), "[,]");
            for (int i = 0; i < n; i++) {
                arr[i] = st.nextToken();
            }
            AC(arr, s);
        }
        System.out.println(sb);
    }

    private static void AC(String[] arr, String s) {
        int n = arr.length;
        int itL = 0;
        int itR = n - 1;
        boolean isReversed = false;
        for (char c : s.toCharArray()) {
            if (c == 'R') {
                isReversed = !isReversed;
            } else if (itL > itR || n == 0) {
                sb.append("error").append('\n');
                return;
            } else if (isReversed) {
                itR--;
            } else {
                itL++;
            }
        }
        sb.append('[');
        if (itL <= itR) {
            if (!isReversed) {
                sb.append(arr[itL]);
                while (itL < itR) {
                    sb.append(',').append(arr[++itL]);
                }
            } else {
                sb.append(arr[itR]);
                while (itL < itR) {
                    sb.append(',').append(arr[--itR]);
                }
            }
        }
        sb.append(']').append('\n');
    }
}
