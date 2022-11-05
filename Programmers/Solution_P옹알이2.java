class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] arr = {"aya", "ye", "woo", "ma"};

        x : for(String b : babbling) {
            for(String a : arr) {
                if(b.contains(a.repeat(2))) {
                    continue x;
                }
                
                b = b.replace(a, " ");
            }
            
            if(b.trim().length() == 0) {
                answer++;
            }
        }
        
        return answer;
    }
}
