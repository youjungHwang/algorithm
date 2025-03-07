import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    static String[] infoBook;
    static String[] haveToCheckBook;
    static int result;

    public static void main(String[] args) {
        // 이분탐색
        String[] info = scan.nextLine().split(" ");
        int n = Integer.parseInt(info[0]);
        int m = Integer.parseInt(info[1]);

        // 초기화
        infoBook = new String[n];
        haveToCheckBook = new String[m];

        for(int i=0; i<n; i++) {
            infoBook[i] = scan.nextLine();
        }
        // 정렬
        Arrays.sort(infoBook);


        for(int i=0; i<m; i++) {
            haveToCheckBook[i] = scan.nextLine();
        }

        for(String sen : haveToCheckBook){
            if(isExist(sen)) {
                result++;
            }
        }
        out.print(result);

        // 자원 해제
        scan.close();
        out.close();
    }

    private static boolean isExist(String target) {
        int l = 0;
        int r = infoBook.length - 1;

        while(l <= r) {
            int m = (l + r) / 2;
            // 사전순 비교
            int compare = infoBook[m].compareTo(target);
            // 음수, 지금 위치가 target 보다 앞에 있다
            if(compare < 0) {
                l = m + 1;
            }else if(compare > 0) {
                // 양수, 지금 위치가 target 보다 뒤에 있다
                r = m - 1;
            }else {
                return true;
            }
        }

        return false;
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


