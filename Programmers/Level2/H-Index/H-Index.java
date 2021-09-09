import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = citations.length;
		    int h = 0;
        
        Arrays.sort(citations);

        for (int i = citations.length; i >= 0; i--) {
          for(int j=citations.length-1; j>=0; j--) {
            if(citations[j] >= i) h++;
            else break;
          }
          if(i <= h) return i;
          h=0;
        }
        
        return answer;
    }
}
