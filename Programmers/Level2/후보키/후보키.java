import java.util.*;
class Solution {
    public static ArrayList<String> list = new ArrayList<>();
	public static ArrayList<List<String>> candidateKeys = new ArrayList<>();
	public static int solution(String[][] relation) {
		int tuple = relation.length;
		int column = relation[0].length;
		boolean[] visited = new boolean[column];

		for(int i = 1; i <= column; i++) {
			comb(visited, 0, i);
		}

		for (String s : list) {
			HashSet<String> set = new HashSet<>();
			String[] keys = s.split("");
			for (String[] strings : relation) {
				String r = "";
				for (String key : keys) {
					r += strings[Integer.parseInt(key)];
				}
				set.add(r);
			}
			if (set.size() == tuple) {
                List<String> cKey = Arrays.asList(s.split(""));
				boolean flag = true;
				for (List<String> candidateKey : candidateKeys) {
					if (cKey.containsAll(candidateKey)) {
						flag = false;
						break;
					}
				}
				if (flag) candidateKeys.add(cKey);
			}
		}

		return candidateKeys.size();
	}

	public static void comb(boolean[] visited, int start, int r) {
		if(r == 0) {
			String num = "";
			for(int i = 0; i < visited.length; i++) {
				if(visited[i]) num += i;
			}
			list.add(num);
		} else {
			for(int i = start; i < visited.length; i++) {
				visited[i] = true;
				comb(visited, i + 1, r - 1);
				visited[i] = false;
			}
		}
	}
}
