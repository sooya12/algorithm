import java.util.*;

class Solution {
    public int[] solution(String s) {
        // 원소 길이 저장
        int[] nums = new int[1000001];
        Arrays.fill(nums, 100001);
        // 원소 저장
        ArrayList<Integer> list = new ArrayList<>();

        String[] arr = s.replaceAll("\\{", "").replaceAll("}}", "").split("},");

        for(String a : arr) {
            String[] tmp = a.split(",");

            for(String t : tmp) {
                int n = Integer.valueOf(t);
                // 짧은 튜플에 포함된 원소일 경우, 앞에 위치
                nums[n] = Math.min(nums[n], tmp.length);

                if(!list.contains(n)) {
                    list.add(n);
                }
            }
        }
        // 튜플 길이로 원소 재정렬
        PriorityQueue<Num> pq = new PriorityQueue<>(new Comparator<>(){
            public int compare(Num n1, Num n2) {
                return n1.size - n2.size;
            }
        });

        for(int l : list) {
            pq.add(new Num(l, nums[l]));
        }

        int[] answer = new int[pq.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = pq.poll().num;
        }
        
        return answer;
    }
  
    // 원소 정보
    public class Num {
        int num;
        int size;

        public Num(int num, int size) {
            this.num = num;
            this.size = size;
        }
    }
}
