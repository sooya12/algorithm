import java.util.*;

class Solution {
    public String solution(String[] table, String[] languages, int[] preference) {
        Map<String, Integer> hm = new HashMap<String, Integer>();
        
        for(String t : table) {
            String[] langs = t.split(" ");
            List<String> list = new ArrayList<>(Arrays.asList(langs));
            int sum = 0;
            
            for(int i = 0; i < languages.length; i++) {
                if(list.contains(languages[i])) {
                    sum += (list.size() - list.indexOf(languages[i])) * preference[i];
                }
            }
            
            hm.put(langs[0], sum);
        }
        
        List<Map.Entry<String, Integer>> resultList = new ArrayList<>(hm.entrySet());
        Collections.sort(resultList, new Comparator<Map.Entry<String, Integer>>() {
          public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
              if(o1.getValue() == o2.getValue()) {
                  return o1.getKey().compareTo(o2.getKey());
              } 

              return o2.getValue() - o1.getValue();
          }
        });

        return resultList.get(0).getKey();
    }
}
