class Solution { 
    
    int answer;
    
    public int solution(int[] number) {
        answer = 0;
        func(number, new boolean[number.length], 0, 0, 0);
        
        return answer;
    }
    
    public void func(int[] number, boolean[] check, int sum, int idx, int cnt) {
        if(cnt == 3) {
            if(sum == 0) {
                answer++;
            }
            
            return;
        }
        
        for(int i = idx; i < number.length; i++) {
            if(!check[i]) {
                check[i] = true;
                func(number, check, sum + number[i], i + 1, cnt + 1);
                check[i] = false;
            }
        }
    }
}
