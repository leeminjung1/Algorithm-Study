import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int count = 0;
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        solution((int) Math.pow(2, n), r, c);
        System.out.println(count);
    }

    private static void solution(int size, int r, int c) {
        if(size == 1) return;
        size /= 2;
        if (size > c && size > r) {
            solution(size, r, c);
        } else if (size > r) {
            count += size * size;
            solution(size, r, c - size);
        } else if (size > c) {
            count += 2 * size * size;
            solution(size, r - size, c);
        } else {
            count += 3 * size * size;
            solution(size, r - size, c - size);
        }
    }

}
