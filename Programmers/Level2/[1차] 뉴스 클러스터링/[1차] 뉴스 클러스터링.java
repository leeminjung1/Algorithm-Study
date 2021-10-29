import java.util.*;
class Solution {
    public int solution(String str1, String str2) {
        ArrayList<String> arr1 = makeArray(str1);
        ArrayList<String> arr2 = makeArray(str2);
        
        int size1 = arr1.size();
        int size2 = arr2.size();
        
        if(size1 == size2 && size1 == 0) return 65536;

        int inter = 0;

        for (int i = 0; i < arr1.size(); i++) {
            for (int j = 0; j < arr2.size(); j++) {
                if (Objects.equals(arr1.get(i), arr2.get(j))) {
                    arr1.remove(i--);
                    arr2.remove(j);
                    inter++;
                    break;
                }
            }
        }

        return (int) ((float) inter / (size1+ size2 - inter ) * 65536);
    }
    
    public ArrayList<String> makeArray(String s) {
        ArrayList<String> arr = new ArrayList<>();
        s = s.toLowerCase();
          for (int i = 0; i < s.length()-1; i++) {
              String ss = s.substring(i, i+2);
              if (ss.matches("[a-z]*")) {
                  arr.add(ss);
              }
          }
        return arr;
    }

}
