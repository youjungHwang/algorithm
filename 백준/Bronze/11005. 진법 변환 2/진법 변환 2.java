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

    private static long n;
    private static int b;

    static void input() throws IOException {
        FastReader scan = new FastReader();

        n = scan.nextLong();
        b = scan.nextInt();
    }

    public static void main(String[] args) throws IOException {
        input();

        // n -> b 진법으로 바꿀 때 가장 큰 자리 수의 지수 찾기
        int baseCase = 1;
        int k = 0;

        while((long) baseCase * b <= n) {
            baseCase *= b;
            k++;
        }

        // b^k와 곱해지는 숫자 찾기
        StringBuilder sb = new StringBuilder();

        while(baseCase > 0) {
            int num  = (int) (n / baseCase);

            // 갱신
            n = n - ((long)num * baseCase);
            baseCase /= b;

            if(num < 10) {
                sb.append(num);
            }else {
                sb.append((char) ('A' + (num - 10)));
            }
        }

        System.out.print(sb);
    }
}
