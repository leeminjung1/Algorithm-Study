import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        Arrays.sort(people);

        int i = people.length-1;
        int j = 0;

        while(j <= i) {

          if (people[i] <= limit / 2) {
            answer += (int) Math.ceil((float) (i + 1 - j) / 2);
            break;
          }
          answer++;

          if(people[j]+people[i] <= limit) {
            j++;
          }

          i--;
        }
        
        return answer;
    }
}
