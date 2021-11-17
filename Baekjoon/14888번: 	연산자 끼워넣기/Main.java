import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    static HashSet<String> set;
    static int n;
    static int[] nums;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        nums = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        String ops = "";
        for (int i = 0; i < 4; i++) {
            int x = Integer.parseInt(st.nextToken());
            for (int j = 0; j < x; j++) {
                if(i == 0) ops += '+';
                if(i == 1) ops += '-';
                if(i == 2) ops += '*';
                if(i == 3) ops += '/';
            }
        }

        set = new HashSet<>();
        per("", ops);

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        while(set.iterator().hasNext()) {
            String s = set.iterator().next();
            set.remove(s);
            max = Math.max(max, calc(s));
            min = Math.min(min, calc(s));
        }

        System.out.println(max);
        System.out.println(min);

    }

    private static int calc(String s) {
        int result = nums[0];
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == '+') result += nums[i + 1];
            else if (s.charAt(i) == '-') result -= nums[i + 1];
            else if (s.charAt(i) == '*') result *= nums[i + 1];
            else result /= nums[i + 1];
        }
        return result;
    }

    private static void per(String pre, String str) {
        if (pre.length() == n-1) {
            set.add(pre);
        }
        for (int i = 0; i < str.length(); i++) {
            per(pre + str.charAt(i), str.substring(0, i) + str.substring(i + 1));
        }
    }

}
