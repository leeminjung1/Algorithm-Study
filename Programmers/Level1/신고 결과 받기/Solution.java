import java.util.*;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];

        HashMap<String, Integer> idMap = new HashMap<>();
        HashMap<String, ArrayList<String>> reported = new HashMap<>();

        int id = 0;
        for (String s : id_list) {
            idMap.put(s, id++);
            reported.put(s, new ArrayList<>());
        }

        String a, b;
        for (String s : report) {
            a = s.split(" ")[0];
            b = s.split(" ")[1];

            if (!reported.get(b).contains(a)) {
                reported.get(b).add(a);
            }
        }

        for (String s : reported.keySet()) {
            ArrayList<String> list = reported.get(s);
            if (list.size() >= k) {
                for (String s1 : list) {
                    answer[idMap.get(s1)]++;
                }
            }
        }

        return answer;
    }
}
