class Solution {
    public int solution(int left, int right) {
        int answer = 0;
        
        for(int i = left; i <= right; i++) {
            int cnt = 0; // 약수의 개수
            
            for(int j = 1; j <= i; j++) {
                if(i % j == 0) {
                    cnt++;
                }
            }
            
            answer += (cnt % 2 == 0) ? i : i * (-1); // 약수의 개수가 짝수면 더하고, 홀수면 뺌
        }
        
        return answer;
    }
}
