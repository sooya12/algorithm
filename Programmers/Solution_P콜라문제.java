class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        int tmp;
        
        while(n >= a) {
            tmp = n / a;
            n = n - tmp * a + tmp * b;
            answer += tmp * b;
        }
        
        return answer;
    }
}
