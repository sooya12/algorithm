import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        // 필요한 구명보트 수
        int answer = 0;
        // 제일 가벼운 사람, 제일 무거운 사람 위치
        int min = 0, max = people.length - 1;

        // 무게순 정렬
        Arrays.sort(people);
        
        while(min <= max) {
            // 최대 2명 제한이므로 두 명만 비교
            if(people[max] + people[min] <= limit) {
                max--;
                min++;
            } else {
                max--;
            }

            answer++;
        }
        
        return answer;
    }
}
