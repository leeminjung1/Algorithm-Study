import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        HashSet<String> set = new HashSet<>();

        for (int i = 0; i < words.length - 1; i++) {
            if (set.contains(words[i+1]) || words[i].charAt(words[i].length() - 1) != words[i + 1].charAt(0)) {
                answer[0] = (i+1) % n +1;
                answer[1] = (i + 1) / n + 1;
                break;
            } else set.add(words[i]);
        }
      
        return answer;
    }
}
