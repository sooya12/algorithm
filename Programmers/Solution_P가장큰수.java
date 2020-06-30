package Programmers;
import java.util.Arrays;
import java.util.Comparator;

public class Solution_P가장큰수 {

	public static void main(String[] args) {
//		System.out.println(solution(new int[] {6, 10, 2}));
		System.out.println(solution(new int[] {3, 30, 34, 5, 9}));
//		System.out.println(solution(new int[] {0, 0, 0, 0, 0}));
//		System.out.println(solution(new int[] {2, 20, 200}));
//		System.out.println(solution(new int[] {34, 344}));
		System.out.println(solution(new int[] {6, 646}));
//		System.out.println(solution(new int[] {12, 121}));
		System.out.println(solution(new int[] {21, 212}));
//		System.out.println(solution(new int[] {1, 2, 3, 2, 1}));
//		System.out.println(solution(new int[] {2, 1, 322, 301, 34, 5, 9}));
		System.out.println(solution(new int[] {0, 0, 70}));
//		System.out.println(solution(new int[] {0, 0, 0, 1000}));
//		System.out.println(solution(new int[] {0, 0, 1000, 0}));
		System.out.println(solution(new int[] {1000, 0, 0, 0}));
		System.out.println(solution(new int[] {40, 403}));
	}
	
	public static String solution(int[] numbers) {
        String answer = "";
        
        Integer[] numArr = Arrays.stream(numbers).boxed().toArray(Integer[]::new);
        
		Arrays.sort(numArr, new CompareArray());
		
		numbers = Arrays.stream(numArr).mapToInt(Integer::intValue).toArray();
		
		System.out.println(Arrays.toString(numbers));
		
		for (int i = 0; i < numbers.length; i++) {
			if(answer.equals("0") && numbers[i] == 0) continue;
			answer += numbers[i];
		}
		
        return answer;
    }
	
	static class CompareArray implements Comparator<Integer> {

		@Override
		public int compare(Integer o1, Integer o2) {
			String s1 = String.valueOf(o1);
			String s2 = String.valueOf(o2);
			
			if(Integer.parseInt(s1 + s2) > Integer.parseInt(s2 + s1)) 
				return -1;
			else if(Integer.parseInt(s1 + s2) < Integer.parseInt(s2 + s1))
				return 1;
			else
				return 0;
		}
	}
}
