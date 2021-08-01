import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int zeros = 0; // 낙서가 되어서 알아볼 수 없는 번호 개수
        int contains = 0; // 당첨 번호와 일치하는 번호 개수

        List<Integer> list = new ArrayList<Integer>();
        for(int wn : win_nums) {
            list.add(wn);
        }

        for(int l : lottos) {
            if(l == 0) {
                zeros++;
            } else if(list.contains(l)) {
                contains++;
            }
        }

        answer[0] = (7 - contains - zeros) >= 6 ? 6 : (7 - contains - zeros); // 최고 순위
        answer[1] = (7 - contains) >= 6 ? 6 : (7 - contains); // 최저 순위

        return answer;
    }
}