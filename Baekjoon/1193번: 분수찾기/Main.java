import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());

        int diagonal = 1, sum = 0;

        while (true) {
            if (x <= sum + diagonal) {
                if (diagonal % 2 == 1) { 
                    System.out.print((diagonal - (x - sum - 1)) + "/" + (x - sum));
                    break;
                } else { 
                    System.out.print((x - sum) + "/" + (diagonal - (x - sum - 1)));
                    break;
                }
            } else {
                sum += diagonal;
                diagonal++;
            }
        }
    }
}
