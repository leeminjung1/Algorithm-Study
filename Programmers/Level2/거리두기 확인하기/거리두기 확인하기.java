class Solution {
	public static int[] solution(String[][] places) {
		int[] answer = new int[5];
		for (int i = 0; i < 5; i++) {
			answer[i] = 1;
		}

		for (int n = 0; n < 5; n++) {
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 5; j++) {
					if (((places[n][i].charAt(j) == 'P') && ((j < 4 && places[n][i].charAt(j + 1) == 'P') ||
								(i < 4 && places[n][i + 1].charAt(j) == 'P') ||
								((j < 3 && places[n][i].charAt(j + 1) == 'O' && places[n][i].charAt(j + 2) == 'P')) ||
								((i < 3 && places[n][i + 1].charAt(j) == 'O' && places[n][i + 2].charAt(j) == 'P')) ||
								((i < 4 && j < 4 && places[n][i + 1].charAt(j + 1) == 'P') && (places[n][i].charAt(j + 1) == 'O' || places[n][i + 1].charAt(j) == 'O'))))
						|| ((i<4 && j<4 && places[n][i].charAt(j+1) == 'P' && places[n][i+1].charAt(j) == 'P') && (places[n][i+1].charAt(j+1) == 'O' || places[n][i].charAt(j) == 'O'))
					) answer[n] = 0;
				}
			}
		}

		return answer;
	}
}
