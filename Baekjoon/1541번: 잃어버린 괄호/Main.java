import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer sub = new StringTokenizer(br.readLine(), "-");
        StringTokenizer firstAdd = new StringTokenizer(sub.nextToken(),"+");
        int sum = 0;
        while(firstAdd.hasMoreTokens()) {
            sum += Integer.parseInt(firstAdd.nextToken());
        }
        while (sub.hasMoreTokens()) {
            StringTokenizer add = new StringTokenizer(sub.nextToken(), "+");
            while (add.hasMoreTokens()) {
                sum -= Integer.parseInt(add.nextToken());
            }
        }
        System.out.println(sum);
    }
}
