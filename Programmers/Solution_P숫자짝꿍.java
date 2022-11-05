import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        StringBuilder answer = new StringBuilder();
        int[] xrr = new int[10];
        int[] yrr = new int[10];
        
        for(int i = 0; i < X.length(); i++) {
            char c = X.charAt(i);
            xrr[c - '0']++;
        }
        
        for(int i = 0; i < Y.length(); i++) {
            char c = Y.charAt(i);
            yrr[c - '0']++;
        }
        
        for(int i = 9; i >= 0; i--) {
            if(xrr[i] > 0 && yrr[i] > 0) {
                if(answer.length() == 0 && i == 0) { // "00"의 경우에는 "0"으로 출력되어야 함
                    answer.append(i);
                    break;
                }
                
                answer.append(String.valueOf(i).repeat(Math.min(xrr[i], yrr[i])));
                
            }
        }
        
        if(answer.length() == 0) {
            return "-1";
        }
        
        return answer.toString();
    }
}
