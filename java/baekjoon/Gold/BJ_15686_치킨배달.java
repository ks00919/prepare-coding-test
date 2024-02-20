import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * [G5] 백준 15686 치킨 배달
 * 메모리 : 17036KB
 * 시간 : 196ms
 * 코드 길이 : 1723B
 * 
 * @author 김민주
 * @see <a href="https://www.acmicpc.net/problem/15686">
 */
class Main {

    static int N, M;
    static int[][] map;
    static int[][] idx = { { 0, -1 }, { -1, 0 }, { 0, 1 }, { 1, 0 }, { -1, -1 }, { -1, 1 }, { 1, -1 }, { 1, 1 } };
    static int[][] selected;
    static int distance = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = parseInt(st.nextToken());
        M = parseInt(st.nextToken());

        map = new int[N][N];
        selected = new int[M][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = parseInt(st.nextToken());
            }
        }

        dfs(0, 0, 0);
        System.out.println(distance);
    }

    // dfs로 치킨집을 M만큼 선택해서 각 집의 선택한 치킨집과의 최소 치킨거리 구하기!
    public static void dfs(int depth, int x, int y) {
        // M개만큼 선택했다면 현재 치킨거리가 최소값보다 작은지 비교
        if (depth == M) {
            int total = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] == 1) {
                        total += chickenDistance(i, j);
                    }
                }
            }

            distance = Math.min(distance, total);
            return;
        }

        for (int i = x; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 2) {
                    // 선택한 치킨집을 -1로 방문 체크하고 선택배열에 저장
                    map[i][j] = -1;
                    selected[depth] = new int[] { i, j };
                    dfs(depth + 1, i, j);
                    map[i][j] = 2;
                }
            }
        }
    }

    public static int chickenDistance(int x, int y) {
        int distance = Integer.MAX_VALUE;
        // 지금 집에서 가장 가까운 치킨집의 치킨거리 구하기
        for (int k = 0; k < M; k++) {
            int curr = Math.abs(selected[k][0] - x) + Math.abs(selected[k][1] - y);
            distance = Math.min(distance, curr);
        }

        return distance;
    }

}
