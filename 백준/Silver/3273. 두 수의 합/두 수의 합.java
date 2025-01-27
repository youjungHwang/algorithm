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

    private static int[] arr;
    private static int target;
    private static int count;

    static void input() throws IOException {
        FastReader scan = new FastReader();

        int n = scan.nextInt();

        arr = new int[n];

        String[] info = scan.nextLine().split(" ");
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(info[i]);
        }

        target = scan.nextInt();
    }

    public static void main(String[] args) throws IOException {
        input();

        int count = 0;

        for(int i=0; i<arr.length - 1; i++) {
            for(int j=i+1; j<arr.length; j++) { 
                if(arr[i] + arr[j] == target) {
                    count++;
                    break;
                }
            }
        }

        System.out.print(count);
    }
}
