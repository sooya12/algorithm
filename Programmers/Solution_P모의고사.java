package Programmers;
import java.util.ArrayList;

public class Solution_P모의고사 {
	
	static int[] one = {1, 2, 3, 4, 5};
	static int[] two = {2, 1, 2, 3, 2, 4, 2, 5};
	static int[] three = {3, 3, 1, 1 ,2 ,2 ,4, 4, 5, 5};
	
	public static int[] solution(int[] answers) {
		int[] answer = {};
		int[] result = new int[3];
		
		for (int i = 0; i < answers.length; i++) {
			if(answers[i] == one[i%one.length]) result[0]++;
			if(answers[i] == two[i%two.length]) result[1]++;
			if(answers[i] == three[i%three.length]) result[2]++;
		}
		
		int max = 0;
		
		for (int i = 0; i < result.length; i++) {
			max = Math.max(max, result[i]);
		}
		
		ArrayList<Integer> list = new ArrayList<>();
		
		for (int i = 0; i < result.length; i++) {
			if(max == result[i]) list.add(i + 1);
		}
		
		answer = new int[list.size()];
		for (int i = 0; i < answer.length; i++) {
			answer[i] = list.get(i);
		}
		
		return answer;
	}
}
