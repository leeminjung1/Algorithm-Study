import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String s;
        Map<String, Integer> map = new HashMap<>();
        int size = 0;
        while ((s = br.readLine()) != null) {
            map.merge(s, 1, Integer::sum);
            size++;
        }
        Object[] keys = map.keySet().toArray();
        Arrays.sort(keys);
        for (Object key : keys) {
            double value = (float) map.get((String) key) / size * 100;
            sb.append(key).append(" ").append(String.format("%.4f", value)).append('\n');
        }

        System.out.println(sb);
    }
}
