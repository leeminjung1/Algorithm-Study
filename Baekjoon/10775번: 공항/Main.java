import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int g = Integer.parseInt(br.readLine());
        int p = Integer.parseInt(br.readLine());
        parent = new int[g + 1];
        for (int i = 0; i < g + 1; i++) {
            parent[i] = i;
        }

        int i = 0;
        for (; i < p; i++) {
            int x = Integer.parseInt(br.readLine());
            x = find(x);
            
            if (x == 0) {
                break;
            }

            union(x, x - 1);
        }

        System.out.println(i);
    }

    public static int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    public static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x != y) {
            parent[x] = y;
        }
    }

}
