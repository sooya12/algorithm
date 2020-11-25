package Programmers;
import java.util.PriorityQueue;

public class Solution_P더맵게 {

	public static void main(String[] args) {
	
	}
	
	public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i = 0; i < scoville.length; i++) {
            pq.add(scoville[i]);
        }
        
        int first, second;
        
        while(true) {
            first = pq.poll();
            
            if(first >= K) {
                break;
            }
            
            if(pq.size() < 1) {
                answer = -1;
                break;
            }
            
            second = pq.poll();
            
            pq.add(first + second * 2);
            answer++;
        }
        
        return answer;
    }
}
