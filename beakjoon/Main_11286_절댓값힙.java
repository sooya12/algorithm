import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main_11286_절댓값힙 {

    static class MaxComparator implements Comparator {

        @Override
        public int compare(Object o1, Object o2) {
            int v1 = Math.abs((int)o1);
            int v2 = Math.abs((int)o2);

            if(v1 == v2) {
                return (int)o1 - (int)o2;
            } else {
                return v1 - v2;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine()); // 연산의 개수
        int x; // 연산에 대한 정보를 나타내는 정수
        PriorityQueue<Integer> pq = new PriorityQueue<>(new MaxComparator());

        for (int i = 0; i < N; i++) {
            x = Integer.parseInt(br.readLine());

            if(x == 0) {
                if(!pq.isEmpty()) {
                    sb.append(pq.remove() + "\n");
                } else {
                    sb.append(0 + "\n");
                }
            } else {
                pq.add(x);
            }
        }
        System.out.println(sb.toString());
    }
}
