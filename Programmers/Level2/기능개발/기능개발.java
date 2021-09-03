import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = new int[100];	// 최대 100일 걸리므로 배열의 크기를 100으로.
	
	// n일 걸리는 작업의 개수를 count하여 배열의 n번째 원소에 넣기
	int day = -1;
	for(int i=0; i<progresses.length; i++) {
		while(progresses[i] + speeds[i]*day < 100) {
			day++;
		}
		answer[day]++;
	}

	// stream 사용하여 람다식으로
	// filter사용해서 0이 아닌 값들만 걸러주기
	return Arrays.stream(answer).filter(i->i!=0).toArray();
    }
}
