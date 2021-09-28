class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
		int i = yellow;
		int j = 1;

		for(; j <= yellow; j++) {
			if(yellow%j==0) {
				i = yellow/j;
			} else continue;

			if((i+2)*(j+2)==brown+yellow) {
				answer[0] = i+2;
				answer[1] = j+2;
                break;
			}
		}
        
        return answer;
    }
}
