import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            for (int j = n / 2; j >= 2; j--) {
                if(isPrime(j) && isPrime(n - j)) {
                    System.out.println(j + " " + (n - j));
                    break;
                }
            }
        }
    }

    private static boolean isPrime(int n) {
        if (n == 1) return false;
        for (int i = 2; i*i <= n; i++) {
            if(n % i == 0) return false;
        }
        return true;
    }

}
