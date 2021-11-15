import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        boolean isContainZero = false;
        int sum = 0;
        int[] arr = new int[10];
        for (int i=0; i<s.length(); i++) {
            int x = Character.getNumericValue(s.charAt(i));
            if(x == 0) isContainZero = true;
            sum += x;
            arr[x]++;
        }

        if (!isContainZero || sum % 3 != 0) {
            System.out.println(-1);
            return;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 9; i >= 0; i--) {
            while(arr[i] > 0) {
                sb.append(i);
                arr[i]--;
            }
        }
        System.out.println(sb);

    }
}
