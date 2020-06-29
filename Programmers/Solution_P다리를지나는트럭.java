package Programmers;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_P다리를지나는트럭 {
	public static void main(String[] args) {
		System.out.println(solution(2, 10, new int[] {7, 4, 5, 6}));
		System.out.println(solution(100, 100, new int[] {10}));
		System.out.println(solution(100, 100, new int[] {10, 10, 10, 10, 10, 10, 10, 10, 10, 10}));
	}
	
    public static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<truckInfo> q = new LinkedList<>();
        int idx = 0;
        q.offer(new truckInfo(truck_weights[idx++], 1));
        
        while(true) {
        	answer++;

        	if(q.size() == 0 && idx == truck_weights.length) break;
        	
        	int qSize = q.size();
        	int totalWeight = 0;
        	truckInfo ti;
        	
        	for (int i = 0; i < qSize; i++) {
        		ti = q.poll();
        		
        		if(ti.location + 1 <= bridge_length) {
        			totalWeight += ti.weight;
        			ti.location += 1;
        			q.offer(ti);
        		}
			}
        	
        	if(idx == truck_weights.length) continue;
        	
        	if(weight >= totalWeight + truck_weights[idx]) {
        		q.offer(new truckInfo(truck_weights[idx++], 1));
        	}
        }
        return answer;
    }
	
	static class truckInfo {
		int weight;
		int location;
		
		public truckInfo(){};
		
		public truckInfo(int weight, int location){
			super();
			this.weight = weight;
			this.location = location;
		}
		
		@Override
		public String toString() {
			return weight + " " + location;
		}
	}
}
