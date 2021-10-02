class Solution {
    public int solution(int [][]board) {
        int answer = 0;

        for (int i = 1; i < board.length; i++) {
          for (int j = 1; j < board[0].length; j++) {
                    if(board[i][j] == 0) continue;
            board[i][j] = Math.min(Math.min(board[i][j-1], board[i-1][j]), board[i-1][j-1]) + 1;
          }
        }

        for (int[] i : board) {
          for (int j : i) {
            answer = Math.max(answer, j);
          }
        }

        return answer*answer;
    }
}
