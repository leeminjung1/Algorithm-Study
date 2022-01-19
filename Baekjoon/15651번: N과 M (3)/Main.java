import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static char[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new char[2 * M];
        back(0);
        System.out.print(sb);
    }

    static void back(int idx) {
        if (idx >= M) {
            arr[2 * M - 1] = '\n';
            sb.append(arr);
            return;
        }

        for (int i = 1; i <= N; i++) {
            arr[2 * idx] = (char)(i + '0');
            arr[2 * idx + 1] = ' ';
            back(idx + 1);
        }
    }
}
