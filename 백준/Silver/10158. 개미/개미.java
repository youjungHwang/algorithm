import java.io.*;
import java.util.*;

public class Main {
    static class FastReader {
        private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        private StringTokenizer st;

        String nextString() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(nextString());
        }

        long nextLong() {
            return Long.parseLong(nextString());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return str;
        }
    }

    private static int w;
    private static int h;
    private static int p;
    private static int q;
    private static int t;

    static void input() throws IOException {
        FastReader scan = new FastReader();

        String[] map = scan.nextLine().split(" ");
        String[] curr = scan.nextLine().split(" ");

        w = Integer.parseInt(map[0]);
        h = Integer.parseInt(map[1]);

        p = Integer.parseInt(curr[0]);
        q = Integer.parseInt(curr[1]);

        t = scan.nextInt();
    }

    public static void main(String[] args) throws IOException {
        input();

        // 초기 deltaX, deltaY
        int deltaX = 1;
        int deltaY = 1;

        // [시간초과 이슈] t의 범위가 2억, 시간 제한이 0.15초
        // t의 범위를 줄일 수 있는 '주기'를 찾자
        // deltaX, deltaY 주기는 각각 2w, 2h -> deltaX, deltaY를 따로 찾기

        // [ x 이동 ]
        int tX = t % (2*w);

        for(int i=0; i<tX; i++) {
            if(p == w) {
                deltaX = -1;
            }else if(p == 0) {
                deltaX = 1;
            }

            p += deltaX;
        }

        // [ y 이동 ]
        int tY = t % (2*h);

        for(int i=0; i<tY; i++) {
            if(q == h) {
                deltaY = -1;
            }else if(q == 0) {
                deltaY = 1;
            }

            q += deltaY;
        }

        System.out.print(p +" "+ q);
    }
}
