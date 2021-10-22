import java.io.*;
import java.util.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		int n = Integer.parseInt(input);
		int[] c = new int[n];
		for(int i=0; i<n; i++) {
			c[i]= Integer.parseInt(br.readLine());
		}
	
		int min = 0;
		for(int i = 0; i < n-1; i++){
			min = i;
			for(int j = i+1; j < n; j++){
				if(Math.abs(c[min]) < Math.abs(c[j]))
					min = j;
			}
			int tmp = c[min];
			c[min] = c[i];
			c[i] = tmp;
		}

		int count = 1;
		for (int i = 0; i < n-1; i++) {
			if(c[i]*c[i+1] < 0) count++;
		}
		
		System.out.println(count);
	}
}
