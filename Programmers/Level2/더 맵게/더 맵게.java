import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        Arrays.sort(scoville);

        for(int i : scoville) {
            priorityQueue.add(i);
        }
        
        for(int i=0; i<scoville.length-1; i++) {
            int first = priorityQueue.poll();
            if(first > K) break;
            int second = priorityQueue.poll();
            priorityQueue.add(first + 2*second);
            answer += 1;
        }

        if(priorityQueue.poll() < K) answer = -1;
        
        return answer;
    }
}
