import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_1158_요세푸스문제 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            list.add(i);
        }

        sb.append("<");

        int idx = -1;
        int val;

        while(!list.isEmpty()) {
            idx = (idx + K) % list.size();
            val = list.get(idx);
            sb.append(val).append(",").append(" ");

            list.remove(idx);
            idx--;
        }

        sb.delete(sb.length() - 2, sb.length());
        sb.append(">");

        System.out.println(sb.toString());
    }
}
