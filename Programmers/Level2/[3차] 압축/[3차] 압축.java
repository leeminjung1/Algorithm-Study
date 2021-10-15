import java.util.*;
class Solution {
    public int[] solution(String msg) {
        ArrayList<Integer> answer = new ArrayList<>();
        ArrayList<String> dic = new ArrayList<>();

        for (char c = 'A'; c <= 'Z'; c++) {
          dic.add(Character.toString(c));
        }

        for (int i = 0; i < msg.length(); i++) {
          for (int count = 1; count < msg.length() - i + 1; count++) {
            if (!dic.contains(msg.substring(i, i + count))) {
              answer.add(dic.indexOf(msg.substring(i,i+count-1))+1);
              dic.add(msg.substring(i, i + count));
              i += count-2;
              break;
            } else if (i + count == msg.length()) {
              answer.add(dic.indexOf(msg.substring(i,i+count))+1);
              i=msg.length()-1;
            }
          }
        }

        return answer.stream().mapToInt(i -> i).toArray();
    }
}
