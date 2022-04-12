import java.util.*;
import java.util.regex.Pattern;

class Solution {
    public int solution(String str1, String str2) {
        List<String> list1 = makeList(str1);
        List<String> list2 = makeList(str2);

        return list1.size() > list2.size() ? getRetainAdd(list1, list2) : getRetainAdd(list2, list1);
    }
    
    /** 다중집합 생성 */
    private List<String> makeList(String str) {
        List<String> list = new ArrayList<>();
        String tmp;

        for (int i = 0; i < str.length() - 1; i++) {
            if(i + 2 <= str.length()) {
                tmp = str.substring(i, i + 2);
            } else {
                tmp = str.substring(i);
            }

            if(Pattern.matches("^[A-Za-z]*$", tmp)) {
                list.add(tmp.toLowerCase());
            }
        }

        return list;
    }

    /** 교집합 및 차집합 크기 계산 */
    private int getRetainAdd(List<String> list1, List<String> list2) {
        int retain = 0, add = 0;

        for (int i = 0; i < list1.size(); i++) {
            if(list2.contains(list1.get(i))) {
                retain++;
                add++;
                list2.remove(list1.get(i));
            } else {
                add++;
            }
        }

        add += list2.size();
        
        // 공집합끼리는 1
        if(retain == 0 && add == 0) {
            return 65536;
        } else {
            return (int)(65536 * ((double)retain / (double) add));
        }
    }
}
