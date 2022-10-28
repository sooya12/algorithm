import java.io.*;
import java.util.*;

public class Main_9742_순열 {

    static char[] arr; // 입력 문자열
    static int totCnt; // 순열 총개수
    static int idx; // 찾아야 하는 위치
    static boolean[] check; // 순열 사용 여부
    static String result; // 찾은 순열 문자열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String str;

        while((str = br.readLine()) != null) {
            st = new StringTokenizer(str, " ");

            String input = st.nextToken();
            idx = Integer.parseInt(st.nextToken());

            int tmp = 1;
            for(int i = 1; i <= input.length(); i++) {
                tmp *= i;
            }

            if(tmp < idx) { // 해당하는 순열이 없는 경우
                System.out.println(input + " " + idx + " = No permutation");
                continue;
            }

            arr = input.toCharArray();
            totCnt = 0;
            check = new boolean[arr.length];
            result = "";

            perm(new char[arr.length], 0);

            System.out.println(input + " " + idx + " = " + result);
        }

    }

    public static void perm(char[] tmp, int num) {
        if(num == arr.length) {
            if(++totCnt == idx) { // 찾아야 하는 위치의 순열인 경우
                for(char t : tmp) {
                    result += t;
                }
            }
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if(!check[i]) {
                check[i] = true;
                tmp[num] = arr[i];
                perm(tmp, num + 1);
                check[i] = false;
            }
        }
    }
}
