import java.util.*;
class Solution {
	static HashMap<String, List<Integer>> map;
	static ArrayList<Integer> arrayList;
	public static int[] solution(String[] info, String[] query) {
		int[] answer = new int[query.length];
		map = new HashMap<>();

		// 1. info 모든 경우의 수 map에 저장
		for (String s : info) {
			dfs("", 0, s.split(" "));
		}

		// 2. map에 저장된 점수 list 오름차순으로 정렬
		List<String> list = new ArrayList<>(map.keySet());
		for (String s : list) {
			List<Integer> scoreList = map.get(s);
			Collections.sort(scoreList);
		}

		// 3. 이분탐색
		for (int i = 0; i < query.length; i++) {
			query[i] = query[i].replaceAll(" and ", "");
			String[] str = query[i].split(" ");
			int score = Integer.parseInt(str[1]);
			answer[i] = search(str[0], score);
		}

		return answer;
	}

	private static int search(String s, int score) {
		if(!map.containsKey(s)) return 0;
		List<Integer> scoreList = map.get(s);
		int start= 0, end = scoreList.size()-1;
		while(start <= end) {
			int mid = (start + end) / 2;
			if(scoreList.get(mid) < score) {
				start = mid + 1;
				continue;
			}
			end = mid - 1;
		}
		return scoreList.size() - start;
	}

	private static void dfs(String s, int depth, String[] info) {
		if (depth == 4) {
			if (!map.containsKey(s)) {
				arrayList = new ArrayList<>();
				arrayList.add(Integer.parseInt(info[4]));
				map.put(s, arrayList);
				return;
			}
			map.get(s).add(Integer.parseInt(info[4]));
			return;
		}
		dfs(s + "-", depth + 1, info);
		dfs(s + info[depth], depth + 1, info);
	}
}
