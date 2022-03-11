import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static ArrayList<Integer> list = new ArrayList<>();
    static Object[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String num;
        while ((num = br.readLine()) != null && !num.equals("")) {
            list.add(Integer.parseInt(num));
        }
        arr = list.toArray();
        Search(0, list.size());

        System.out.print(sb);
    }
    private static void Search(int idx1, int idx2) {
        if(idx1 == idx2) return;

        int num = list.get(idx1);
        int rightIdx = Arrays.binarySearch(arr, idx1 + 1, idx2, num);
        if(rightIdx < 0) rightIdx = (rightIdx + 1) * -1;

        Search(idx1 + 1, rightIdx);
        Search(rightIdx, idx2);

        sb.append(num).append('\n');
    }

}
