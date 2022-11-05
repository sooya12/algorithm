import java.util.*;

class Solution {
    public String solution(int[] food) {
        String answer = "";
        StringBuilder front = new StringBuilder();
        
        for(int i = 1; i < food.length; i++) {
            if(food[i] > 1) {
                for(int j = 0; j < food[i] / 2; j++) {
                    front.append(i);
                }
            }            
        }
        
        answer = front.toString() + "0" + front.reverse().toString();
        
        return answer;
    }
}
