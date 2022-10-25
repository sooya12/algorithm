import java.util.*;
import java.io.*;

public class Main_11723_집합 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
      
        String oper;
        int val = 0;

        int M = Integer.parseInt(br.readLine());
        int[] list = new int[21];

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            oper = st.nextToken();

            if(!"all".equals(oper) && !"empty".equals(oper)) {
                val = Integer.parseInt(st.nextToken());
            }

            switch(oper) {
                case "add" :
                    list[val] = 1;
                    break;
                case "remove" :
                    list[val] = 0;
                    break;
                case "check" :
                    if(list[val] > 0) {
                        sb.append("1").append("\n");
                    } else {
                        sb.append("0").append("\n");
                    }
                    break;
                case "toggle" :
                    if(list[val] > 0) {
                        list[val] = 0;
                    } else {
                        list[val] = 1;
                    }
                    break;
                case "all" :
                    Arrays.fill(list, 1);
                    break;
                case "empty" :
                    Arrays.fill(list, 0);
                    break;
            }
        }

        System.out.println(sb);
    }
}
