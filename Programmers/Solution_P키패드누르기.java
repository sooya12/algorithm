class Solution {
    
    int left = 10; // *
    int right = 12; // #
    
    public String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();
               
        for(int i : numbers) {
            if(i == 0) {
                i = 11;
            }
            
            if(i == 1 || i == 4 || i == 7) {
                answer.append("L");
                left = i;
                continue;
            } else if(i == 3 || i == 6 || i == 9) {
                answer.append("R");
                right = i;
                continue;
            } else {
                answer.append(move(i, hand));
            }
        }
        
        return answer.toString();
    }
    
    String move(int input, String hand) {
        int ltmp = left;
        int rtmp = right;
        String result;
        int lcnt = 0; // 왼손가락 이동 횟수
        int rcnt = 0; // 오른손가락 이동 횟수
        
        // 왼손가락 이동
        if(left == 1 || left == 4 || left == 7 || left == 10) {
            lcnt++;
            left++;
        }
        
        while(left != input) {
            left = left > input ? left - 3 : left + 3;
            lcnt++;
        }
        
        // 오른손가락 이동
        if(right == 3 || right == 6 || right == 9 || right == 12) {
            rcnt++;
            right--;
        }
        
        while(right != input) {
            right = right > input ? right - 3 : right + 3;
            rcnt++;
        }
        
        // 이동 횟수 비교
        if(lcnt == rcnt) { // 같은 경우 hand에 따라 결정
            if(hand.equals("left")) {
                result = "L";
            } else {
                result = "R";
            }
        } else if(lcnt > rcnt) {
            result = "R";
        } else {
            result = "L";
        }
        
        if(result.equals("L")) {
            right = rtmp;
        } else {
            left = ltmp;
        }
        
        return result;
    }
}
