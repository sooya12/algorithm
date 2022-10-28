import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main_2407_조합 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int tmp = n - m;

        if(m > tmp) { // (n - m)!과 m! 중 더 큰 값을 n!에서 나누기 위해서
            tmp = m;
            m = n - m;
        }

        BigInteger a = new BigInteger("1"); // n * ... * (n - m + 1)
        BigInteger b = new BigInteger("1"); // m

        for (int i = n; i >= (tmp + 1) ; i--) {
            a = a.multiply(BigInteger.valueOf(i));
        }

        for (int i = 1; i <= m; i++) {
            b = b.multiply(BigInteger.valueOf(i));
        }

        System.out.println(a.divide(b));
    }
}
