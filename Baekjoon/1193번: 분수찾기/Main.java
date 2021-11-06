import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());

        int diagonal = 1, sum = 0;

        while (true) {
            if (x <= sum + diagonal) {
                int j = x - sum;
                int i = diagonal - (j - 1);
                if (diagonal % 2 == 1)
                    System.out.print(i + "/" + j);
                else
                    System.out.print(j + "/" + i);
                break;
            } else {
                sum += diagonal;
                diagonal++;
            }
        }

    }
}
