import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> q = new LinkedList<>();
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < progresses.length; i++) {
            int remain = 100 - progresses[i];

            q.offer(remain / speeds[i] + (remain % speeds[i] > 0 ? 1 : 0));
        }

        int cnt = 1;
        int pre = q.poll();

        while(!q.isEmpty()) {
            if(q.peek() <= pre) {
                cnt++;
                q.poll();
            } else {
                list.add(cnt);
                cnt = 1;
                pre = q.poll();
            }
        }

        list.add(cnt);

        int[] answer = list.stream().mapToInt(i -> i).toArray();
        
        return answer;
    }
}
