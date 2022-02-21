import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1546_평균 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        double[] arr = new double[N];
        double max = - 1;

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            arr[i] = Double.parseDouble(st.nextToken());

            if(max < arr[i]) {
                max = arr[i];
            }
        }

        Arrays.sort(arr);

        double sum = 0;

        for (double val : arr) {
            sum += val/max*100;
        }

        System.out.println(sum/arr.length);
    }
}
