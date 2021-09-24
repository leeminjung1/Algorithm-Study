class Solution {
    public int solution(String s) {
        int answer = 0;

        for (int i = 1; i <= s.length() / 2 + 1; i++) {
          int result = splitString(s, i, 1).length();
          answer = i==1 ? result : (Math.min(answer, result));
        }

        return answer;
    }
    
    public String splitString(String s, int n, int repeat) {
        if (s.length() < n) {
          return s;
        }
        String result = "";
        String preString = s.substring(0, n);
        String postString = s.substring(n);

        if (!postString.startsWith(preString)) {
          if(repeat == 1) return result + (preString + splitString(postString, n, 1));
          return result + (repeat + preString + splitString(postString, n, 1));
        }

        return result + splitString(postString, n, repeat + 1);

    }
    
}
