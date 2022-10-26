import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_16916_부분문자열 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine(); // 문자열
        String P = br.readLine(); // 패턴

        int[] table = new int[P.length()];
        int result = 0; // 부분문자열 여부 {0: false, 1: true}
        int j = 0;

        for (int i = 1; i < P.length(); i++) {
            while(j > 0 && P.charAt(i) != P.charAt(j)) {
                j = table[j - 1];
            }

            if(P.charAt(i) == P.charAt(j)) {
                table[i] = ++j;
            }
        }

        j = 0;

        for (int i = 0; i < S.length(); i++) {
            while(j > 0 && S.charAt(i) != P.charAt(j)) {
                j = table[j - 1];
            }

            if(S.charAt(i) == P.charAt(j)) {
                if(j == P.length() - 1) {
                    result = 1;
                    break;
                } else {
                    j++;
                }
            }
        }

        System.out.println(result);
    }
}
