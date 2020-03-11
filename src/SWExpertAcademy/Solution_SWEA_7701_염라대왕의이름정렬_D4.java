package SWExpertAcademy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Solution_SWEA_7701_염라대왕의이름정렬_D4 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt(); // 테스트 케이스 수
		
		for (int tc = 1; tc <= t; tc++) {
			int n = sc.nextInt(); // 명부의 이름 개수
			
			ArrayList<Names> list = new ArrayList<>();
			
			for (int i = 0; i < n; i++) {
				
				list.add(new Names(sc.next()));
			}
			
			Collections.sort(list);
			
			System.out.println("#" + tc);
			
			String s = list.get(0).name;
			System.out.println(s);
			
			for (int i = 1; i < list.size(); i++) {
				if(!list.get(i).name.equals(s)) {
					System.out.println(list.get(i));
					s = list.get(i).name;
				}
			}
		}
	}
	
	static class Names implements Comparable<Names>{
		String name;
		
		public Names(String name){
			this.name = name;
		}
		
		@Override
		public int compareTo(Names o) {
			if(this.name.length() > o.name.length()) {
				return 1;
			} else if(this.name.length() == o.name.length()) {
				
				int result = 1;
				
				for (int i = 0; i < this.name.length(); i++) {
					if((int)this.name.charAt(i) == (int)o.name.charAt(i)) continue;
					
					if((int)this.name.charAt(i) > (int)o.name.charAt(i)) break;
					else {
						result *= (-1);
						break;
					}
				}
				
				return result;
				
			} else {
				return -1;
			}
		}
		
		@Override
		public String toString() {
			return name;
		}	
		
	}
}
