import static java.lang.Integer.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

/**
 * [D4] SWEA 1868 파핑파핑 지뢰찾기
 * 메모리 : 38820KB
 * 실행시간 : 234ms
 * 코드길이 : 2872
 * 
 * @author 김민주
 */
class Solution {

    // 지도
    static char[][] map;
    // 방문 체크
    static boolean[][] visited;
    static int N;

    // 좌표
    static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            int count = 0;
            N = parseInt(br.readLine());
            map = new char[N][N];
            visited = new boolean[N][N];

            for (int i = 0; i < N; i++) {
                String input = br.readLine();
                for (int j = 0; j < N; j++) {
                    map[i][j] = input.charAt(j);
                }
            }

            // 지뢰가 아니고 방문하지 않았고 주변에 지뢰가 없다면 클릭
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] == '.' && !visited[i][j] && count(i, j) == 0) {
                        click(i, j);
                        count++;
                    }
                }
            }

            // 클릭되지 않은 부분 카운트
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] == '.' && !visited[i][j])
                        count++;
                }
            }

            sb.append(String.format("#%d %d%n", tc, count));
        }

        System.out.println(sb);
    }

    static int[][] idx = { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 }, { 1, 0 }, { 1, -1 }, { 0, -1 } };

    // bfs
    public static void click(int x, int y) {
        visited[x][y] = true;
        Queue<Pair> q = new ArrayDeque<>();
        q.offer(new Pair(x, y));

        while (!q.isEmpty()) {
            Pair current = q.poll();

            for (int i = 0; i < 8; i++) {
                int dx = current.x + idx[i][0];
                int dy = current.y + idx[i][1];

                // 배열 범위 내의 미방문, 지뢰 아닌 곳, 주변의 지뢰가 하나도 없는 곳 큐에 추가
                if (dx < 0 || dx >= N || dy < 0 || dy >= N || visited[dx][dy] || map[dx][dy] == '*')
                    continue;
                // 주변 방문 체크
                visited[dx][dy] = true;

                if (count(dx, dy) != 0) {
                    continue;
                }

                q.add(new Pair(dx, dy));
            }
        }
    }

    // 주변 8개 지뢰 세기
    public static int count(int x, int y) {
        int count = 0;
        for (int i = 0; i < 8; i++) {
            int dx = x + idx[i][0];
            int dy = y + idx[i][1];

            if (dx < 0 || dx >= N || dy < 0 || dy >= N)
                continue;

            if (map[dx][dy] == '*')
                count++;
        }
        return count;
    }
}