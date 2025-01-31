import java.io.*;
import java.util.*;

public class Main {
    static FastReader scan = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    private static int n;
    private static int[] dp;
    private static List<List<Integer>> bricks = new ArrayList<>();

    // 무게 확인용
    private static int[] weightArr;

    public static void main(String[] args) {
        n = scan.nextInt();

        for(int i=1; i<=n; i++) {
            String[] data = scan.nextLine().split(" ");

            int s = Integer.parseInt(data[0]);
            int h = Integer.parseInt(data[1]);
            int w = Integer.parseInt(data[2]);
            int index = i;

            bricks.add(Arrays.asList(s,h,w,index));
        }

        dp = new int[n];
        weightArr = new int[n];
        stackBricks();

        // 자원 해제
        scan.close();
        out.close();
    }

    private static void stackBricks() {
        /**
         * 1. 밑면 넓이 내림차순 정렬
         * 2. dp[i] = i개를 쌓을 때 나올 수 있는 최대 높이(h)
         * 3. 무게 비교(가장 긴 감소하는 부분 수열 문제와 유사) + 높이가 최대가 되는 것 고려
         * 4. 최대 높이(maxHeight)를 찾았다면, 해당 벽돌을 역추적해 출력
         * - dp[i] 가 최종 최대 높이일 때, list 에 벽돌(*) index 추가 -> 최대 높이 - 벽돌(*)의 높이로 갱신해가면서 list 생성
         * 5. list 출력
         */

        // 밑면 넓이 내림차순 정렬
        Collections.sort(bricks, (a, b) -> Integer.compare(b.get(0), a.get(0)));

        // 무게만 있는 배열 [4, 5, 3, 6, 2]
        for(int i=0; i<n; i++) {
            weightArr[i] = bricks.get(i).get(2);
        }

        int maxHeight = 0;
        for(int i=0; i<n; i++) {
            dp[i] = bricks.get(i).get(1);

            for(int j=0; j<i; j++) {
                // 무게 확인
                if(weightArr[i] < weightArr[j]) {
                    if (dp[i] < dp[j] + bricks.get(i).get(1)) {
                        dp[i] = dp[j] + bricks.get(i).get(1);
                    }
                }
            }

            // 높이 갱신
            if (dp[i] > maxHeight) {
                maxHeight = dp[i];
            }
        }

        stackList(maxHeight);
    }

    private static void stackList(int maxHeight) {
        // 최대 높이를 찾은 후, 벽돌을 역추적해 해당 인덱스 찾기
        List<Integer> list = new ArrayList<>();

        for(int i=n-1; i>=0; i--) {
            if(dp[i] == maxHeight) {
                list.add(bricks.get(i).get(3));
                maxHeight -= bricks.get(i).get(1);
            }
        }

        // 탑의 가장 위 벽돌부터 출력
        out.println(list.size());
        for(int i=0; i<list.size(); i++) {
            out.println(list.get(i));
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
