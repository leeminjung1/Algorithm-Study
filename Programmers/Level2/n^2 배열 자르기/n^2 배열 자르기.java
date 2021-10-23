import java.util.*;
class Solution {
    public int[] solution(int n, long left, long right) {
        ArrayList<Long> arr = new ArrayList<>();

        while (left <= right) {
          arr.add(Math.max(left / n, left++ % n) + 1);
        }

        return arr.stream().mapToInt(Math::toIntExact).toArray();
    }
}
