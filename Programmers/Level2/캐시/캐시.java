import java.util.LinkedList;
class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        int cacheHit = 1;
		int cacheMiss = 5;

		if (cacheSize == 0) return cities.length * cacheMiss;

		LinkedList<String> cache = new LinkedList<>();

		for (int i = 0; i < cities.length; i++) {
			String city = cities[i].toUpperCase();
			if (cache.remove(city)) {
				cache.addFirst(city);
				answer += cacheHit;
			} else {
				if (cache.size() == cacheSize) {
					cache.pollLast();
				}
				cache.addFirst(city);
				answer += cacheMiss;
			}
		}
        
        return answer;
    }
}
