class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder answer = new StringBuilder();
		StringBuilder str = new StringBuilder();
		int num = t*m;

		String[] overTen = {"A", "B", "C", "D", "E", "F"};
		str.append("0");
		for (int i = 1; i < num; i++) {
			int j = i;
			StringBuilder s = new StringBuilder();
			while (j != 0) {
				if(j%n>=10) {
					s.append(overTen[j%n-10]);
				} else s.append(j%n);
				j /= n;
			}
			str.append(s.reverse());
		}

		for (int i = 0; i < t; i++) {
			answer.append(str.charAt(p - 1));
			p += m;
		}

		return answer.toString();
    }
}
