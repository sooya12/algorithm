import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2562_최댓값 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int idx = 0;
        int max = -1;
        int input;

        for (int i = 0; i < 9; i++) {
            input = Integer.parseInt(br.readLine());
            if(max < input) {
                max = input;
                idx = i;
            }
        }

        System.out.println(max);
        System.out.println(idx + 1);

    }
}
