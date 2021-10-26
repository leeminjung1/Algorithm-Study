import java.util.*;
class Solution {
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        int[][] move = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});

        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int x = node[0];
            int y = node[1];

            if (x == n - 1 && y == m - 1) {
                return maps[x][y];
            }

            for (int[] go : move) {
                int dx = x + go[0];
                int dy = y + go[1];
                if (dx >= 0 && dx < n && dy >= 0 && dy < m && maps[dx][dy] == 1) {
                    queue.add(new int[] {dx, dy});
                    maps[dx][dy] = maps[x][y] + 1;
                }
            }
        }

        return -1;
    }
}
