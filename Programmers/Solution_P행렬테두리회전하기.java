class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int x1, y1, x2, y2, min;
        int[] answer = new int[queries.length];

        int[][] map = new int[rows][columns];
      
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                map[i][j] = i * columns + (j + 1);
            }
        }

        // 행렬 테두리 회전
        for (int k = 0; k < queries.length; k++) {
            // 회전할 테두리 정보
            int[] q = queries[k];
            // 회전한 결과 저장할 행렬
            int[][] clone = new int[rows][columns];

            for (int i = 0; i < map.length; i++) {
                clone[i] = map[i].clone();
            }

            x1 = q[0] - 1;
            y1 = q[1] - 1;
            x2 = q[2] - 1;
            y2 = q[3] - 1;
            min = Integer.MAX_VALUE;

            // 좌 -> 우
            for(int i = y1; i < y2; i++) {
                clone[x1][i + 1] = map[x1][i];

                if(min > map[x1][i]) {
                    min = map[x1][i];
                }
            }

            // 상 -> 하
            for(int i = x1; i < x2; i++) {
                clone[i + 1][y2] = map[i][y2];

                if(min > map[i][y2]) {
                    min = map[i][y2];
                }
            }

            // 우 -> 좌
            for(int i = y2; i > y1; i--) {
                clone[x2][i - 1] = map[x2][i];

                if(min > map[x2][i]) {
                    min = map[x2][i];
                }
            }

            // 하 -> 상
            for(int i = x2; i > x1; i--) {
                clone[i - 1][y1] = map[i][y1];

                if(min > map[i][y1]) {
                    min = map[i][y1];
                }
            }

            answer[k] = min;
            map = clone;
        }
        
        return answer;
    }
}
