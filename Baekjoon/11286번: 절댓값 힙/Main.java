import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int[] arr = new int[100001];
    public static int n;
    public static int index = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int v = Integer.parseInt(br.readLine());
            if (v == 0) {
                sb.append(delete()).append('\n');
                continue;
            }
            insert(v);
        }
        System.out.println(sb);
        br.close();
    }

    public static void insert(int x) {
        arr[++index] = x;
        for (int i = index; i > 1; i /= 2) {
            if (Math.abs(arr[i]) < Math.abs(arr[i / 2]) || (Math.abs(arr[i]) == Math.abs(arr[i / 2]) && arr[i] < 0)) {
                swap(i / 2, i);
            }
            else break;
        }
    }

    public static int delete() {
        if (index == 0) return 0;
        int item = arr[1];
        arr[1] = arr[index];
        arr[index--] = 0;
        for (int i = index; i > 1; i--) {
            if (Math.abs(arr[i]) > Math.abs(arr[i / 2]) || (Math.abs(arr[i]) == Math.abs(arr[i / 2]) && arr[i] > 0)) {
                continue;
            }
            swap(i, i/2);
        }
        return item;
    }

    private static void swap(int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

}
