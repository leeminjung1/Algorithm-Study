import java.io.*;

public class Main {
    static final long r = 31;
    static final long M = 1234567891;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        long value = 1;
        long sum = 0;
        for(char ch : br.readLine().toCharArray()) {
            sum = (sum + (ch - 'a' + 1) * value) % M;
            value = value * r % M;
        }
        System.out.println(sum);
    }
}
