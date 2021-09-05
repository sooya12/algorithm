import java.util.*;

class Solution {
    String[] alphabet = {"A", "E", "I", "O", "U"};
    ArrayList<String> list = new ArrayList<String>();
    
    public int solution(String word) {
        comb(0, "");
        
        Collections.sort(list);
        
        return list.indexOf(word);
    }
    
    public void comb(int cnt, String val) {
        if(cnt == 5) {
            if(!list.contains(val)) {
                list.add(val);
            }
            
            return;
        }
        
        for(int i = 0; i < alphabet.length; i++) {
            comb(cnt + 1, val);
            comb(cnt + 1, val + alphabet[i]);
        }
    }
}
