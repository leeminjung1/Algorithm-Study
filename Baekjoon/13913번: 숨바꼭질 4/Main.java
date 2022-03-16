import java.io.*;
import java.util.StringTokenizer;
import java.util.Deque;
import java.util.ArrayDeque;
import java.util.Arrays;

public class Main {
    static int[] path = new int[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int ans;
        if(K<=N) {
            sb.append(N-K).append("\n");
            for (int i=N;i>=K;i--) sb.append(i).append(" ");
        }
        else {
            Arrays.fill(path,-1);
            ans = bfs(N,K);
            sb.append(ans).append("\n");
            int tmp = K;
            int[] ans_path = new int[ans+1];
            for (int i=ans;i>=0;i--) {
                ans_path[i]=tmp;
                if(i>0) tmp=path[tmp];
            }
            for (int num : ans_path) sb.append(num).append(" ");
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }

    public static int bfs(int n, int k) {
        Deque<Integer> q = new ArrayDeque<>();
        q.add(n);
        path[n]=-2; // 시작지점이라는 뜻
        int now;
        int temp=0;
        int size;
        int time=0;
        boolean findAns=false;

        while(!q.isEmpty()) {
            if(findAns) break;
            size = q.size();

            for (int s=0;s<size;s++) {
                if(findAns) break;
                now = q.poll();
                for (int i=0;i<3;i++) {
                    switch(i) {
                        case 0 :
                            temp=now-1;
                            break;
                        case 1 :
                            temp=now+1;
                            break;
                        case 2 :
                            temp=2*now;
                    }
                    if (temp>=0 && temp<=100000 && path[temp]==-1) {
                        q.add(temp);
                        path[temp]=now;
                        if (temp==k) {
                            findAns=true;
                            break;
                        }
                    }
                }
            }
            time++;
        }
        return time;
    }
}
