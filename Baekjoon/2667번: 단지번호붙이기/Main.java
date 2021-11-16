import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];
        int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = Character.getNumericValue(s.charAt(j));
            }
        }

        ArrayList<Integer> arrayList = new ArrayList<>();

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(map[i][j] == 1) {
                    map[i][j] = 0;
                    int result = 1;
                    Queue<int[]> queue = new LinkedList<>();
                    queue.offer(new int[]{i, j});
                    while (!queue.isEmpty()) {
                        int[] now = queue.poll();
                        for (int k = 0; k < 4; k++) {
                            int dx = now[0] + dir[k][0];
                            int dy = now[1] + dir[k][1];
                            if (dx >= 0 && dx < n && dy >= 0 && dy < n && map[dx][dy] != 0) {
                                result++;
                                queue.offer(new int[]{dx, dy});
                                map[dx][dy] = 0;
                            }
                        }
                    }
                    arrayList.add(result);
                }
            }
        }

        System.out.println(arrayList.size());
        Collections.sort(arrayList);
        arrayList.forEach(System.out::println);

    }

}
