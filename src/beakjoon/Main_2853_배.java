package beakjoon;
import java.util.ArrayList;
import java.util.Scanner;

public class Main_2853_배 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		ArrayList<Integer> list = new ArrayList<>(); // 등차수열의 차
		
		int m = sc.nextInt(); // 신나는 날
		
		for (int i = 0; i < n - 1; i++) {
			 m = sc.nextInt() - 1;
			
			if(list.isEmpty()) {
				list.add(m);
			} else {
				for (int j = 0; j < list.size(); j++) {
					if(m % list.get(j) == 0) break;
					else if(j == list.size() - 1) list.add(m);
				}
			}
		}
		
		System.out.println(list.size());
	}
}
