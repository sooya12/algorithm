import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_18352_특정거리의도시찾기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        int A, B;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            A = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());

            if(!map.containsKey(A)) {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(B);
                map.put(A, list);
            } else {
                map.get(A).add(B);
            }
        }

        int[] arr = new int[N];
        Arrays.fill(arr, Integer.MAX_VALUE);

        Queue<Point> q = new LinkedList<>();
        ArrayList<Integer> list = map.get(X);

        for (int i = 0; i < list.size(); i++) {
            boolean[] check = new boolean[N];
            check[X - 1] = true;
            check[list.get(i) - 1] = true;

            q.add(new Point(X, list.get(i), 1, check));
            arr[list.get(i) - 1] = 1;
        }

        while(!q.isEmpty()) {
            Point p = q.poll();

            if(!map.containsKey(p.e)) {
                if(arr[p.e - 1] == Integer.MAX_VALUE) arr[p.e - 1] = 1;
                continue;
            }

            ArrayList<Integer> target = map.get(p.e);

            for (int i = 0; i < target.size(); i++) {
                int idx = target.get(i);

                if(idx != p.s && !p.check[idx - 1] && arr[idx - 1] > p.cnt + 1) {
                    p.check[idx - 1] = true;
                    q.add(new Point(p.e, idx, p.cnt + 1, p.check));
                    arr[idx - 1] = Math.min(arr[idx - 1], p.cnt + 1);
                    p.check[idx - 1] = false;
                }
            }
        }

        boolean flag = false;

        for (int i = 0; i < N; i++) {
            if(arr[i] == K) {
                System.out.println(i + 1);
                flag = true;
            }
        }

        if(!flag) System.out.println(-1);
    }

    static class Point {
        int s;
        int e;
        int cnt;
        boolean[] check;

        public Point(int s, int e, int cnt, boolean[] check) {
            this.s = s;
            this.e = e;
            this.cnt = cnt;
            this.check = check;
        }
    }
}
