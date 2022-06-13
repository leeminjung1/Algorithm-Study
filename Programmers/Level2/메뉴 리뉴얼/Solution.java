import java.util.*;

class Solution {
    static HashMap<String,Integer> map;
    static int max;
    public static String[] solution(String[] orders, int[] course) {
        PriorityQueue<String> pq = new PriorityQueue<>();
        for (int n : course) {
            map = new HashMap<>();
            max = 0;
            for (String order : orders) {
                dfs(0, 0, n, "", order);
            }
            for (String s : map.keySet()) {
                if (max >= 2 && map.get(s) == max) {
                    pq.offer(s);
                }
            }
        }
        String[] ans = new String[pq.size()];
        int k = 0;
        while (!pq.isEmpty()){
            ans[k++] = pq.poll();
        }
        return ans;
    }

    static void dfs(int depth, int idx, int n, String str, String order) {
        if (depth == n) {
            char[] c = str.toCharArray();
            Arrays.sort(c);
            String temps = String.valueOf(c);
            map.put(temps, map.getOrDefault(temps, 0) + 1);
            max = Math.max(max, map.get(temps));
            return;
        }
        for (int i = idx; i < order.length(); i++) {
            dfs(depth + 1, i + 1, n, str + order.charAt(i), order);
        }
    }
}
