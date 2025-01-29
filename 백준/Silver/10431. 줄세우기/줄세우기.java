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

    static void input() throws IOException {
        FastReader scan = new FastReader();

        int t = scan.nextInt();

        for(int i=1; i<=t; i++) {
            // 배열 만들기
            int[] arr = new int[20];
            String[] info = scan.nextLine().split(" ");

            int count = backStepCount(arr, info);
            System.out.println(i + " " + count);
        }
    }

    public static void main(String[] args) throws IOException {
        input();
    }

    private static int backStepCount(int[] arr, String[] info) {
        int count = 0;

        for(int i=0; i<20; i++) {
            arr[i] = Integer.parseInt(info[i+1]);
        }

        // 자리이동
        for(int i=19; i>0; i--) {
            for(int j=i; j>0; j--) {
                if(arr[i] < arr[j-1]) {
                    count ++;
                }
            }
        }
        
        return count;
    }
}
