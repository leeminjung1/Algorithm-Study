import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        System.out.println(pow(A, B));
    }

    public static long pow(int A, int exp) {
        if (exp == 0) {
            return 1;
        }

        long tmp = pow(A, exp >> 1);
        tmp *= tmp;
        tmp %= C;
        
        return (exp & 1) == 0 ? tmp : tmp * A % C;
    }
}

