import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        String[] info = scan.nextLine().split(" ");
        int K = Integer.parseInt(info[0]);
        int L = Integer.parseInt(info[1]);

        // LinkedHashSet 사용 (삽입 순서 유지)
        Set<String> waitRoom = new LinkedHashSet<>();
        for(int i=0; i<L; i++) {
            String identityNumber = scan.nextString();

            waitRoom.remove(identityNumber);
            waitRoom.add(identityNumber);
        }

        // K명 출력
        int count = 0;
        for(String elem : waitRoom) {
            if(count >= K) break;
            count ++;
            out.println(elem);
        }

        // 자원 해제
        scan.close();
        out.close();
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




