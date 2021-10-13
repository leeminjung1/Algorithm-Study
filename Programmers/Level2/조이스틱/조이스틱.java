class Solution {
    public int solution(String name) {
        int answer = 0;
		for (char c : name.toCharArray()) {
			answer += Math.min('Z' - c + 1, c - 'A');
		}

		int min_move = name.length() - 1;
		for (int i = 0; i < name.length(); i++) {
			int next = i + 1;
			while (next < name.length() && name.charAt(next) == 'A') next++;
			min_move = Math.min(min_move, 2 * i + name.length() - next);
		}

		return answer + min_move;
	}
}
