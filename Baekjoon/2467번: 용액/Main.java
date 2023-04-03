import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] solutions = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            solutions[i] = Integer.parseInt(st.nextToken());
        }
        int l = 0, r = n - 1;
        int ml = 0, mr = n - 1;
        while (l < r) {
            if (Math.abs(solutions[ml] + solutions[mr]) > Math.abs(solutions[l] + solutions[r])) {
                ml = l;
                mr = r;
            }
            if (solutions[l] + solutions[r] > 0) {
                r--;
            } else {
                l++;
            }
        }
        System.out.println(solutions[ml] + " " + solutions[mr]);
    }
}
