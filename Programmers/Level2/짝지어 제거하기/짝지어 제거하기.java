import java.util.Stack;

class Solution {
    public int solution(String s) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
          if(stack.isEmpty() || s.charAt(stack.peek()) != s.charAt(i))
            stack.push(i);
          else
            stack.pop();
        }

        if (stack.isEmpty()) {
          answer = 1;
        }

        return answer;
    }
}
