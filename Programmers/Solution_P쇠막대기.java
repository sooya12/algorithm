package Programmers;
import java.util.Stack;

public class Solution_P쇠막대기 {
	public static void main(String[] args) {
		System.out.println(solution("()(((()())(())()))(())"));
	}
	
	public static int solution(String arrangement) {
        int answer = 0;
        Stack<Character> s = new Stack<>();
        
        for (int i = 0; i < arrangement.length(); i++) {
			if(arrangement.charAt(i) == '(' && arrangement.charAt(i + 1) != ')') {
				s.push('(');
			} else if(arrangement.charAt(i) == '(' && arrangement.charAt(i + 1) == ')') {
				answer += s.size();
				i++;
			} else if(arrangement.charAt(i) == ')') {
				s.pop();
				answer++;
			}
		}
        return answer;
    }
}
