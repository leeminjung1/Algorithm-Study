import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int blue = 0;
    static int white = 0;
    static char[][] paper;
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        paper = new char[n][n];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                paper[i][j] = s.charAt(j * 2);
            }
        }
        check(0,0,n);
        System.out.println(white);
        System.out.println(blue);
    }

    public static void check(int r, int c, int size) {
        char flag = paper[r][c];
        for (int i = r; i < r + size; i++) {
            for (int j = c; j < c + size; j++) {
                if (paper[i][j] != flag) {
                    size /= 2;
                    check(r, c, size);
                    check(r, c + size, size);
                    check(r + size, c, size);
                    check(r + size, c + size, size);
                    return;
                }
            }
        }
        if (flag == '1')
            blue++;
        else
            white++;
    }
}
