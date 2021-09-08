import java.util.HashMap;
import java.util.Iterator;

class Solution {
    public int solution(String[][] clothes) {
       int answer = 1;
        HashMap<String, Integer> hashMap = new HashMap<>();

        for(int i=0; i<clothes.length; i++) {
            if (hashMap.containsKey(clothes[i][1])) hashMap.put(clothes[i][1], hashMap.get(clothes[i][1]) + 1);
            else hashMap.put(clothes[i][1], 2);
        }

        for (Iterator<Integer> i = hashMap.values().iterator(); i.hasNext(); ) answer *= i.next();
        return answer -1;
    }
}
