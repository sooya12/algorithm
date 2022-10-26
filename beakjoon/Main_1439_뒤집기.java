import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1439_뒤집기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();
        char[] arr = S.toCharArray();

        int cnt0 = 0; // 연속된 0의 집합 개수
        int cnt1 = 0; // 연속된 1의 집합 개수

        for (int i = 0; i < arr.length; i++) {
            if(i == 0) {
                if(arr[i] == '0') {
                    cnt0++;
                } else {
                    cnt1++;
                }
            } else {
                if(arr[i] == arr[i - 1]) {
                    continue;
                } else {
                    if(arr[i] == '0') {
                        cnt0++;
                    } else {
                        cnt1++;
                    }
                }
            }
        }

        System.out.println(Math.min(cnt0, cnt1)); // 연속된 집합 개수가 작은 수
    }
}
