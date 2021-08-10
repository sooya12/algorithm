import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        int tmp;
        
        for(int i = 0; i < numbers.length; i++) {
            for(int j = i + 1; j < numbers.length; j++) {
                tmp = numbers[i] + numbers[j];        
                
                if(!list.contains(tmp)) {
                    list.add(tmp);
                }
            }
        }
        
        Collections.sort(list);
        
        return list.stream().mapToInt(i -> i).toArray();
    }
}
