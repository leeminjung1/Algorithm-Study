class Solution {
	public int[] solution(int[][] arr) {
		answer = new int[2];
		div(0, 0, arr.length, arr);
		return answer;
	}
    
    private static int[] answer;

	public void div(int x, int y, int len, int[][] arr) {
		boolean isZero = true;
		boolean isOne = true;

		for (int i = x; i < x+len  ; i++) {
			for (int j = y; j <y+len; j++) {
				if(arr[i][j] == 1) isZero = false;
				else isOne= false;
			}
		}

		if(isOne) {
			answer[1]++;
			return;
		}
		if(isZero) {
			answer[0]++;
			return;
		}

		div(x,          y,          len/2, arr);
		div(x+len/2,    y,          len/2, arr);
		div(x,          y+len/2,    len/2, arr);
		div(x+len/2,    y+len/2,    len/2, arr);
	}

    
}
