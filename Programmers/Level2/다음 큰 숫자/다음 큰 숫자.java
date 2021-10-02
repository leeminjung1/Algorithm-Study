class Solution {
    public int solution(int n) {
        int answer = n;
        int count = 0;
        count = count(n);

        while (true) {
            answer++;
            if(count(answer) == count) return answer;
        }
    }

    public int count(int n) {
        int count = 0;
        while (n != 0) {
          if (n % 2 != 0) {
            count++;
          }
          n /= 2;
        }
        return count;
  }
}
