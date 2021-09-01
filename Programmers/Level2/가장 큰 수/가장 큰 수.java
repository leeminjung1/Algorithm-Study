import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        String[] result = new String[numbers.length];
        
        for (int i = 0; i < numbers.length; i++) {
			result[i] = Integer.toString(numbers[i]);
		}
        
        Arrays.sort(result, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));

        if(result[0].equals("0")) return "0";
        
		for(String s : result) {
            answer += s;
        }
				
        return answer;
        
    }

}
