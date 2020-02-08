package beakjoon;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main_14888_연산자끼워넣기 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int[] num = new int[n];
		
		for (int i = 0; i < num.length; i++) {
			num[i] = sc.nextInt();
		}
		
		int[] op = new int[4];
		int sum = 0;
		
		for (int i = 0; i < op.length; i++) {
			op[i] = sc.nextInt();
			sum += op[i];
		}
		
		char[] arr = new char[sum];
		int idx = 0;
		
		for (int i = 0; i < op.length; i++) {
			switch(i) {
			
			case 0:
				for (int j = 0; j < op[i]; j++) {
					arr[idx++] = '+';
				}
				break;
			case 1:
				for (int j = 0; j < op[i]; j++) {
					arr[idx++] = '-';
				}
				break;
			case 2:
				for (int j = 0; j < op[i]; j++) {
					arr[idx++] = '*';
				}
				break;
			case 3:
				for (int j = 0; j < op[i]; j++) {
					arr[idx++] = '/';
				}
				break;
			}
		}
		
		int[] a = new int[arr.length]; // 순열의 index 순번을 저장할 배열
		
		backtrack(a, 0, a.length, num, arr);
		
		result.sort(null);
		System.out.println(result.get(result.size()-1));
		System.out.println(result.get(0));
		
	} // end of main

	/**
	 * @param a 	배열 원소의 사용 유무를 저장할 배열
	 * @param k		현재 단계
	 * @param input	단계의 끝 (=종료 조건)
	 */
	public static void backtrack(int[] a, int k, int input, int[] num, char[] arr) {
		
		if (k == input) { // 종료파트 (해인가?) is_a_solution()
			process_solution(a, k, num, arr); // 현재 단계에서 만들어낸 순열을 출력
			
		} else { // 재귀파트
			int[] c = new int[a.length - k]; // 후보군을 담을 배열 : 사용하지 않은 숫자
			int nCands = make_candidates(a, k, input, c); // 후보군의 개수
			
			for (int i = 0; i < nCands; i++) { // 후보군의 개수만큼 반복, 배열의 원소를 넣고 재귀 호출
				a[k] = c[i];
				backtrack(a, k+1, input, num, arr);
			}
		}
	}
	
	/**
	 * 후보군 배열을 세팅 후, 후보군 개수를 리턴
	 * 
	 * @param a		인덱스의 순서 배열
	 * @param k
	 * @param input
	 * @param c		사용하지 않은 숫자들의 배열
	 * @return
	 */
	public static int make_candidates(int[] a, int k, int input, int[] c) {
		boolean[] in_perm = new boolean[a.length]; // 사용한 숫자인지 체크할 플래그 변수
		
		for (int i = 0; i < k; i++) { // 현재 단계 전까지 사용한 숫자를 체크
			in_perm[a[i]] = true;
			
		}
		
		int nCands = 0; // 후보군의 개수
		
		for (int i = 0; i < in_perm.length; i++) { // 플래그 변수에서 false인 숫자를 후보군으로 만들기
			if(!in_perm[i]) {
				c[nCands++] = i;
			}
		}
		
		return nCands; // 후보군의 개수 리턴
	}

	/**
	 * a 배열의 원소를 보고 순열을 출력
	 * 
	 * @param a		원소 사용 여부가 들어있는 배열
	 * @param k		k개 만큼 출력
	 */
	
	static ArrayList<Integer> result = new ArrayList<>();
	
	public static void process_solution(int[] a, int k, int[] num, char[] arr) {
		char[] c = new char[a.length];
		for (int i = 0; i < k; i++) {
			c[i] = arr[a[i]]; // 저장된 순번
		}
		
		int idx = 0;
		int total = num[idx++];
		
		for (int i = 0; i < c.length; i++) {
			switch(c[i]) {
			
			case '+':
				total += num[idx++];
				break;
				
			case '-':
				total -= num[idx++];
				break;
				
			case '*':
				total *= num[idx++];
				break;
				
			case '/':
				total /= num[idx++];
				break;
			}
		}
		
		result.add(total);
	}
}
