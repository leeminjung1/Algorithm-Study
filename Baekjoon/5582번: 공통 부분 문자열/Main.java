import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        solution(br.readLine(), br.readLine());
    }

    private static void solution(String s1, String s2) {
        int n1 = s1.length();
        int n2 = s2.length();

        int[][] lcs = new int[n1 + 1][n2 + 1];
        int max = 0;
        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    lcs[i][j] = lcs[i - 1][j - 1] + 1;
                    max = Math.max(max, lcs[i][j]);
                }
            }
        }
        System.out.println(max);


    }
}
