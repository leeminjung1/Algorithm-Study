import java.io.*;
import java.util.*;
class Main {
	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		int m = scanner.nextInt();
		int n = scanner.nextInt();
		ArrayList<Integer> A = new ArrayList<>();
		for(int i=0; i<m+n; i++){
			A.add(scanner.nextInt());
		}
		
		Collections.sort(A);
		
		Arrays.stream(A.toArray()).forEach(a->System.out.print(a+" "));
	}
}
