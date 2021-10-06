import java.util.*;

class Solution {
	public int solution(String skill, String[] skill_trees) {
		ArrayList<String> skillTrees = new ArrayList<>(Arrays.asList(skill_trees));

		skillTrees.removeIf(s -> skill.indexOf(s.replaceAll("[^" + skill + "]", "")) != 0);

		return skillTrees.size();
	}
}
