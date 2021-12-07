import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CountingSort {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] counting = new int[1001];
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i <N; i++){
            counting[Integer.parseInt(st.nextToken())]++;
        }

        int sum = 0;
        int ans = 0;
        for (int i = 0; i < counting.length; i++){
            while (counting[i] > 0){
                counting[i]--;
                sum += i;
                ans += sum;
            }
        }

        System.out.println(ans);

    }
}
