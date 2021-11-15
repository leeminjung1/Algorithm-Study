import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int[] arr = new int[10];

        for (char c : s.toCharArray()) {
            arr[c-'0']++;
        }

        int max = 0;
        int sixnine = arr[6]+arr[9];
        for (int i = 0; i < 10; i++) {
            if(i != 6 && i != 9) max = Math.max(max, arr[i]);
        }
        System.out.println(Math.max(max, (int) Math.ceil(1.0 * sixnine / 2)));

    }
}
