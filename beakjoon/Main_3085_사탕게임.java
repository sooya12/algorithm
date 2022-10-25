import java.io.*;

public class Main_3085_사탕게임 {

    static int N;
    static char[][] map;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new char[N][N];

        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        loop: for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (max == N) {
                    break loop;
                }

                if (i + 1 < N && map[i][j] != map[i + 1][j]) {
                    char tmp = map[i][j];
                    map[i][j] = map[i + 1][j];
                    map[i + 1][j] = tmp;

                    for (int x = 0; x < N - 1; x++) {
                        for (int y = 0; y < N - 1; y++) {
                            move(0, x, y, 1);
                            move(1, x, y, 1);
                        }
                    }

                    map[i + 1][j] = map[i][j];
                    map[i][j] = tmp;
                }

                if (j + 1 < N && map[i][j] != map[i][j + 1]) {
                    char tmp = map[i][j];
                    map[i][j] = map[i][j + 1];
                    map[i][j + 1] = tmp;

                    for (int x = 0; x < N; x++) {
                        for (int y = 0; y < N; y++) {
                            move(0, x, y, 1);
                            move(1, x, y, 1);
                        }
                    }

                    map[i][j + 1] = map[i][j];
                    map[i][j] = tmp;
                }
            }
        }

        System.out.println(max);
    }

    public static void move(int dir, int r, int c, int cnt) {
        max = Math.max(max, cnt);

        if (dir == 0) { // row
            if (r + 1 < N && map[r][c] == map[r + 1][c]) {
                move(dir, r + 1, c, cnt + 1);
            }
        } else { // col
            if (c + 1 < N && map[r][c] == map[r][c + 1]) {
                move(dir, r, c + 1, cnt + 1);
            }
        }
    }
}
