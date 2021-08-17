import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        HashMap<Integer, Double> hm = new HashMap<Integer, Double>();
        Arrays.sort(stages);
        
        for(int i = 1; i < N + 1; i++) {
            double challengers = 0; // 스테이지에 도달한 플레이어
            double loser = 0; // 스테이지에 도달했으나 아직 클리어하지 못한 플레이어
            
            for(int j = 0; j < stages.length; j++) {
                if(stages[j] >= i) {
                    challengers++;
                    
                    if(stages[j] == i) {
                        loser++;
                    }
                } 
            }
            
            if(challengers == 0) { // 스테이지에 도달한 플레이어가 없는 경우
                hm.put(i, 0.0);
                continue;
            }
            
            hm.put(i, loser / challengers); // 스테이지에 도달했으나 아직 클리어하지 못한 플레이어 / 스테이지에 도달한 플레이어
        }
        
        List<Integer> list = new ArrayList<>(hm.keySet());
        Collections.sort(list, (k1, k2) -> hm.get(k2).compareTo(hm.get(k1)));

        return list.stream().mapToInt(i -> i).toArray();
    }
}
