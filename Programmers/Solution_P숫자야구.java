package Programmers;
public class Solution_P숫자야구 {

	public static void main(String[] args) {
		System.out.println(solution(new int[][] {{123, 1, 1}, {356, 1, 0}, {327, 2, 0}, {489, 0, 1}}));
	}
	
	static int answer;
	
	public static int solution(int[][] baseball) {
        answer = 0;

        perm("", new boolean[10], baseball);
        
        return answer;
    }
	
	public static void perm(String tmp, boolean[] v, int[][] baseball) {
		if(tmp.length() == 3) {
			for (int i = 0; i < baseball.length; i++) {
				int[] brr = baseball[i];
				
				int strike = 0;
				int ball = 0;
				
				String bstr = String.valueOf(brr[0]);
				
				for (int j = 0; j < 3; j++) {
					if(tmp.charAt(j) == bstr.charAt(j)) 
						strike++;
					else if(bstr.contains(String.valueOf(tmp.charAt(j))))
						ball++;
				}
				
				if(strike != brr[1] || ball != brr[2])
					return;
			}
			answer++;
			
		} else {
			for (int i = 1; i < 10; i++) {
				if(!v[i]) {
					v[i] = true;
					String result = tmp + i;
					
					perm(result, v, baseball);
					
					v[i] = false;
				}
			}
		}
	}
}
