class Solution {
    public int solution(String s) {
		for(English e : English.values()) {
			s = s.replace(e.name(), Integer.toString(e.ordinal()));
		}
		return Integer.parseInt(s);
	}

	public enum English {
		zero, one, two, three, four, five, six, seven, eight, nine;
	}
}
