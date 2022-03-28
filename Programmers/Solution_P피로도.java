class Solution {
    
    // 던전 배열
    int[][] d;
    // 최대 탐험 횟수
    int answer = -1;
    
    public int solution(int k, int[][] dungeons) {
        d = dungeons;
        
        adventure(0, new boolean[d.length], k, 0);
        
        return answer;
    }
    
    public void adventure(int cnt, boolean[] flag, int k, int advtCnt) {
        if(advtCnt >= flag.length || !check(flag, k)) {
            if(answer < cnt) {
                answer = cnt;
            }

            return;
        }

        for(int i = 0; i < flag.length; i++) {
            if(!flag[i] && k >= d[i][0]) {
                flag[i] = true;
                adventure(cnt + 1, flag, k - d[i][1], advtCnt + 1);
                flag[i] = false;
            }
        }
    }

    public boolean check(boolean[] flag, int k) {
        boolean result = false;

        for(int i = 0; i < flag.length; i++) {
            if(!flag[i] && k >= d[i][0]) {
                result = true;
                break;
            }
        }

        return result;
    }
}
