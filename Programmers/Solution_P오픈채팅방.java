import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        // id와 nickname 저장
        Map<String, String> map = new HashMap<>();
        // 사용자 입출 저장
        List<User> list = new ArrayList<>();

        for(String r : record) {
            String[] arr = r.split(" ");

            if("Leave".equals(arr[0])) {
                list.add(new User(arr[0], arr[1]));
            } else {
                // 처음 입장한 사용자의 경우
                if(!map.containsKey(arr[1])) {
                    map.put(arr[1], arr[2]);
                } else { // 재입장하거나, nickname이 변경된 경우
                    map.replace(arr[1], arr[2]);
                }

                if("Enter".equals(arr[0])) {
                    list.add(new User(arr[0], arr[1]));
                }
            }
        }

        String[] answer = new String[list.size()];

        for (int i = 0; i < list.size(); i++) {
            User u = list.get(i);

            if("Enter".equals(u.inout)) {
                answer[i] = map.get(u.id) + "님이 들어왔습니다.";
            } else {
                answer[i] = map.get(u.id) + "님이 나갔습니다.";
            }
        }
        
        return answer;
    }
    
    private class User {
        String id;
        String inout;

        public User(String inout, String id) {
            this.inout = inout;
            this.id = id;
        }
    }
}
