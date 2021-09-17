class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];
		
        for (int i = 0; i < answer.length; i++) {
          for (int j = 0; j < answer[0].length; j++) {
            answer[i][j] = cij(arr1, arr2, i, j);
          }
        }
        return answer;
    }
    
    public int cij (int[][] arr1, int[][] arr2, int i, int j) {
      int answer = 0;
      for (int k = 0; k < arr2.length; k++) {
        answer += arr1[i][k]*arr2[k][j];
      }
      return answer;
    }
    
}
