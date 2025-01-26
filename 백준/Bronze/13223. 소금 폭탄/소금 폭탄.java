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

    private static String[] curr;
    private static String[] drop;

    static void input() throws IOException {
        FastReader scan = new FastReader();

        curr = scan.nextLine().split(":");
        drop = scan.nextLine().split(":");
    }

    public static void main(String[] args) throws IOException {
        input();

        // 현재 시간) 시, 분, 초  -> (가장 작은 단위인) 초
        int currHour = Integer.parseInt(curr[0]);
        int currMin = Integer.parseInt(curr[1]);
        int currSec = Integer.parseInt(curr[2]);

        int currAllSec = currHour*3600 + currMin*60 + currSec;

        // 투하 시간) 시, 분, 초 -> 초
        int dropHour = Integer.parseInt(drop[0]);
        int dropMin = Integer.parseInt(drop[1]);
        int dropSec = Integer.parseInt(drop[2]);

        int dropAllSec = dropHour*3600 + dropMin*60 + dropSec;

        // 투하 시간 - 현재 시간
        int needAllSec = dropAllSec - currAllSec;

        if(needAllSec < 0) {
            needAllSec += 24 * 3600;
        }

        if(needAllSec == 0) {
            System.out.print("24:00:00");
            return;
        }

        // needAllSec을 시:분:초로 변환
        int needHour = needAllSec / 3600;
        int needMin = (needAllSec % 3600) / 60;
        int needSec = needAllSec % 60;

        // 출력
        System.out.printf("%02d:%02d:%02d", needHour, needMin, needSec);
    }
}
