import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int n = nums.length / 2; // 고를 수 있는 폰켓몬 수

        List<Integer> list = new ArrayList<Integer>();

        for(int num : nums) {
            if(!list.contains(num)) { // 중복 제거
                list.add(num);
            }
        }

        return list.size() >= n ? n : list.size(); // 고를 수 있는 폰켓몬 조합의 최댓값
    }
}