import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_18406_럭키스트레이트 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String N = br.readLine();
        int length = N.length() / 2;
        char[] arr = N.toCharArray();

        int pre = 0;
        int post = 0;

        for (int i = 0; i < length; i++) {
            pre += arr[i] - '0';
        }

        for(int i = length; i < N.length(); i++) {
            post += arr[i] - '0';
        }

        System.out.println(pre == post ? "LUCKY" : "READY");
    }
}
