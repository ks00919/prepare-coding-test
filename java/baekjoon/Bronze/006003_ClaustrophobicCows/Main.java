import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * [B1] 백준 6003 Claustrophobic Cows
 * 메모리 : 12440KB
 * 시간 : 108ms
 * 코드 길이 : 1465B
 * <p>
 * 항상 오버플로우를 주의하자!!!
 *
 * @see <a href="https://www.acmicpc.net/problem/6003"/>
 */
public class Main {

    private static class Cow {
        long x;
        long y;

        public Cow(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Cow[] cows = new Cow[n + 1];

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            cows[i] = new Cow(Long.parseLong(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        double min = Double.MAX_VALUE;
        int a = -1;
        int b = -1;

        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                long xDistance = cows[i].x - cows[j].x;
                long yDistance = cows[i].y - cows[j].y;
                long differ = xDistance * xDistance + yDistance * yDistance;
                double distance = Math.sqrt(differ);

                if (distance < min) {
                    min = distance;
                    a = i;
                    b = j;
                }
            }
        }

        StringBuilder sb = new StringBuilder().append(a).append(" ").append(b);
        System.out.println(sb);
    }
}
