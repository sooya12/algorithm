class Solution {
    public int solution(String dartResult) {
        int answer = 0; // 총 점수
        String val = ""; // 점수 추출
        int realVal = 0; // 점수
        int mulVal = 1; // SDT
        int[] result = new int[3]; // 각 차례의 점수
        int idx = 0; // result 배열 위치
        
        for(int i = 0; i < dartResult.length(); i++) {
            char ch = dartResult.charAt(i);
            
            if(ch - '0' >= 0 && ch - '0' <= 10) { // 점수 추출
                val += ch;
            } else { // 문자 추출
                switch (ch) {
                    case 'S' : 
                        mulVal = 1;
                        break;
                    case 'D' :
                        mulVal = 2;
                        break;
                    case 'T' :
                        mulVal = 3;
                        break;
                }
                
                realVal = Integer.parseInt(val);
                
                if(i < dartResult.length() - 1 && dartResult.charAt(i + 1) == '#') {
                    result[idx++] = (int)Math.pow(realVal, mulVal) * (-1);
                    i++;
                } else {
                    result[idx] = (int)Math.pow(realVal, mulVal);
                    
                    if(i < dartResult.length() - 1 && dartResult.charAt(i + 1) == '*') {
                        result[idx] = (int)Math.pow(realVal, mulVal) * 2;
                        
                        if(idx > 0) { // 이전 차례가 존재하는 경우
                            result[idx - 1] *= 2;
                        }

                        i++;
                    }
                    
                    idx++;
                }
                
                val = "";
            }
        }
        
        for(int r : result) {
            answer += r;
        }
        
        return answer;
    }
}
