import java.util.Arrays;
import java.util.ArrayList;
import java.util.Comparator;
class Solution {
    public int[] solution(String s) {
        ArrayList<Integer> arr = new ArrayList<>();
        String[] sets = s.replaceAll("[{]", " ").replaceAll("[}]", " ").trim().split(" , ");
        Arrays.sort(sets, Comparator.comparingInt(String::length));

        for(String s1 : sets) {
            String[] temp = s1.split(",");
            for (String ss : temp) {
                int i = Integer.parseInt(ss);
                if(!arr.contains(i)) arr.add(i);
            }
        }
        
        return arr.stream().mapToInt(Integer::valueOf).toArray();
    }
}
