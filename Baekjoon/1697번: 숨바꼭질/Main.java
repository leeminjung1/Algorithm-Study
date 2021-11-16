import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        if(n >= k) {
            System.out.println(n-k);
            return;
        }

        int[] check = new int[100001];
        check[n] = 1;
        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        while (!q.isEmpty()) {
            int temp = q.poll();
            for (int i = 0; i < 3; i++) {
                int next;
                if(i == 0) next = temp + 1;
                else if(i == 1) next = temp - 1;
                else next = temp * 2;

                if (next == k) {
                    System.out.println(check[temp]);
                    return;
                }

                if (next >= 0 && next < check.length && check[next] == 0) {
                    q.add(next);
                    check[next] = check[temp] + 1;
                }
            }
        }


    }
}
