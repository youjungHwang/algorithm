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

    private static int[] arr;

    static void input() throws IOException {
        FastReader scan = new FastReader();

        int t = scan.nextInt();

        calculTn();

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<t; i++) {
            int k = scan.nextInt();

            int c = checkCase(k);
            sb.append(c +"\n");
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        input();
    }

    private static int checkCase(int k) {
        // 3중 for문
        for(int i=1; i<1001; i++) {
            for(int j=1; j<1001; j++) {
                for(int m=1; m<1001; m++) {
                    if(arr[i] + arr[j] + arr[m] == k) {
                        return 1;
                    }
                }
            }
        }
        return 0;
    }

    private static void calculTn() {
        // 배열 초기화
        arr = new int[1001];
        arr[0] = 0;

        for(int i=1; i<1001; i++) {
            arr[i] = (i * (i+1)) / 2;
        }
    }
}
