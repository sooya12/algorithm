package beakjoon;
import java.util.Scanner;

public class Main_8958_OX퀴즈 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int testCase = sc.nextInt();
		
		for(int i = 0; i < testCase; i++) {
			String result = sc.next();
			String[] str = result.split("");
			
			int cnt = 0;
			int sum = 0;
			
			for(int j = 0; j < str.length; j++) {
				
				if(str[j].equals("O")) {
					cnt++;
					sum += cnt;
				} else {
					cnt = 0;
				}
			}
			System.out.println(sum);
		}
	}
}
