package beakjoon;
import java.util.Scanner;

public class Main_1244_스위치켜고끄기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt(); // 스위치 개수
		
		int[] arr = new int[n+1]; // 스위치 배열
		
		for (int i = 1; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		
		int person = sc.nextInt();
		
		int[][] command = new int[person][2];
		
		for (int i = 0; i < person; i++) {
			command[i][0] = sc.nextInt();
			command[i][1] = sc.nextInt();
		}
		
		for (int i = 0; i < command.length; i++) {
			
			if(command[i][0] == 1) { // 남자
				for (int j = command[i][1]; j < arr.length; j+= command[i][1]) {
					arr[j] = change(arr[j]);
				}
			}
			if(command[i][0] == 2) { // 여자
				arr[command[i][1]] = change(arr[command[i][1]]);
				
				if(command[i][1] != 1) {
					for (int j = 1; j < arr.length; j++) {
						if((command[i][1]-j < 1 || command[i][1]+j > arr.length-1) 
								|| arr[command[i][1]-j] != arr[command[i][1]+j]) break;
						else {
							arr[command[i][1]-j] = change(arr[command[i][1]-j]);
							arr[command[i][1]+j] = change(arr[command[i][1]+j]);
						}
					}
				}
			}
		}
		
		for (int i = 1; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
			
			if(i >= 20 && i % 20 == 0) System.out.println();
		}
	}
	
	static int change(int n) {
		if(n == 0) return 1;
		else return 0;
	}
}
