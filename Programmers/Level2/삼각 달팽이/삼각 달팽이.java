class Solution {
    public int[] solution(int n) {
        int[] answer = new int[(n*(n+1))/2];
		int[][] snail = new int[n][n];

		int row = -1;
		int col = 0;
		int num = 1;

		for (int i = 0; i < n; ++i) {
			for (int j = i; j < n; ++j) {
				if (i % 3 == 0) {
					++row;
				} else if (i % 3 == 1) {
					++col;
				} else if (i % 3 == 2) {
					--row;
					--col;
				}
				snail[row][col] = num++;
			}
		}

		int k = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (snail[i][j] == 0) break;
				answer[k++] = snail[i][j];
			}
		}

		return answer;
    }
}
