import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for(int i=0; i<t; i++) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());

            System.out.println(solution(k, n));
        }
    }

    private static int solution(int k, int n) {
        if (k == 0) return n;
        
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += solution(k-1, i);
        }

        return sum;
    }

}
