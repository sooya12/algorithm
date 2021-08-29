import java.util.*;

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        
        for(int i = 0; i < arr1.length; i++) {
            String tmp = Integer.toBinaryString(arr1[i] | arr2[i]); // OR 연산
            
            while(tmp.length() != n) {
                tmp = "0" + tmp;
            }
            
            answer[i] = tmp.replace("1", "#").replace("0", " ");
        }
        
        return answer;
    }
}
