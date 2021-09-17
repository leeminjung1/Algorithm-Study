class Solution {
  public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        String [] lower = s.toLowerCase().split("");
        boolean flag = true;

        for (String ss : lower) {
          answer.append(flag ? ss.toUpperCase() : ss);
          flag = ss.equals(" ");
        }

        return answer.toString();
  }
}
