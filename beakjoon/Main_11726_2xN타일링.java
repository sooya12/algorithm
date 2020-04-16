package beakjoon;
import java.util.Scanner;

public class Main_11726_2xN타일링 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] f = new int[N+1];
		
		f[1] = 1;
		
		
		if(N > 1) {
			
			f[2] = 2;
			
			for (int i = 3; i < f.length; i++) {
				f[i] = (f[i-1] + f[i-2])%10007;
			}
		}
		
		System.out.println(f[N]);
	}
}
