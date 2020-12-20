import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_2304_창고다각형 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] height = new int[10001];
        ArrayList<Integer> list = new ArrayList<>();
        int maxH = 0;
        int maxL = -1;
        int area = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int l = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());

            if(maxH < h) {
                maxH = h;
                maxL = l;
            }

            list.add(l);
            height[l] = h;
        }

        Collections.sort(list);

        int sl = list.get(0);
        int sh = height[sl];
        int el = list.get(list.size() - 1);
        int eh = height[el];
        int l, h;

        for (int i = 1; i < list.size(); i++) {
            l = list.get(i);
            h = height[l];

            if(l == maxL) {
                area += sh * (l - sl);
                break;
            }

            if(h > sh) {
                area += sh * (l - sl);
                sl = l;
                sh = h;
            }
        }

        for (int i = list.size() - 2; i >= 0; i--) {
            l = list.get(i);
            h = height[l];

            if(l == maxL) {
                area += eh * (el - l);
                break;
            }

            if(h > eh) {
                area += eh * (el - l);
                el = l;
                eh = h;
            }
        }

        area += maxH;

        System.out.println(area);
    }
}
