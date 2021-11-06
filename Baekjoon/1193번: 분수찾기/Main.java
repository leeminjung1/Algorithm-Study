import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());

        int sum = 0;
        int cnt = 0;
        while (true) {
            cnt++;
            sum += cnt;
            if (sum >= x) {
                System.out.println(sum+ " " +cnt);
                if (cnt % 2 == 0)
                    System.out.println((x - sum + cnt) + "/" + (sum - x + 1));
                else
                    System.out.println((sum - x + 1) + "/" + (x - sum + cnt));
                break;
            }
        }

    }
}
