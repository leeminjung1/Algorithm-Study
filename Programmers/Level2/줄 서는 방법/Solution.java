import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int n, long k) {
        List<Integer> list = new ArrayList<>();
        long fac = 1;
        for (int i = 1; i <= n; i++) {
            list.add(i);
            fac *= i;
        }
        
        k--;
        int idx = 0;
        int[] answer = new int[n];
        while (idx < n) {
            fac /= n - idx;
            answer[idx++] = list.remove((int) (k / fac));
            k %= fac;
        }
      
        return answer;
    }
}
