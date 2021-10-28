import java.util.Arrays;
class Solution {
    public static int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int[] map = new int[rows * columns];
        for (int i = 0; i < map.length; i++) {
            map[i] = i+1;
        }

        for (int i = 0; i < queries.length; i++) {
            map = rotation(queries[i], map, columns);
            answer[i] = min;
        }

        return answer;
    }
   
    public static int min;

    public static int[] rotation(int[] query, int[] map, int columns) {
        int[] newMap = map.clone();
        min = map.length;
        int upLeft = (query[0] - 1) * columns + query[1]-1;
        int upRight = (query[0] - 1) * columns + query[3]-1;
        int downRight = (query[2] - 1) * columns + query[3]-1;
        int downLeft = (query[2] - 1) * columns + query[1]-1;

        for (int i = upRight ; i > upLeft; i--) {
            newMap[i] = map[i-1];
            min = Math.min(newMap[i], min);
        }
        for (int i = downRight; i > upRight; i -= columns) {
            newMap[i] = map[i - columns];
            min = Math.min(newMap[i], min);
        }
        for (int i = downLeft; i < downRight; i++) {
            newMap[i] = map[i+1];
            min = Math.min(newMap[i], min);
        }
        for (int i = upLeft; i < downLeft; i += columns) {
            newMap[i] = map[i + columns];
            min = Math.min(newMap[i], min);
        }

        return newMap;
    }
    
}
