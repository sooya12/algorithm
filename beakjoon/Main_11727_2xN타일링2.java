package beakjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_11727_2xN타일링2 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] f = new int[N+1];
		
		f[1] = 1;
		
		
		if(N > 1) {
			
			f[2] = 3;
			
			for (int i = 3; i < f.length; i++) {
				f[i] = (f[i-1] + f[i-2]*2)%10007;
			}
		}
		
		System.out.println(f[N]);
	}
}
