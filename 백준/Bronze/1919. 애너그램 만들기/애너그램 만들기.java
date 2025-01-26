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

        // 문자 하나씩 비교하기 위해 문자열 -> 문자 배열
        char[] firstChar = first.toCharArray();
        char[] secondChar = second.toCharArray();

        for(int i=0; i<firstChar.length; i++) {
            for(int j=0; j<secondChar.length; j++) {
                if(firstChar[i] == secondChar[j]) {
                    // 치환
                    secondChar[j] = '.';
                    firstChar[i] = '.';
                }
            }
        }

        // '.'을 제외하고 count하여 반환
        for(int i=0; i<firstChar.length; i++) {
            if(!(firstChar[i] == '.')) {
                count++;
            }
        }

        for(int j=0; j<secondChar.length; j++) {
            if(!(secondChar[j] == '.')) {
                count++;
            }
        }

        System.out.print(count);
    }
}
