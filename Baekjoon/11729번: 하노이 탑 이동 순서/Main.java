import java.io.*;
public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        bw.write((int)Math.pow(2, n) - 1 +"\n");
        hanoi(n, 1, 2, 3);
        bw.close();
    }
    private static void hanoi(int n, int from, int via, int to) throws IOException {
        if (n == 1) {
            bw.write(from + " " + to + "\n");
        } else {
            hanoi(n - 1, from, to, via);
            bw.write(from + " " + to + "\n");
            hanoi(n - 1, via, from, to);
        }
    }

}
