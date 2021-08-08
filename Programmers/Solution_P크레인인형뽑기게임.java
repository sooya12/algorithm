import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0; // 터트려져 사라진 인형 개수
        Stack<Integer> stack = new Stack<Integer>(); // 뽑힌 인형을 차례대로 담은 바구니
        
        for(int m : moves) {
            for(int i = 0; i < board.length; i++) {
                int val = board[i][m - 1];
                
                if(val > 0) {
                    if(stack.size() > 0 && stack.peek() == val) { // 인형이 터지는 경우
                        answer += 2;
                        stack.pop();
                    } else { // 인형이 바구니에 담기는 경우
                        stack.push(val);
                    }
                    
                    board[i][m - 1] = 0;
                    break;
                }
            }
        }
        return answer;
    }
}
