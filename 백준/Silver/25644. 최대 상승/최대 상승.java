import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    static int n;
    static int[] arr;

    public static void main(String[] args) {
        n = scan.nextInt();

        // 초기화
        arr = new int[n];
        String[] info = scan.nextLine().split(" ");
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(info[i]);
        }

        int minCurr = arr[0];  
        int maxProfit = 0; 

        // O(N)
        for(int i=1; i<n; i++) { 
            maxProfit = Math.max(maxProfit, arr[i] - minCurr);
            minCurr = Math.min(minCurr, arr[i]); 
        }
        out.print(maxProfit);


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


