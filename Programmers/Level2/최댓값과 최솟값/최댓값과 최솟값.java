import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        String[] split = s.split("\\s");

        int maxValue = Arrays.stream(Arrays.stream(split).mapToInt(Integer::parseInt).toArray())
            .max()
            .getAsInt();

        int minValue = Arrays.stream(Arrays.stream(split).mapToInt(Integer::parseInt).toArray())
            .min()
            .getAsInt();


        answer += minValue + " " + maxValue;

        return answer;
    }
}
