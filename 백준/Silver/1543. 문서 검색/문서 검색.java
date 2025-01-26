import java.io.*;
import java.util.*;

public class Main { // 방법 : indexOf(채택), replace
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

    private static String first;
    private static String second;
    private static int count;

    static void input() throws IOException {
        FastReader scan = new FastReader();
        first = scan.nextLine();
        second = scan.nextLine();
    }

    public static void main(String[] args) throws IOException {
        input();

        // 문서의 어디서부터 단어를 찾을지 갱신
        int startIndex = 0;
        for(int i=0; i<first.length(); i++) {
            int firstIndex = first.indexOf(second, startIndex);

            if(firstIndex < 0) {
                break;
            }

            count++;

            // 갱신
            startIndex = firstIndex + second.length();
        }

        System.out.print(count);
    }
}
