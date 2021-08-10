import java.util.*;

class Solution {
    int answer;
    
    public int solution(int[] d, int budget) {
        answer = 0;
        
        Arrays.sort(d);
        
        for(int i = 0; i < d.length; i++) {
            if(budget <= 0) {
                break;
            }
            
            if(budget - d[i] >= 0) {
                answer++;
                budget -= d[i];
            }
        }
        
        return answer;
    }
}
