import java.util.*;

class Solution {
    
    long answer = -1; // 최댓값
    ArrayList<String> list = new ArrayList<>(); // 수식
    ArrayList<String> sign = new ArrayList<>(); // 연산기호
    
    public long solution(String expression) {
        String[] exps = expression.replaceAll("\\*", ",*,")
                .replaceAll("\\+", ",+,")
                .replaceAll("-", ",-,")
                .split(",");

        Arrays.stream(exps).forEach(e -> {
            list.add(e);

            if(("*".equals(e) || "+".equals(e) || "-".equals(e)) && !sign.contains(e)) {
                sign.add(e);
            }
        });
        
        // 최댓값 완탐
        cal(list, new boolean[sign.size()]);
        
        return answer;
    }
    
    private void cal(ArrayList<String> list, boolean[] flag) {
        // 모든 연산기호를 사용한 경우
        if(check(flag)) {
            long result = Math.abs(Long.valueOf(list.get(0)));
            if(answer < result) {
                answer = result;
            }

            return;
        }

        for (int i = 0; i < flag.length; i++) {
            if(!flag[i]) {
                flag[i] = true;
                ArrayList<String> tmp = (ArrayList<String>) list.clone();
                long val = 0;

                while(tmp.contains(sign.get(i))) {
                    int idx = tmp.indexOf(sign.get(i));

                    switch (sign.get(i)) {
                        case "*" :
                           val = Long.valueOf(tmp.get(idx - 1)) * Long.valueOf(tmp.get(idx + 1));
                           break;
                        case "+" :
                            val = Long.valueOf(tmp.get(idx - 1)) + Long.valueOf(tmp.get(idx + 1));
                            break;
                        case "-" :
                            val = Long.valueOf(tmp.get(idx - 1)) - Long.valueOf(tmp.get(idx + 1));
                            break;
                    }

                    tmp.set(idx, String.valueOf(val));
                    tmp.remove(idx + 1);
                    tmp.remove(idx - 1);
                }

                cal(tmp, flag);
                flag[i] = false;
            }
        }
    }

    // 수식 내 모든 연산기호 사용 여부 판단
    private boolean check(boolean[] flag) {
        for(boolean f : flag) {
            if(!f) {
                return false;
            }
        }

        return true;
    }
    
}
