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

        int[] a = new int[26];
        int[] b = new int[26];

        // 주어진 문자열을 돌면서 해당 문자의 개수를 카운트한다
        for(int i=0; i<first.length(); i++) {
            a[first.charAt(i) - 'a'] ++;
        }

        for(int i=0; i<second.length(); i++) {
            b[second.charAt(i) - 'a'] ++;
        }

        // 비교하면서 개수가 다르면 count++
        for(int i=0; i<26; i++) {
            if(a[i] > b[i]) {
                count += (a[i] - b[i]);
            }else if(a[i] < b[i]) {
                count += (b[i] - a[i]);
            }
        }

        System.out.print(count);
    }
}
