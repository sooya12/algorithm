import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main_3052_나머지 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> list = new ArrayList<>();

        int input;

        for (int i = 0; i < 10; i++) {
            input = Integer.parseInt(br.readLine());
            input %= 42;

            if(!list.contains(input)) {
                list.add(input);
            }
        }

        System.out.println(list.size());
    }
}
