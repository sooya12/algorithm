import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_4375_1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            String str = br.readLine();

            if(str == null) { // 입력은 여러 개의 테스트케이스로 이루어져 있다. 입력 값이 없는 경우 종료 처리
                break;
            }

            int n = Integer.parseInt(str);
            int val = 0;
            int idx = 0;

            while (true) {
                idx++;
                val = (val * 10) + 1;
                val %= n;

                if(val == 0) {
                    break;
                }
            }

            System.out.println(idx);
        }
    }
}
