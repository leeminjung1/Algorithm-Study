import java.util.Queue;
import java.util.LinkedList;
class Solution {
    public int[] solution(int m, int n, int[][] picture) {
        int count = 0;
        int max = 0;
        int[] answer = new int[2];
        int[][] cpic = new int[m][n];

        for (int i = 0; i < m; i++) {
          for (int j = 0; j < n; j++) {
            cpic[i][j] = picture[i][j];
          }
        }

        for (int i = 0; i < m; i++) {
          for (int j = 0; j < n; j++) {
            int t = cpic[i][j];
            if (t != 0) {
              count++;
              cpic[i][j] = 0;
              max = Math.max(max, bfs(cpic, i, j, t));
            }
          }
        }

        answer[0] = count;
        answer[1] = max;

        return answer;
    }
    
    public int bfs(int[][] picture, int i, int j, int t) {
        int result = 1;
        int m = picture.length;
        int n = picture[0].length;
        int[][] direction = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
        Queue<int[]> queue = new LinkedList<>();
        
        queue.offer(new int[] {i,j});
        while (!queue.isEmpty()) {
          int[] current = queue.poll();
          for (int[] d : direction) {
            int x = current[0] + d[0];
            int y = current[1] + d[1];
            if (x >= 0 && x < m && y >= 0 && y < n && picture[x][y] == t) {
              result++;
              picture[x][y] = 0;
              queue.offer(new int[]{x, y});
            }
          }
        }

        return result;

	}
}
