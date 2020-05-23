package SWExpertAcademy;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_SWEA_3234_준환이의양팔저울_D4 {
	
	static int max;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수
		int N;
		int[] choo;
		
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine()); // 무게추 개수
			
			choo = new int[N];
			
			st = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < choo.length; i++) {
				choo[i] = Integer.parseInt(st.nextToken());
			}
			
			max = 0;
			
			perm(N, choo, 0, new int[N], 0, 0, new boolean[N]);
			
			bw.write("#" + tc + " " + max + "\n");
		}
		bw.flush();
	}
	
	private static void perm(int N, int[] choo, int r, int[] tmp, int left, int right, boolean[] v) {
		if(r == N) {
			max++;
			return;
		}
		
		int val;
		
		for (int i = 0; i < choo.length; i++) {
			val = choo[i];
			
			if(!v[i]) {
				v[i] = true;
				tmp[r] = val;
				
				perm(N, choo, r+1, tmp, left+val, right, v);
				
				if(left >= right+val) 
					perm(N, choo, r+1, tmp, left, right+val, v);
				
				v[i] = false;
			}
		}
	}
}