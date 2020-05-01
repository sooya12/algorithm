package SWExpertAcademy;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_SWEA_5658_보물상자비밀번호 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			String input = br.readLine().trim();
			
			List<String> list = new ArrayList<>();
			
			int cnt = 0;
			while(cnt++ < N/4) {
				for (int i = 0; i < N; i+= N/4) {
					String s = "";
					for (int j = 0; j < N/4; j++) {
						s += input.charAt(i+j);
					}
					
					if(!list.contains(s)) list.add(s);
				}
				
				String tmp = input.substring(input.length()-1);
				input = tmp + input.substring(0, input.length()-1);
			}
			
			ArrayList<Integer> resultList = new ArrayList<>();
			
			for(String s : list) {
				resultList.add(Integer.parseInt(s, 16));
			}
			Collections.sort(resultList);
			Collections.reverse(resultList);
			
			System.out.println("#" + tc + " " + resultList.get(K-1));
		}
	}
}
