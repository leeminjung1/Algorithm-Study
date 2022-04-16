import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] min = new int[3];
        int[] max = new int[3];
        int[] arr = new int[3];
        int[] tmp = new int[3];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < 3; j++) {
                arr[j] = s.charAt(2 * j) - '0';
            }
            tmp[0] = arr[0] + Math.min(min[0], min[1]);
            tmp[1] = arr[1] + Math.min(min[0], Math.min(min[1], min[2]));
            tmp[2] = arr[2] + Math.min(min[2], min[1]);
            min[0] = tmp[0];
            min[1] = tmp[1];
            min[2] = tmp[2];
            tmp[0] = arr[0] + Math.max(max[0], max[1]);
            tmp[1] = arr[1] + Math.max(max[0], Math.max(max[1], max[2]));
            tmp[2] = arr[2] + Math.max(max[2], max[1]);
            max[0] = tmp[0];
            max[1] = tmp[1];
            max[2] = tmp[2];
        }
        System.out.println(Math.max(max[0], Math.max(max[1], max[2])) + " " + Math.min(min[0], Math.min(min[1], min[2])));
    }
}
