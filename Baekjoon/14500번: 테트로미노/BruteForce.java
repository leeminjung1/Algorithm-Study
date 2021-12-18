import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BruteForce {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] paper = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++){
                int sum;
                if (i+3 < n) {
                    sum = paper[i][j] + paper[i+1][j] + paper[i+2][j] + paper[i+3][j];
                    if (max < sum) {
                        max = sum;
                    }
                }
                if (j+3 < m) {
                    sum = paper[i][j] + paper[i][j+1] + paper[i][j+2] + paper[i][j+3];
                    if (max < sum) {
                        max = sum;
                    }
                }
                if (i+1 < n && j+1 < m) {
                    sum = paper[i][j] + paper[i+1][j] + paper[i][j+1] + paper[i+1][j+1];
                    if (max < sum) {
                        max = sum;
                    }
                }
                if (i+1 < n && j+2 < m) {
                    sum = paper[i][j] + paper[i][j+1] + paper[i][j+2] + paper[i+1][j+2];
                    if (max < sum) {
                        max = sum;
                    }

                    sum = paper[i][j] + paper[i+1][j] + paper[i+1][j+1] + paper[i+1][j+2];
                    if (max < sum) {
                        max = sum;
                    }

                    sum = paper[i+1][j] + paper[i+1][j+1] + paper[i][j+2] + paper[i+1][j+2];
                    if (max < sum) {
                        max = sum;
                    }

                    sum = paper[i][j] + paper[i+1][j] + paper[i][j+1] + paper[i][j+2];
                    if (max < sum) {
                        max = sum;
                    }

                    sum = paper[i][j] + paper[i][j+1] + paper[i+1][j+1] + paper[i+1][j+2];
                    if (max < sum) {
                        max = sum;
                    }

                    sum = paper[i+1][j] + paper[i][j+1] + paper[i+1][j+1] + paper[i][j+2];
                    if (max < sum) {
                        max = sum;
                    }

                    sum = paper[i][j] + paper[i][j+1] + paper[i+1][j+1] + paper[i][j+2];
                    if (max < sum) {
                        max = sum;
                    }

                    sum = paper[i+1][j] + paper[i][j+1] + paper[i+1][j+1] + paper[i+1][j+2];
                    if (max < sum) {
                        max = sum;
                    }
                }
                if (i+2 < n && j+1 < m) {
                    sum = paper[i+2][j] + paper[i][j+1] + paper[i+1][j+1] + paper[i+2][j+1];
                    if (max < sum) {
                        max = sum;
                    }

                    sum = paper[i][j] + paper[i+1][j] + paper[i+2][j] + paper[i][j+1];
                    if (max < sum) {
                        max = sum;
                    }

                    sum = paper[i][j] + paper[i+1][j] + paper[i+2][j] + paper[i+2][j+1];
                    if (max < sum) {
                        max = sum;
                    }

                    sum = paper[i][j] + paper[i][j+1] + paper[i+1][j+1] + paper[i+2][j+1];
                    if (max < sum) {
                        max = sum;
                    }

                    sum = paper[i+1][j] + paper[i+2][j] + paper[i][j+1] + paper[i+1][j+1];
                    if (max < sum) {
                        max = sum;
                    }

                    sum = paper[i][j] + paper[i+1][j] + paper[i+1][j+1] + paper[i+2][j+1];
                    if (max < sum) {
                        max = sum;
                    }

                    sum = paper[i][j] + paper[i+1][j] + paper[i+2][j] + paper[i+1][j+1];
                    if (max < sum) {
                        max = sum;
                    }

                    sum = paper[i+1][j] + paper[i][j+1] + paper[i+1][j+1] + paper[i+2][j+1];
                    if (max < sum) {
                        max = sum;
                    }
                }
            }
        }

        System.out.println(max);
    }

}
