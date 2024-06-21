import static java.lang.Integer.*;

import java.io.*;
import java.util.*;

/**
 * [B3] 백준 10250 ACM 호텔
 * 메모리 : 11776KB
 * 시간 : 84ms
 * 코드 길이 : 932B
 * 
 * @author 김민주
 * @see <a href="https://www.acmicpc.net/problem/10250">
 */
public class Main {

    // 수학을 잘하자!!
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            int H = parseInt(st.nextToken());
            int W = parseInt(st.nextToken());
            int N = parseInt(st.nextToken());

            int floor = N % H;
            int room = 0;

            if (floor == 0) {
                floor = H * 100;
                room = N / H;
            } else {
                floor *= 100;
                room = N / H + 1;
            }
            sb.append(floor + room).append("\n");
        }

        System.out.println(sb);
    }
}
