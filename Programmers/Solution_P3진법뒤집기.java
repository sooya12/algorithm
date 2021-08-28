class Solution {
    public int solution(int n) {
        int answer = 0;
        String str = "";
        int idx = 1;
        int tmp = 1;
        
        while(true) {
            if(tmp * 3 > n) {
                break;
            }
            
            tmp *= 3;
            idx++;
        }
        
        for(int i = 0; i < idx; i++) {
            str += n / tmp;
            n -= (n / tmp) * tmp;
            tmp /= 3;
        }
        
        tmp = 1;
        
        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            answer += (int)(ch - '0') * tmp;
            tmp *= 3;
        }
        
        return answer;
    }
}
