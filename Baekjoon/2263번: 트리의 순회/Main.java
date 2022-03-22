import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] in, post, inIdx, postIdx;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        in = new int[n];
        post = new int[n];
        inIdx = new int[n + 1];
        postIdx = new int[n + 1];

        String[] s = br.readLine().split(" ");
        String[] s1 = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            in[i] = Integer.parseInt(s[i]);
            inIdx[in[i]] = i;
            post[i] = Integer.parseInt(s1[i]);
            postIdx[post[i]] = i;
        }

        getPreOrder(0, n - 1, inIdx[post[n - 1]]);
        System.out.println(sb);
    }

    private static void getPreOrder(int i, int f, int lastIdx) {
        if(i > f) return;

        int root = in[lastIdx];
        sb.append(root).append(" ");

        int rootIdx = postIdx[root];

        if (rootIdx - (f - lastIdx) - 1 >= 0) {
            getPreOrder(i, lastIdx - 1, inIdx[post[rootIdx - (f - lastIdx) - 1]]);
        }
        if (rootIdx - 1 >= 0) {
            getPreOrder(lastIdx + 1, f, inIdx[post[rootIdx - 1]]);
        }
    }
}
