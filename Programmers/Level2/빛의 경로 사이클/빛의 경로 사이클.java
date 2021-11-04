import java.util.*;
class Solution {
	static boolean[][][] isVisited;
	public static int[] solution(String[] grid) {
		ArrayList<Integer> answer = new ArrayList<>();

		isVisited = new boolean[grid.length][grid[0].length()][4];
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length(); j++) {
				for (int k = 0; k < 4; k++) {
					if(!isVisited[i][j][k]) answer.add(distance(grid, i, j, k));
				}
			}
		}

		return answer.stream().sorted().mapToInt(i -> i).toArray();
	}

	public static int distance(String[] grid, int row, int col, int k) {
		int cnt = 0;
		int[] dr = { -1, 0, 1, 0 }, dc = { 0, -1, 0, 1 };
		
        	while (!isVisited[row][col][k]) {
			cnt++;
			isVisited[row][col][k] = true;

			k = switch (grid[row].charAt(col)) {
				case 'L' -> (k + 3) % 4;
				case 'R' -> (k + 1) % 4;
				default -> k;
			};

			row = (row + dr[k] + grid.length) % grid.length;
			col = (col + dc[k] + grid[0].length()) % grid[0].length();
		}

		return cnt;
	}
}
