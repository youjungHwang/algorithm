import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    static Queue<Integer> q = new ArrayDeque<>();
    static int n;
    public static void main(String[] args) {
        n = scan.nextInt();

        // 큐에 입력 원소 넣기
        for(int i=0; i<n; i++) {
            q.add(scan.nextInt());
        }

        checkInput();

        // 자원 해제
        scan.close();
        out.close();
    }

    // 큐에서 원하는 값이 나올 때까지 스택에 푸시
    private static void checkInput() {
        Deque<Integer> s = new ArrayDeque<>();

        StringBuilder sb = new StringBuilder();

        int elem = 1;
        while(elem <= n) {
            s.push(elem++);
            sb.append("+").append("\n");

            while(!s.isEmpty() && !q.isEmpty() && s.peek().equals(q.peek())) {
                q.poll();
                s.pop();
                sb.append("-").append("\n");
            }
        }

        if(!s.isEmpty()){
            out.print("NO");
        }else {
            out.print(sb);
        }
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


