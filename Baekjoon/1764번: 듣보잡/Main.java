import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        HashSet<String> name = new HashSet<>();
        ArrayList<String> name2 = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            name.add(br.readLine());
        }
        for (int i = 0; i < m; i++) {
            String s = br.readLine();
            if(name.contains(s)) {
                name2.add(s);
            }
        }
        sb.append(name2.size()).append('\n');

        Collections.sort(name2);

        for (String s : name2) {
            sb.append(s).append('\n');
        }
        System.out.println(sb);
    }
}
