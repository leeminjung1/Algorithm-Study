import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0, end = 0, idx = 0;
        Arrays.sort(jobs, Comparator.comparingInt(o -> o[0]));
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        while (!(idx == jobs.length && pq.isEmpty())) {
            while (idx < jobs.length && jobs[idx][0] <= end) {
                pq.add(jobs[idx++]);
            }
            if (pq.isEmpty()) {
                end = jobs[idx][0];
                continue;
            }
            int[] tmp = pq.poll();
            end += tmp[1];
            answer += end - tmp[0];
        }

        return answer / jobs.length;
    }
}
