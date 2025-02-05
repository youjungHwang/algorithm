import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int t = scan.nextInt();

        for(int i=0; i<t; i++) {
            String[] info = scan.nextLine().split(" ");
            int h = Integer.parseInt(info[0]);
            int w = Integer.parseInt(info[1]);
            int n = Integer.parseInt(info[2]);

            String number = findRoomNumber(h,w,n);
            System.out.println(number);
        }

        // 자원 해제
        scan.close();
        out.close();
    }

    private static String findRoomNumber(int h, int w, int n) {
        // 층
        int floor = (n-1) % h + 1;
        // 호수
        int no = (n-1) / h + 1;

        return String.format("%d%02d", floor, no);
    }

    static class FastReader {
        private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        private StringTokenizer tokenizer;

        String nextString() {
            while (tokenizer == null || !tokenizer.hasMoreElements()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return tokenizer.nextToken();
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
                str = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

        void close() {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
