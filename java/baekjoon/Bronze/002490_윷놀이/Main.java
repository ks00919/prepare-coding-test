import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * [B3] 백준 2490 윷놀이
 * 
 * 메모리 : 11468KB
 * 시간 : 76ms
 * 코드 길이 : 952B
 * 
 * @see <a href="https://www.acmicpc.net/problem/2490"/>
 */
public class Main {

    static char[] yutnori = new char[5];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        init();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int sum = 0;
            for (int j = 0; j < 4; j++) {
                sum += Integer.parseInt(st.nextToken());
            }

            sb.append(yutnori[sum]).append("\n");
        }
        System.out.println(sb);
    }

    public static void init() {
        yutnori[3] = 'A'; // 도
        yutnori[2] = 'B'; // 개
        yutnori[1] = 'C'; // 걸
        yutnori[0] = 'D'; // 윷
        yutnori[4] = 'E'; // 모
    }
}