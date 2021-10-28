import java.util.Arrays;
class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int[] map = new int[rows * columns];
        for (int i = 0; i < map.length; i++) {
            map[i] = i+1;
        }

        for (int i = 0; i < queries.length; i++) {
            map = rotation(queries[i], map, columns);
            answer[i] = min(map, queries[i], columns);
        }
        return answer;
    }
    
    public int[] rotation(int[] query, int[] map, int columns) {
        int[] newMap = map.clone();
        int x1 = query[0];
        int y1 = query[1];
        int x2 = query[2];
        int y2 = query[3];

        int up = newMap[(x1 - 1) * columns + y2-1];
        int downRight = newMap[(x2 - 1) * columns + y2-1];
        int downLeft = newMap[(x2 - 1) * columns + y1-1];

        for (int i = (x1 - 1) * columns + y2-1 ; i > (x1 - 1) * columns + y1-1; i--) {
            newMap[i] = newMap[i-1];
        }
      
        for (int i = (x2 - 1) * columns + y2-1; i > (x1 - 1) * columns + y2-1; i -= columns) {
            newMap[i] = newMap[i - columns];
        }
        newMap[(x1) * columns + y2-1] = up;

        for (int i = (x2 - 1) * columns + y1-1; i < (x2 - 1) * columns + y2-1; i++) {
            newMap[i] = newMap[i+1];
        }
        newMap[(x2 - 1) * columns + y2-2] = downRight;
      
        for (int i = (x1 - 1) * columns + y1 - 1; i < (x2 - 1) * columns + y1 - 1; i += columns) {
            newMap[i] = newMap[i + columns];
        }
        newMap[(x2 - 2) * columns + y1 - 1] = downLeft;
  
        return newMap;
    }

    public int min(int[] map, int[] query, int columns) {
        int x1 = query[0];
        int y1 = query[1];
        int x2 = query[2];
        int y2 = query[3];

        int min = map.length;

        for (int i = (x1 - 1) * columns + y1 - 1; i <= (x1 - 1) * columns + y2 - 1; i++) {
            if(map[i] < min) min = map[i];
        }

        for (int i = (x1 - 1) * columns + y2-1; i <= (x2 - 1) * columns + y2-1; i+= columns) {
            if(map[i] < min) min = map[i];
        }

        for (int i = (x2 - 1) * columns + y1-1; i <= (x2 - 1) * columns + y2-1; i++) {
            if(map[i] < min) min = map[i];
        }

        for (int i = (x1 - 1) * columns + y1 - 1; i <= (x2 - 1) * columns + y1-1; i+=columns) {
            if(map[i] < min) min = map[i];
        }
        return min;
    }
    
}
