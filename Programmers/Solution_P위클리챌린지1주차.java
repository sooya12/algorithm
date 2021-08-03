class Solution {
    public long solution(int price, int money, int count) {
        int total = 0;
        
        while(count > 0) {
            total += count;
            count--;
        }
        
        long answer = (long)price * (long)total - (long)money;
        
        return answer <= 0 ? 0 : answer;
    }
}
