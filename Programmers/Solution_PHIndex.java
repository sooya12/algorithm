package Programmers;
import java.util.Arrays;
import java.util.Collections;

public class Solution_PHIndex {

	public static void main(String[] args) {
		System.out.println(solution(new int[] {3, 0, 6, 1, 5}));
		System.out.println(solution(new int[] {0, 1, 1, 1, 1, 3, 3, 4}));
		System.out.println(solution(new int[] {2}));
		System.out.println(solution(new int[] {0, 0, 0, 0}));
		System.out.println(solution(new int[] {2, 7, 5}));
		System.out.println(solution(new int[] {22, 42}));
		System.out.println(solution(new int[] {20, 19, 18, 1}));
	}
	
	public static int solution(int[] citations) {
        int answer = 0;
        
        Arrays.sort(citations);
        
        for (int i = 0; i < citations.length; i++) {
        	if(citations[i] < 1) continue;
        	
        	for (int j = 1; j <= citations[i]; j++) {
				if(citations.length - i >= j && i <= j && answer < j) answer = j;
			}
		}
        
        return answer;
    }
}
