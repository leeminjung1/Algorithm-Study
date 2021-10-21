import java.util.*;
class Solution {
    public int solution(String dirs) {
        int answer = dirs.length();
		Dir UP = new Dir(0, 1, 'U');
		Dir DOWN = new Dir(0, -1, 'D');
		Dir LEFT = new Dir(-1, 0, 'L');
		Dir RIGHT = new Dir(1, 0, 'R');

		Dir now = new Dir(0, 0, null);

		HashSet<Dir> set = new HashSet<>();

		for (char c : dirs.toCharArray()) {

			int x=0;
			int y=0;
			if (c == 'U') {
				x = now.getX() + UP.x;
				y = now.getY() + UP.y;
			}
			if (c == 'D') {
				x = now.getX()+DOWN.x;
				y = now.getY()+DOWN.y;
			}
			if (c == 'L') {
				x = now.getX()+LEFT.x;
				y = now.getY()+LEFT.y;
			}
			if (c == 'R') {
				x = now.getX()+RIGHT.x;
				y = now.getY()+RIGHT.y;
			}
			if(x>5 || x<-5 || y>5 || y<-5) {
				answer--;
				continue;
			}
			now.setX(x);
			now.setY(y);
			now.setD(c);
			if(set.contains(now)) {
				answer--;
				continue;
			}
			set.add(now);
			Dir opp = new Dir(0,0,null);
			if (c == 'U') {
				opp = new Dir(now.getX(), now.getY() - 1, DOWN.getD());
			}
			if (c == 'D') {
				opp = new Dir(now.getX(), now.getY() + 1, 'U');
			}
			if (c == 'L') {
				opp = new Dir(now.getX()+1, now.getY(), 'R');
			}
			if (c == 'R') {
				opp= new Dir(now.getX()-1, now.getY(), 'L');
			}
			set.add(opp);

		}

		return answer;
	}

}

class Dir{
	int x;
	int y;
	Character d;

	public Dir(int x, int y, Character d) {
		this.x = x;
		this.y = y;
		this.d = d;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Character getD() {
		return d;
	}

	public void setD(Character d) {
		this.d = d;
	}

	@Override
	public String toString() {
		return "Dir{" +
				"x=" + x +
				", y=" + y +
				", d=" + d +
				'}';
	}

	@Override
	public boolean equals(Object obj) {
		if(this == obj) return true;
		if (obj instanceof Dir) {
			Dir that = (Dir) obj;
			return this.getX() == that.getX() &&
					this.getY() == that.getY() &&
					this.getD() == that.getD();
		}
		return false;
	}

	@Override
	public int hashCode() {
		return Objects.hash(getX(), getY(), getD());
	}

}
