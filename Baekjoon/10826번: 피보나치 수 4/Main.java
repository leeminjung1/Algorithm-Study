import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        BigInteger[][] ans = {{BigInteger.ONE, BigInteger.ZERO}, {BigInteger.ZERO, BigInteger.ONE}};
        BigInteger[][] data = {{BigInteger.ONE, BigInteger.ONE}, {BigInteger.ONE, BigInteger.ZERO}};

        while (n >= 1) {
            if (n % 2 != 0) {
                ans = getNext(ans, data);
            }
            data = getNext(data, data);
            n /= 2;
        }

        System.out.println(ans[0][1]);
    }

    static BigInteger[][] getNext(BigInteger[][] a, BigInteger[][] b) {
        BigInteger[][] ret = new BigInteger[2][2];
        ret[0][0] = a[0][0].multiply(b[0][0]).add(a[0][1].multiply(b[1][0]));
        ret[0][1] = a[0][0].multiply(b[0][1]).add(a[0][1].multiply(b[1][1]));
        ret[1][0] = a[1][0].multiply(b[0][0]).add(a[1][1].multiply(b[0][1]));
        ret[1][1] = a[1][0].multiply(b[0][1]).add(a[1][1].multiply(b[1][1]));
        return ret;
    }
}
