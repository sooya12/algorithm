package beakjoon;
import java.util.Scanner;
import java.util.Stack;

public class Main_4949_균형잡힌세상 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			String s = sc.nextLine();
			
			if(s.equals(".")) break; // 문자열 전체 . 만 나오면 종료
			
			String[] srr = s.split("");
			
			Stack<String> st = new Stack<String>();
			
			for (int i = 0; i < srr.length; i++) {
				if(srr[i].equals("(") || srr[i].equals("[")) {
					st.add(srr[i]);
					continue;
				} 
				
				if(srr[i].equals(")") && !st.isEmpty() && st.peek().equals("(")) {
					st.pop();
					continue;
				} 
				
				if(srr[i].equals("]") && !st.isEmpty() && st.peek().equals("[")) {
					st.pop();
					continue;
				} 
				
				if(srr[i].equals(")") || srr[i].equals("]")) st.add(srr[i]);
				
			}
			
			if(st.isEmpty()) System.out.println("yes");
			else System.out.println("no");
		}
	}
}	
