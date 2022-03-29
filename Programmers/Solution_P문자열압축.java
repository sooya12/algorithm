class Solution {
    public int solution(String s) {
        int answer = Integer.MAX_VALUE;
        String tmp, pre;
        int cnt, length;

        for(int i = 1; i <= s.length(); i++) {
            pre = "";
            cnt = 1;
            length = 0;

            for(int j = 0; j < s.length(); j += i) {
                // 길이 합이 정답보다 길면 종료
                if (length >= answer) {
                    break;
                }

                // 첫번째는 이전 문자열에 저장
                if (j == 0) {
                    length += i;
                    pre = s.substring(j, j + i);
                } else { // 첫번째가 아닌 경우
                    // 종료 인덱스가 문자열의 총 길이를 넘지 않는 경우
                    if (j + i <= s.length()) {
                        tmp = s.substring(j, j + i);

                        // 이전 문자열과 다르다면, 길이 합에 횟수와 현재 문자열 길이 더하고 이전 문자열을 현재 문자열로 치환
                        if (!pre.equals(tmp)) {
                            length += (cnt > 1 ? String.valueOf(cnt).length() : 0) + i;
                            pre = tmp;
                            cnt = 1;
                        } else { // 이전 문자열과 같다면, 횟수++
                            cnt++;
                        }

                        if(j + i == s.length()) {
                            length += (cnt > 1 ? String.valueOf(cnt).length() : 0);
                        }
                    } else { // 종료 인덱스가 문자열의 총 길이를 넘는 경우
                        tmp = s.substring(j);
                        length += (cnt > 1 ? String.valueOf(cnt).length() : 0) + tmp.length();
                        break;
                    }
                }
            }

            if(length < answer) {
                answer = length;
            }
        }
        
        return answer;
    }
}
