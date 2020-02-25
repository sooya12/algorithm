package beakjoon;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_13335_트럭 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt(); // n 개의 트럭
		int w = sc.nextInt(); // w 길이의 다리
		int l = sc.nextInt(); // 다리의 최대하중

		int time = 0; // 최소 이동 시간

		Queue<Integer> q = new LinkedList<Integer>();

		for (int i = 0; i < n; i++) {
			q.offer(sc.nextInt()); // 트럭의 무게
		}
		
		Queue<pair> qp = new LinkedList<pair>();
		
		int weight = 0;
		
		while(true) {
			
			pair p = new pair();
			
			int size = qp.size();
			
			for (int i = 0; i < size; i++) {
				p = qp.poll();
				p.location += 1;
				
				if(p.location <= w) qp.offer(p);
				else weight -= p.truck;
			}
			
			if(!q.isEmpty() && weight + q.peek() <= l) {
				int t = q.poll();
				
				qp.offer(new pair(t, 1));
				weight += t;
			}
			
			time++;
			
			if(q.isEmpty() && qp.isEmpty()) break;
		}

		System.out.println(time);
	}

}

class pair {
	int truck;
	int location;

	pair(){}
	
	pair(int truck, int location) {
		this.truck = truck;
		this.location = location;
	}
	
	@Override
	public String toString() {
		return truck + " " + location;
	}
}
