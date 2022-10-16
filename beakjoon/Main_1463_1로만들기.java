import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1463_1로만들기 {

    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        dp = new int[N + 1];

        for(int i = 2; i < N + 1; i++) {
            dp[i] = dp[i - 1] + 1;

            if(i % 2 == 0) {
                dp[i] = Math.min(dp[i], 1 + dp[i / 2]);
            }

            if(i % 3 == 0) {
                dp[i] = Math.min(dp[i], 1 + dp[i / 3]);
            }
        }

        System.out.println(dp[N]);
    }
}
