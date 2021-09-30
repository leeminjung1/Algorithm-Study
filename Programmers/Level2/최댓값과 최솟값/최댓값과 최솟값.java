import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        String[] split = s.split("\\s");

        int maxValue = Arrays.stream(split).mapToInt(Integer::parseInt)
				.max()
				.getAsInt();

		int minValue = Arrays.stream(split).mapToInt(Integer::parseInt)
				.min()
				.getAsInt();


        answer += minValue + " " + maxValue;

        return answer;
    }
}
