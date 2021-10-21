import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public int solution(String dirs) {
        Map<Character, int[]> map = new HashMap<>();
        map.put('U', new int[] {0, 1});
		map.put('D', new int[] {0, -1});
		map.put('R', new int[] {1, 0});
		map.put('L', new int[] {-1, 0});

        Set<String> set = new HashSet<>();        
        int cx = 0;
        int cy = 0;

        for (char c : dirs.toCharArray()) {
			int x = map.get(c)[0];
			int y = map.get(c)[1];

            cx += x;
            cy += y;

            if(cx < -5 || cx > 5) {
                cx -= x;
                continue;
            }
            if(cy < -5 || cy > 5) {
                cy -= y;
                continue;
            }
            set.add((cx - x) + "" + (cy - y) + "" + cx + "" + cy);
			set.add(cx + "" + cy + "" + (cx - x) + "" + (cy - y));
        } 
        return set.size()/2;
    }
}
