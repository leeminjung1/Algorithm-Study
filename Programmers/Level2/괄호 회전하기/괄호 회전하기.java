import java.util.Stack;
class Solution {
    public int solution(String s) {
        int answer = 0;

        for (int i = 0; i < s.length(); i++) {
          if(isPerfectBracket(s)) answer++;
          s = s.substring(1) + s.charAt(0);
        }

        return answer;
    }
    
    public boolean isPerfectBracket(String s) {
      Stack<Character> stack = new Stack<>();

      String leftBrackets = "({[";
      String rightBrackets = ")}]";

      for (int i = 0; i < s.length(); i ++) {
        if (stack.isEmpty()) {
          stack.push(s.charAt(i));
        }
        else if(leftBrackets.indexOf(stack.peek()) == rightBrackets.indexOf(s.charAt(i))
            && leftBrackets.indexOf(stack.peek())!= -1) {
          stack.pop();
        } else {
          stack.push(s.charAt(i));
        }
      }
      return stack.isEmpty();
    }
    
}
