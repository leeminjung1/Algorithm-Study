class Solution {
    static boolean check[] = new boolean[8];
    static char friends[] = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
    static int answer;
    
    public int solution(int n, String[] data) {
        StringBuilder sb = new StringBuilder();
        answer = 0;
        dfs(0,sb,data);
        return answer;
    }
    
    public void dfs(int idx,StringBuilder sb, String[] data) {
        if(idx == friends.length) {
            if(isPossible(sb,data)) {
              answer++;
            }
            return;
        }
        for(int i = 0; i < friends.length; i++) {
            if(check[i]) continue;
            check[i] = true;
            sb.append(String.valueOf(friends[i]));
            dfs(idx+1,sb,data);
            check[i] = false;
            sb.delete(idx,friends.length);
        }
    }
    
    public boolean isPossible(StringBuilder sb, String[] data) {
        for(int i = 0 ; i<data.length;i++) {
              int gap = Math.abs(sb.indexOf(String.valueOf(data[i].charAt(0))) - sb.indexOf(String.valueOf(data[i].charAt(2))))-1;
              int condition_gap = data[i].charAt(4) - '0';
              switch(data[i].charAt(3)) {
                  case '=' :
                    if(gap != condition_gap) return false;
                    break;
                  case '>' :
                    if(gap <= condition_gap) return false;
                    break;
                  case '<':
                    if(gap >= condition_gap) return false;
                    break;
              }
        }
        return true;
    }
}
