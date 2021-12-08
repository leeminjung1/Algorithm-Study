import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int k = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> treeMap = new TreeMap<>();
            while (k-- > 0) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String cmd = st.nextToken();
                int n = Integer.parseInt(st.nextToken());
                if (cmd.equals("D") && !treeMap.isEmpty()) {
                    int key = n == 1 ? treeMap.lastKey() : treeMap.firstKey();
                    if (treeMap.get(key) == 1) treeMap.remove(key);
                    else treeMap.put(key, treeMap.get(key) - 1);
                } else if(cmd.equals("I")) treeMap.merge(n, 1, Integer::sum);
            }
            if (treeMap.isEmpty()) sb.append("EMPTY").append('\n');
            else sb.append(treeMap.lastKey()).append(" ").append(treeMap.firstKey()).append('\n');
        }
        System.out.println(sb);
    }
}
