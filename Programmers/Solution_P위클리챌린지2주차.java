class Solution {
    public String solution(int[][] scores) {
        StringBuilder answer = new StringBuilder();
        double sum; // 점수의 총합
        int mine; // 자기 자신을 평가한 점수
        int max; // 최댓값
        int min; // 최솟값
        int cnt; // 자기 자신을 평가한 점수와 같은 점수의 개수
        
        for(int i = 0; i < scores.length; i++) {
            mine = scores[i][i]; 
            sum = mine;
            max = mine;
            min = mine; 
            cnt = 0;
            
            for(int j = 0; j < scores.length; j++) {
                if(j == i) {
                    continue;
                }
                
                if(scores[j][i] == mine) {
                    cnt++;
                }
                
                sum += scores[j][i];
                max = Math.max(max, scores[j][i]);
                min = Math.min(min, scores[j][i]);
            }
            
            if(cnt == 0 && (max == mine || min == mine)) {
                sum -= mine;
                sum /= (double)(scores.length - 1);
            } else {
                sum /= (double)(scores.length);
            }
            
            if(sum >= 90) { 
                answer.append("A");
            } else if(sum >= 80) {
                answer.append("B");
            } else if(sum >= 70) {
                answer.append("C");
            } else if(sum >= 50) {
                answer.append("D");
            } else {
                answer.append("F");
            }
        }
        
        return answer.toString();
    }
}
