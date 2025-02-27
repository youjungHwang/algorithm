import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    static List<Integer> arr;
    static int n;
    public static void main(String[] args) {
        n = scan.nextInt();
        arr = new ArrayList<>();

        String[] info = scan.nextLine().split(" ");
        for(int i=0; i<n; i++) {
           arr.add(Integer.parseInt(info[i]));
        }

        // 정렬
        Collections.sort(arr);

        findMinNumber();

        // 자원 해제
        scan.close();
        out.close();
    }

    // 누적합
    private static void findMinNumber() {
        int sum = 0;

        for(int i=0; i<n; i++) {
            // 새로운 추가 추가되어서 이전값(sum) + 1 을 만들 수 없으면, sum + 1을 리턴
            if(sum + 1 < arr.get(i)) {
                break;
            }
            sum += arr.get(i);
        }

        out.println(sum+1);
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


