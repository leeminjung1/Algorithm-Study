class Solution {
    public int solution(String word) {
        int answer = word.length();
        for (int i = 0; i < word.length(); i++) {
            answer += "AEIOU".indexOf(word.charAt(i)) * (Math.pow(5, 5 - i) - 1) / 4;
        }
        return answer;
    }
}
