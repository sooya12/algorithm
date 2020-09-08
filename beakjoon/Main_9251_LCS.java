package beakjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_9251_LCS {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String a = br.readLine(); // 첫번째 줄 입력
		String b = br.readLine(); // 두번째 줄 입력
		
		int sizeA = a.length();
		int sizeB = b.length();
		
		int[][] result = new int[sizeA+1][sizeB+1];
		
		for (int i = 1; i < sizeA+1; i++) {
			for (int j = 1; j < sizeB+1; j++) {
				if(a.charAt(i-1) == b.charAt(j-1)) {
					result[i][j] = result[i-1][j-1] + 1;
				} else {
					result[i][j] = Math.max(result[i-1][j], result[i][j-1]);
				}
			}
		}
		
		System.out.println(result[sizeA][sizeB]);
	}
	
}
