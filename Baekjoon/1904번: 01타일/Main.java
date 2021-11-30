import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int a0 = 0;
        int a1 = 1;
        int x = 0;
        while (n-- > 0) {
            x = (a0 + a1) % 15746;
            a0 = a1;
            a1 = x;
        }
        System.out.println(x);
    }
}
