import java.util.*;

class Solution {
    
    static int answer;
    
    public int solution(int[] nums) {
        answer = 0;

        perm(nums, new boolean[nums.length], 0, 0, 0);
        
        return answer;
    }
    
    private void perm(int[] nums, boolean[] use, int idx, int sum, int cnt) {
        if(idx >= nums.length) {
            return;
        }
        
        if(cnt == 3) {
            for(int i = 2; i < sum; i++) {
                if(sum % i == 0) {
                    return;
                }
            }
            
            answer++;
            return;
        }
                        
        for(int i = idx; i < nums.length; i++) {
            if(!use[i]) {
                use[i] = true;
                perm(nums, use, i, sum + nums[i], cnt + 1);
                use[i] = false;
            }
        }
    }
}
