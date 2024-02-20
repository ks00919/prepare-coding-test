import static java.lang.Integer.*;
import java.io.*;
import java.util.*;

/**
 * [S2] 백준 4963 섬의 개수
 * 메모리 : 14168KB
 * 시간 : 128ms
 * 코드 길이 : 2102B
 * 
 * @author 김민주
 * @see <a href="https://www.acmicpc.net/problem/4963">
 */
class Main {

    static int h, w;
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String input = br.readLine();
            if (input.equals("0 0"))
                break;

            StringTokenizer st = new StringTokenizer(input);

            w = parseInt(st.nextToken());
            h = parseInt(st.nextToken());

            map = new int[h][w];
            visited = new boolean[h][w];

            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    map[i][j] = parseInt(st.nextToken());
                }
            }

            int count = 0;
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    // 만약 섬이고 방문하지 않았다면 섬 영역 체크, 카운트 1증가
                    if (map[i][j] == 1 && !visited[i][j]) {
                        bfs(i, j);
                        count++;
                    }
                }
            }

            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }

    static int[][] idx = { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 }, { 1, 0 }, { 1, -1 }, { 0, -1 } };

    static void bfs(int x, int y) {
        visited[x][y] = true;
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[] { x, y });
        while (!q.isEmpty()) {
            int[] curr = q.poll();

            // 현재 위치에서 갈 수 있는 8가지 영역 탐색
            for (int i = 0; i < 8; i++) {
                int dx = curr[0] + idx[i][0];
                int dy = curr[1] + idx[i][1];
                // 인덱스 범위를 넘어가거나 방문했다면 continue
                if (dx < 0 || dx >= h || dy < 0 || dy >= w || visited[dx][dy])
                    continue;
                // 방문 체크
                visited[dx][dy] = true;
                // 탐색 영역이 섬이라면 queue에 추가
                if (map[dx][dy] == 0)
                    continue;
                q.add(new int[] { dx, dy });
            }
        }
    }

}
