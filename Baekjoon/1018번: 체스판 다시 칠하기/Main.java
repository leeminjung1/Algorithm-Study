import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        char[][] board = new char[n][m];
        char[][] cut = new char[8][8];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = s.charAt(j);
            }
        }

        int min = n*m;
        for (int i = 0; i <= n - 8; i++) {
            for (int j = 0; j <= m - 8; j++) {
                for(int a = 0; a < 8; a++) {
                    System.arraycopy(board[i + a], j, cut[a], 0, 8);
                }
                int cnt =  count(cut);
                if(cnt < min) min = cnt;
            }
        }
        System.out.println(min);

    }

    private static int count(char[][] cut) {
        int a = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if((i%2==0 && j%2==0) || (i%2==1 && j%2==1)) {
                    if(cut[i][j] != 'B') a++;
                } else {
                    if(cut[i][j] != 'W') a++;
                }
            }
        }

        int b = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if((i%2==0 && j%2==0) || (i%2==1 && j%2==1)) {
                    if(cut[i][j] != 'W') b++;
                } else {
                    if(cut[i][j] != 'B') b++;
                }
            }
        }

        return Math.min(a,b);
    }

}
