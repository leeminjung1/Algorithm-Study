import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        LinkedList<int []> queue = new LinkedList<>();

        for(int i=0; i< priorities.length; i++) {
          queue.offer(new int[] {i, priorities[i]});
        }

        while(!queue.isEmpty()) {

          int[] init = queue.poll();
          boolean flag = false;

          for(int i=0; i<queue.size(); i++) {
            if(init[1] < queue.get(i)[1]) {
              flag = true;
              queue.offer(init);
              for(int j=0; j<i; j++) {
                queue.offer(queue.poll());
              }
              break;
            }
          }

          if(flag) continue;
          answer++;
          if(init[0] == location) break;

        }

        return answer;
    }
}
