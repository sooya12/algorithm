package Programmers;
public class Solution_P소수찾기 {
	
	public static void main(String[] args) {
		System.out.println(solution("17"));
		System.out.println(solution("011"));
	}
	
	static boolean[] use;
	static int cnt;
	
	public static int solution(String numbers) {
		int answer = 0;
		
		char[] numArr = numbers.toCharArray();
		use = new boolean[10000000];
		cnt = 0;
		
		perm("", numArr, new boolean[numbers.length()]);
		
		answer = cnt;
		
		return answer;
	}
	
	public static void perm(String result, char[] numArr, boolean[] v) {
		if(result.length() > numArr.length) return;
		
		if(result.length() > 0) {
//			System.out.println(result);
			int val = Integer.parseInt(result);
			
			if(val > 1 && !use[val]) {
				use[val] = true;
				boolean isPrime = true;
				
				for (int i = 2; i < val; i++) {
					if(val % i == 0) {
						isPrime = false;
						break;
					}
				}
				
				if(isPrime) {
					cnt++;
//					System.out.println(val);
				}
				
			}
		} 
		
		for (int i = 0; i < numArr.length; i++) {
			if (!v[i]) {
				v[i] = true;
				String tmp = result + numArr[i];

				perm(tmp, numArr, v);

				v[i] = false;
			}
		}
	}
}
