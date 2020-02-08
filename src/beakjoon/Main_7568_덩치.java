package beakjoon;
import java.util.Scanner;

public class Main_7568_덩치{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[][] arr = new int[n][3];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i][0] = sc.nextInt(); //������
			arr[i][1] = sc.nextInt(); //Ű
			arr[i][2] = 1; //���
		}
		
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if(j == i) continue;
				
				if(arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1]) {
					arr[i][2] += 1;
				}
				
			}
			
		}
		
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i][2] + " ");
		}
	}
}
