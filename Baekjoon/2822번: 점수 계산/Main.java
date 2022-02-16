import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[] scores = new int[8];
        for (int i = 0; i < 8; i++) {
            scores[i] = Integer.parseInt(br.readLine());
        }

        int sum = 0;
        int[] indexes = new int[5];
        for (int i = 0; i < 5; i++) {
            int max = scores[0];
            int maxIndex = 0;
            for (int j = 1; j < 8; j++) {
                if (max < scores[j]) {
                    max = scores[j];
                    maxIndex = j;
                }
            }
            sum += max;
            scores[maxIndex] = 0;
            indexes[i] = maxIndex + 1;
        }
        sb.append(sum).append('\n');

        Arrays.sort(indexes);

        for (int index : indexes) {
            sb.append(index).append(" ");
        }

        System.out.println(sb);
    }
}
