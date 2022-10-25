import java.io.*;

public class Main_1748_수이어쓰기1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long length = 0;
        int N = Integer.parseInt(br.readLine());
        int idx = 1;

        while(true) {
            if(N < Math.pow(10, idx)) {
                break;
            }

            length += 9 * Math.pow(10, idx - 1) * idx;
            idx++;
        }

        length += (N - Math.pow(10, idx - 1) + 1) * idx;

        System.out.println(length);
    }
}
