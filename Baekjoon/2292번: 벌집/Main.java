import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if (n==1) System.out.println(1);
        else {
            int sum = 2;
            int i = 1;
            while (sum <= n) {
                sum += 6*i++;
            }
            System.out.println(i);
        }
    }
}
