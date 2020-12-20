import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14719_빗물 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int H = Integer.parseInt(st.nextToken()); // 세로 길이
        int W = Integer.parseInt(st.nextToken()); // 가로 길이

        int[] heights = new int[W];
        int max = 0;
        int maxIdx = 0;

        st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < W; i++) {
            heights[i] = Integer.parseInt(st.nextToken());

            if(max < heights[i]) {
                max = heights[i];
                maxIdx = i;
            }
        }

        int h = heights[0];
        int result = 0;

        for (int i = 1; i < maxIdx; i++) {
            if(heights[i] < h) {
                result += h - heights[i];
            } else {
                h = heights[i];
            }
        }

        h = heights[heights.length - 1];

        for (int i = W - 2; i > maxIdx; i--) {
            if(heights[i] < h) {
                result += h - heights[i];
            } else {
                h = heights[i];
            }
        }

        System.out.println(result);
    }
}
