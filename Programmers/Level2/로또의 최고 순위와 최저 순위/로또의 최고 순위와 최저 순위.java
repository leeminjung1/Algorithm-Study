class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = {7, 7};

        for(int i = 0; i<6; i++) {
          for(int j = 0; j<6; j++) {
            if(lottos[i] == win_nums[j]) {
              answer[0]--;
              answer[1]--;
              break;
            } else if(lottos[i] == 0){
              answer[0]--;
              break;
            }
          }
        }

        for (int i = 0; i < 2; i++) {
          if(answer[i] == 7) answer[i] = 6;
        }

        return answer;
    }
}
