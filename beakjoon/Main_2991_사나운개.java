package beakjoon;
import java.util.Scanner;

public class Main_2991_사나운개 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt(); // 개1 공격시간
		int b = sc.nextInt(); // 개1 쉬는시간
		int c = sc.nextInt(); // 개2 공격시간
		int d = sc.nextInt(); // 개2 쉬는시간
		
		int p = sc.nextInt(); // 우체부 도착시간
		int m = sc.nextInt(); // 우유배달원 도착시간
		int n = sc.nextInt(); // 신문배달원 도착시간
		
		int pcnt = 0;
		int mcnt = 0;
		int ncnt = 0;
		
		if(p % (a+b) != 0 && p % (a+b) <= a) pcnt++;
		if(m % (a+b) != 0 && m % (a+b) <= a) mcnt++;
		if(n % (a+b) != 0 && n % (a+b) <= a) ncnt++;
		
		if(p % (c+d) != 0 && p % (c+d) <= c) pcnt++;
		if(m % (c+d) != 0 && m % (c+d) <= c) mcnt++;
		if(n % (c+d) != 0 && n % (c+d) <= c) ncnt++;
		
		System.out.println(pcnt);
		System.out.println(mcnt);
		System.out.println(ncnt);
	}
	
}
