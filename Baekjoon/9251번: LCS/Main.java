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
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < n2; j++) {
                lcs[i+1][j+1] = (s1.charAt(i) == s2.charAt(j)) ? (lcs[i][j]+1) : (Math.max(lcs[i][j+1], lcs[i+1][j]));
            }
        }
        System.out.println(lcs[n1][n2]);

    }
}
