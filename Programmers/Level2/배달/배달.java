class Solution {
    public int solution(int N, int[][] road, int K) {
        int[][] graph = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(i == j) graph[i][j] = 0;
                graph[i][j] = 500001;
            }
        }

        for (int[] weight : road) {
            graph[weight[1] - 1][weight[0] - 1] = Math.min(graph[weight[1] - 1][weight[0] - 1], weight[2]);
            graph[weight[0] - 1][weight[1] - 1] = Math.min(graph[weight[1] - 1][weight[0] - 1], weight[2]);
        }

        for(int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (graph[i][k] + graph[k][j] < graph[i][j]) {
                        graph[i][j] = graph[i][k] + graph[k][j];
                    }
                }
            }
        }

        int answer = 0;
        for (int j = 0; j < N; j++) {
            if(graph[0][j] <= K) answer++;
        }
        return answer;
    }
}
