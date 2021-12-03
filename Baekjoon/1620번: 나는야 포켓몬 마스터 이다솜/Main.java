import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        HashMap<String, Integer> map = new HashMap<>();
        String[] nameArr = new String[n + 1];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            map.put(s, i + 1);
            nameArr[i + 1] = s;
        }
        while (m-- > 0) {
            String q = br.readLine();
            if (Character.isDigit(q.charAt(0))) {
                sb.append(nameArr[Integer.parseInt(q)]).append('\n');
                continue;
            }
            sb.append(map.get(q)).append('\n');
        }

        System.out.println(sb);
    }
}
