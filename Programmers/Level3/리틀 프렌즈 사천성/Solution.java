import java.util.*;

public class Solution {
    int m, n;
    char[][] board;
    List<Character> list = new ArrayList<>();
    HashMap<Character, int[][]> map = new HashMap<>();
    public static class Point{
        int r1,c1,r2, c2;
    }
    public String solution(int m, int n, String[] board) {
        this.m = m;
        this.n = n;
        this.board = new char[m][n];
        for (int i = 0; i < m; i++) {
            this.board[i] = board[i].toCharArray();
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char c = board[i].charAt(j);
                if (c != '.' && c != '*') {
                    if (!map.containsKey(c)) {
                        list.add(c);
                        map.put(c, new int[2][2]);
                        map.get(c)[0][0] = i;
                        map.get(c)[0][1] = j;
                    } else {
                        map.get(c)[1][0] = i;
                        map.get(c)[1][1] = j;
                    }
                }
            }
        }


        Collections.sort(list);

        String answer = "";
        int idx = 0;
        while (!list.isEmpty()) {
            Character c = list.get(idx);
            if (isDeletable(c)) {
                answer += c;
                this.board[map.get(c)[0][0]][map.get(c)[0][1]] = '.';
                this.board[map.get(c)[1][0]][map.get(c)[1][1]] = '.';
                list.remove(idx);
                idx = 0;
            } else {
                idx++;
                if (idx == list.size()) {
                    answer = "IMPOSSIBLE";
                    break;
                }
            }
        }

        return answer;
    }

    public boolean isDeletable(Character c) {
        int r1 = map.get(c)[0][0];
        int c1 = map.get(c)[0][1];
        int r2 = map.get(c)[1][0];
        int c2 = map.get(c)[1][1];

        // 항상 r1 <= r2
        if (c1 < c2) {
            return (rowCheck(c2, r1, r2, c) && colCheck(r1, c1, c2, c))
                    || (rowCheck(c1, r1, r2, c) && colCheck(r2, c1, c2, c));
        }

        return (rowCheck(c2, r1, r2, c) && colCheck(r1, c2, c1, c))
                || (rowCheck(c1, r1, r2, c) && colCheck(r2, c2, c1, c));

    }

    public boolean rowCheck(int c, int r1, int r2, char ch) {
        for (int i = r1; i <= r2; i++) {
            if (board[i][c] != '.' && board[i][c] != ch) {
                return false;
            }
        }
        return true;
    }

    public boolean colCheck(int r, int c1, int c2, char ch) {
        for (int i = c1; i <= c2; i++) {
            if (board[r][i] != '.' && board[r][i] != ch) {
                return false;
            }
        }
        return true;
    }
}
