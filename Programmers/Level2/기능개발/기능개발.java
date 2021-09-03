import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        Queue<Integer> days = new LinkedList<>();
        ArrayList<Integer> arr;

        for(int i=0; i<progresses.length; i++) {
          days.add((int)Math.ceil((float)(100 - progresses[i])/speeds[i]));
        }

        arr = deploy(days);

        answer = new int[arr.size()];
        for(int i=0; i<arr.size(); i++) {
          answer[i] = arr.get(i);
        }
        
        return answer;
    }
    
    public ArrayList<Integer> deploy (Queue<Integer> days) {
        ArrayList<Integer> ans = new ArrayList<>();
        int count = 0;
        int work = days.peek();

        while(!days.isEmpty()) {
          if(work >= days.peek()) {
            count++;
            days.poll();
          } else {
            ans.add(count);
            work = days.peek();
            count = 0;
          }
        }
        ans.add(count);
        return ans;
	  }
    
}
