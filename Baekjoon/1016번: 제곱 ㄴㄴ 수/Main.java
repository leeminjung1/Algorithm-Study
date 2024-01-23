import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long min = Long.parseLong(st.nextToken());
        long max = Long.parseLong(st.nextToken());

        boolean[] squares = new boolean[1000001];

        long cnt = max - min + 1;

        for (int i = 2; (long) i * i <= max; i++) {
            long numberOfSquares = (long) i * i;
            long tmp = min / numberOfSquares;
            if (min % numberOfSquares != 0) {
                tmp += 1;
            }

            for (long j = tmp; j * numberOfSquares <= max; j++) {
                int canSqrt = (int) (j * numberOfSquares - min);
                if(!squares[canSqrt]) {
                    squares[canSqrt] = true;
                    cnt--;
                }
            }
        }

        System.out.println(cnt);
    }
}
