import java.util.*;
import java.io.*;

public class Main_11052_카드구매하기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] P = new int[N];
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < P.length; i++) {
            P[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i < P.length; i++) {
            int half = (i + 1) / 2;

            for(int j = 0; j < half; j++) {
                P[i] = Math.max(P[i], P[i - j - 1] + P[j]);
            }
        }

        System.out.println(P[N - 1]);
    }
}
