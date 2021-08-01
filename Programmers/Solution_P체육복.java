import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] cnt = new int[n];
        
        Arrays.fill(cnt, 1);
        
        // 여벌의 체육복이 있는 경우
        for(int i = 0; i < reserve.length; i++) {
            cnt[reserve[i] - 1]++;
        }
        
        // 체육복을 도난당한 경우
        for(int i = 0; i < lost.length; i++) {
            cnt[lost[i] - 1]--;
        }
        
        // 앞,뒤로 체육복 빌려주기
        for(int i = 0; i < cnt.length; i++) {
            if(cnt[i] == 2) {
                if(i > 0 && cnt[i - 1] == 0) {
                    cnt[i - 1] = 1;
                    cnt[i] = 1;
                    continue;
                } else if(i < n - 1 && cnt[i + 1] == 0) {
                    cnt[i + 1] = 1;
                    cnt[i] = 1;
                    continue;
                }
            }
        }
        
        for(int c : cnt) {
            if(c > 0) {
                answer++;
            }
        }
        
        return answer;
    }
}
