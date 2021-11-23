import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int[] arr = new int[10001];
        int sum = 0;
        int cnt = 1;
        for (int i = 0; i < 1001; ) {
            for (int j = 0; j < cnt; j++) {
                arr[i++] = cnt;
            }
            cnt++;
        }
        for (int i = a - 1; i < b; i++) {
            sum += arr[i];
        }
        System.out.println(sum);
    }
}
