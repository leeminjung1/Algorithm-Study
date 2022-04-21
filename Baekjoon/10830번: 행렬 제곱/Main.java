import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        int[][] matrix = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken()) % 1000;
            }
        }
        int[][] result = matrixSquare(matrix, B);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(result[i][j]).append(" ");
            }
            sb.append("\n");
        }

        sb.setLength(sb.length() - 1);
        System.out.println(sb);

    }

    static int[][] matrixMultiply(int[][] matrix1, int[][] matrix2){
        int[][] newMatrix = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    newMatrix[i][j] += matrix1[i][k] * matrix2[k][j];
                }
                newMatrix[i][j] %= 1000;
            }
        }

        return newMatrix;
    }

    static int[][] matrixSquare(int[][] matrix, long B){
        if (B == 1) return matrix;

        int[][] tempMatrix = matrixSquare(matrix, B/2);
        if (B % 2 == 1) {
            return matrixMultiply(matrixMultiply(tempMatrix, tempMatrix), matrix);
        } else {
            return matrixMultiply(tempMatrix, tempMatrix);
        }
    }
}
