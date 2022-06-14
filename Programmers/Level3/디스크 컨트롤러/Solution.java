import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0, count = 0, end = 0, idx = 0;
        Arrays.sort(jobs, Comparator.comparingInt(o -> o[0]));
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        while (count < jobs.length) {
            while (idx < jobs.length && jobs[idx][0] <= end) {
                pq.add(jobs[idx++]);
            }
            if (pq.isEmpty()) {
                end = jobs[idx][0];
            } else {
                int[] tmp = pq.poll();
                answer += tmp[1] + end - tmp[0];
                end += tmp[1];
                count++;
            }
        }

        return aswer / jobs.length;
    }
}
