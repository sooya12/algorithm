package beakjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_9290_틱택토이기기 {

	static char[][] map;
	static char namgyu;
	static int[][] x;
	static int[][] o;
	static int xidx;
	static int oidx;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			sb.append("Case " + tc + ":\n");
			
			map = new char[3][3];
			x = new int[2][2];
			o = new int[2][2];
			xidx = 0;
			oidx = 0;
			
			for (int i = 0; i < 3; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				String s = st.nextToken();
				
				for (int j = 0; j < 3; j++) {
					map[i][j] = s.charAt(j);
					
					if(map[i][j] == 'x') {
						x[xidx][0] = i;
						x[xidx++][1] = j;
					} else if(map[i][j] == 'o') {
						o[oidx][0] = i;
						o[oidx++][1] = j;
					}
				}
			}
			
			namgyu = br.readLine().charAt(0);
			
			x : for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					if(map[i][j] == '-') {
						if(check(i, j)) {
							map[i][j] = namgyu;
							break x;
						}
					}
				}
			}
			
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					sb.append(map[i][j]);
				}
				sb.append("\n");
			}
		}
		System.out.println(sb.toString());
	}
	
	private static boolean check(int r, int c) {
		boolean flag = false;
		
		if(namgyu == 'x') {
			if(x[0][0] == x[1][0] && x[0][0] == r) {
				flag = true;
			} else if(x[0][1] == x[1][1] && x[0][1] == c) {
				flag = true;
			} else if(x[0][0] == x[0][1] && x[1][0] == x[1][1] && r == c) {
				flag = true;
			} else if(x[0][0] + x[0][1] == 2 && x[1][0] + x[1][1] == 2 && r + c == 2) {
				flag = true;
			}
		} else {
			if(o[0][0] == o[1][0] && o[0][0] == r) {
				flag = true;
			} else if(o[0][1] == o[1][1] && o[0][1] == c) {
				flag = true;
			} else if(o[0][0] == o[0][1] && o[1][0] == o[1][1] && r == c) {
				flag = true;
			} else if(o[0][0] + o[0][1] == 2 && o[1][0] + o[1][1] == 2 && r + c == 2) {
				flag = true;
			}
		}
		
		return flag;
	}
}
