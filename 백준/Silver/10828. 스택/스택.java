import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        // 스택
        Deque<Integer> stack = new ArrayDeque<>();

        int n = scan.nextInt();
        for(int i=0; i<n; i++) {
            String[] info = scan.nextLine().split(" ");
            String command = info[0];

            if(command.equals("push")) {
                stack.addFirst(Integer.parseInt(info[1]));
            }

            else if(command.equals("pop")) {
                if(stack.isEmpty()){
                    System.out.println(-1);
                }else {
                    System.out.println(stack.removeFirst());
                }
            }

            else if(command.equals("size")) {
                System.out.println(stack.size());
            }

            else if(command.equals("empty")) {
                if(stack.isEmpty()){
                    System.out.println(1);
                }else {
                    System.out.println(0);
                }
            }

            else if(command.equals("top")) {
                if(stack.isEmpty()){
                    System.out.println(-1);
                }else {
                    System.out.println(stack.peek());
                }
            }
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
