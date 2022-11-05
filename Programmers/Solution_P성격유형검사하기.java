import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        int[] val = {3, 2, 1, 0, 1, 2, 3};
        char[] typeArr = {'R', 'T', 'C', 'F', 'J', 'M', 'A', 'N'};
        
        Map<Character, Integer> map = new HashMap<>();
        
        for(char t : typeArr) {
            map.put(t, 0);
        }
        
        char type;
        int num;
        
        for(int i = 0; i < survey.length; i++) {
            num = choices[i];
            
            if(num == 4) {
                continue;
            }
            
            if(num < 4) {
                type = survey[i].charAt(0);
            } else {
                type = survey[i].charAt(1);
            }
            
            map.replace(type, map.get(type) + val[num - 1]);
        }
        
        for(int i = 0; i < typeArr.length; i += 2) {
            if(map.get(typeArr[i + 1]) > map.get(typeArr[i])) {
                answer += typeArr[i + 1];
            } else {
                answer += typeArr[i];
            }
        }
        
        return answer;
    }
}
