class Solution {
    public long[] solution(long[] numbers) {
		long[] answer = numbers.clone();

		for (int i = 0; i < numbers.length; i++) {
			int count = 0;
			while (numbers[i] != 0) {
				if(numbers[i]%2 == 1) count++;
				else break;
				numbers[i] /= 2;
			}
			answer[i] += count == 0 ? 1 : Math.pow(2, count - 1);
		}
        
        return answer;
    }
}
