import static java.lang.Integer.*;

import java.io.*;
import java.util.*;

/**
 * [B1] 백준 11050 이항 계수 1
 * 메모리 : 11500KB
 * 시간 : 76ms
 * 코드 길이 : 807B
 * 
 * @author 김민주
 * @see <a href="https://www.acmicpc.net/problem/11050">
 */
public class Main {

    // 이항계수 - 파스칼의 삼각형
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = parseInt(st.nextToken());
        int K = parseInt(st.nextToken());

        int[][] triangle = new int[N + 1][N + 1];
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= i; j++) {
                if (i == j || j == 0) {
                    triangle[i][j] = 1;
                    continue;
                }

                triangle[i][j] = triangle[i - 1][j - 1] + triangle[i - 1][j];
            }
        }

        System.out.println(triangle[N][K]);
    }
}
