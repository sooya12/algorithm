import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        List<String> list = new ArrayList<>();
        
        for (int i = 0; i < words.length; i++) {
            if(i == 0) {
                list.add(words[i]);
                continue;
            }
            
            if(!words[i - 1].substring(words[i - 1].length() - 1).equals(words[i].substring(0, 1))
                || list.contains(words[i])) {
                answer[0] = (i + 1) % n > 0 ? (i + 1) % n : n;
                answer[1] = (i + 1) % n > 0 ? (i + 1) / n + 1 : (i + 1) / n;
                break;
            }
            
            list.add(words[i]);
        }
        

        return answer;
    }
}
