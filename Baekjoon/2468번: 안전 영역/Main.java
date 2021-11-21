import java.util.*;

public class Main {
	static int N; // 행과 열의 개수
	static int[][] Map; // 2차원 배열 지도
	static int[][] transMap; // 지도 변형
	static int[] dr = {-1,1,0,0}; //상하좌우
	static int[] dc = {0,0,-1,1}; //상하좌우
	static boolean[][] check; // 방문체크
	static int count; // 안전지역 개수
	static int Max; //최대값
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 행과 열의 개수
		
		// 2차원 배열 지도
		Map = new int[N][N];
		
		//2차원 배열 입력
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				Map[i][j] = sc.nextInt();
			}
		}
		
		Max = 1;
		
		for(int i=1;i<101;i++) {
			transMap = new int[N][N];
			
			count = 0; //안전 지역 개수
			
			//방문 체크
			check = new boolean[N][N];
			
			//돌면서 높이 이하면 0, 아니면 1로 transMap 저장
			for(int a=0;a<N;a++) {
				for(int b=0;b<N;b++) {
					if(Map[a][b]<=i) {
						transMap[a][b] = 0;
					}
					else transMap[a][b] = 1;
				}
			}
			
			
			for(int a=0;a<N;a++) {
				for(int b=0;b<N;b++) {
					if(transMap[a][b]==1 && !check[a][b]) {
						Search(a,b);
						count++;
					}
					
				}
			}
			Max = Math.max(Max, count);
		}
		System.out.println(Max);
	}
	
	public static void Search(int x, int y) {
		check[x][y] = true;
		
		//4방향 확인
		for(int i=0;i<4;i++) {
			int nx = x + dr[i];
			int ny = y + dc[i];
			
			if(nx>=0 && ny>=0 && nx<N && ny<N) {
				if(transMap[nx][ny]==1 && !check[nx][ny]) {
					Search(nx,ny);
				}
			}
		}
	}
}
