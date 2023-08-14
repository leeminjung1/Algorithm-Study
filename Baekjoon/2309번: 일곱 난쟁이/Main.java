import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] dwarfs = new int[9];
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            dwarfs[i] = Integer.parseInt(br.readLine());
            sum += dwarfs[i];
        }

        Arrays.sort(dwarfs);

        int ni = 0, nj = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = i + 1; j < 9; j++) {
                if (dwarfs[i] + dwarfs[j] == sum - 100) {
                    ni = i;
                    nj = j;
                    i = 8;
                    break;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int k = 0; k < 9; k++) {
            if (k == ni || k == nj) {
                continue;
            }
            sb.append(dwarfs[k]).append('\n');
        }
        System.out.print(sb);
    }
}
