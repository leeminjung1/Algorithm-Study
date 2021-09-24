import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        ArrayList<String> answer = new ArrayList<>();
		    HashMap<String, String> map = new HashMap<>();

        for (String s : record) {
          String[] split = s.split(" ");
          if (split[0].equals("Enter")) {
            map.put(split[1], split[2]);
          } else if (split[0].equals("Change")) {
            map.put(split[1], split[2]);
          }
        }

        for (String s : record) {
          String[] split = s.split(" ");
          if (split[0].equals("Enter")) {
            answer.add(map.get(split[1]) + "님이 들어왔습니다.");
          } else if (split[0].equals("Leave")) {
            answer.add(map.get(split[1]) + "님이 나갔습니다.");
          }
        }

        return answer.toArray(new String[answer.size()]);

    }
}
