import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1786_찾기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int cnt = 0;

        String T = br.readLine(); // 문자열
        String P = br.readLine(); // 패턴

        int[] table = new int[P.length()];
        int j = 0;

        for (int i = 1; i < P.length(); i++) {
            while(j > 0 && P.charAt(i) != P.charAt(j)) {
                j = table[j - 1];
            }

            if(P.charAt(i) == P.charAt(j)) {
                table[i] = ++j;
            }
        }

        int idx = 0;

        for (int i = 0; i < T.length(); i++) {
            while(idx > 0 && T.charAt(i) != P.charAt(idx)) {
                idx = table[idx - 1];
            }

            if(T.charAt(i) == P.charAt(idx)) {
                if(idx == P.length() - 1) {
                    cnt++;
                    sb.append(i - idx + 1).append(" ");
                    idx = table[idx];
                } else {
                    idx++;
                }
            }
        }

        System.out.println(cnt);
        System.out.println(sb);
    }
}
