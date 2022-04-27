import java.util.*;

class Solution {
    public int solution(int [][]board) {
        // 가장 큰 정사각형의 한 변 길이
        int answer = 0;
        // 해당 위치의 최대 크기
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(board[i][j] != 0) {
                    if(i - 1 >= 0 && j - 1 >= 0) {
                        board[i][j] = Math.min(board[i - 1][j], Math.min(board[i - 1][j - 1], board[i][j - 1])) + 1;
                    }
                }
            }
        }

        // 가장 큰 정사각형의 한 변 길이 찾기
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(board[i][j] > 0 && answer < board[i][j]) {
                    answer = board[i][j];
                }
            }
        }

        // 정사각형의 크기
        return (int)Math.pow(answer, 2);
    }
}
