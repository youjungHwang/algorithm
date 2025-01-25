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

    static void input() throws IOException {
        FastReader scan = new FastReader();

    }

    public static void main(String[] args) throws IOException {
        input();

    }
}
