import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            System.out.println(solution(x, y));
        }
    }

    private static int solution(int x, int y) {
        double n = y - x;
        double i = 1;
        for (; ; i++) {
            if (i * i > n) {
                break;
            }
        }

        if ((i - 1) * (i - 1) == y - x)
            return (int) (2 * (i - 1) - 1);

        if ((i - 1) * (i - 1) + ((i * i - (i - 1) * (i - 1)) / 2) >= y - x)
            return (int) (2 * i - 2);
        
        return (int) (2 * i - 1);

    }


}
