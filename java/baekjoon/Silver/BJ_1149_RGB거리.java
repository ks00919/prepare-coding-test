import static java.lang.Integer.*;

import java.util.*;
import java.io.*;

/**
 * [S1] 백준 1149 RGB거리
 * 메모리 : 15988KB
 * 시간 : 92ms
 * 코드 길이 : 1099B
 * 
 * @author 김민주
 * @see <a href="https://www.acmicpc.net/problem/1149">
 */
public class Main {

    // DP
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = parseInt(br.readLine());

        int[][] cost = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                cost[i][j] = parseInt(st.nextToken());
            }
        }

        // 첫 집을 기준으로 최소 비용 3가지 구하기
        // 첫 집이 빨강일때, 초록일때, 파랑일때 ...
        int[][] total = new int[N][3];
        // 첫 집의 비용 모두 초기화
        for (int i = 0; i < 3; i++) {
            total[0][i] = cost[0][i];
        }

        for (int i = 1; i < N; i++) {
            // 현재 선택한 집의 색깔과 다른 두 가지 색깔의 이전 집 비용 중 최소값 선택
            total[i][0] = (int) Math.min(total[i - 1][1], total[i - 1][2]) + cost[i][0];
            total[i][1] = (int) Math.min(total[i - 1][0], total[i - 1][2]) + cost[i][1];
            total[i][2] = (int) Math.min(total[i - 1][0], total[i - 1][1]) + cost[i][2];
        }

        // 세가지 경우의 비용 중 최소값 선택
        System.out.println(Math.min(Math.min(total[N - 1][0], total[N - 1][1]), total[N - 1][2]));
    }
}
