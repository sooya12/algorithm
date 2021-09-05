import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        for(int i = 0; i < arr.length; i++) {
            if(i == 0) {
                list.add(arr[i]);
            } else {
                if(arr[i] != list.get(list.size() - 1)) {
                    list.add(arr[i]);
                }
            }
        }
        
        return list.stream().mapToInt(i -> i).toArray();
    }
}
