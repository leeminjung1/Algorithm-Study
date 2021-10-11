class Solution {
    public String solution(int[][] scores) {
        String answer = "";
        int n = scores.length;
        for (int i = 0; i < n; i++) {
          int self = scores[i][i];
          boolean only = true;
          int max = self;
          int min = self;
          float sum = 0;
          int count = n;
          for (int j = 0; j<n; j++) {
            if (i != j && self == scores[j][i]) {
              only = false;
            }
            if (scores[j][i] > max) max = scores[j][i];
            if (scores[j][i] < min) min = scores[j][i];
            sum += scores[j][i];
          }
          if (only && (max == self || min == self)) {
            count--;
            sum -= self;
          }
          answer += score(sum / count);
        }
        return answer;
    }
    
    public String score(float avg) {
        if(avg>=90) return "A";
        if(avg>=80) return "B";
        if(avg>=70) return "C";
        if(avg>=50) return "D";
        return "F";
    }
}
