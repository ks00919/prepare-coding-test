import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

/**
 * [G5] 백준 1245 농장 관리
 * 메모리 : 13524KB
 * 시간 : 96ms
 * 코드 길이 : 2575B
 * <p>
 * 로직 구성이 틀려서 많이 틀린 문제
 * <p>
 * 문제 풀이 방법 - bfs
 * 1. 탐색 큐에 같은 높이의 구역들을 넣음
 * 2. 현재 노드의 인접 노드에 더 높은 노드가 있다면 산 봉우리가 아니다!
 *
 * @see <a href="https://www.acmicpc.net/problem/1245"/>
 */
public class Main {

    private static int n;
    private static int m;
    /* 입력 배열 */
    private static int[][] map;
    /* 방문 배열 */
    private static boolean[][] visited;

    private static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static int[] dx = {0, 0, -1, 1, 1, 1, -1, -1};
    private static int[] dy = {1, -1, 0, 0, -1, 1, -1, 1};

    private static boolean bfs(int x, int y) {
//        높이가 0인 곳은 산 봉우리가 될 수 없다.
        if (map[x][y] == 0) return false;

        Queue<Node> q = new ArrayDeque<>();
        q.add(new Node(x, y));

        boolean result = true;

        while (!q.isEmpty()) {
            Node cur = q.poll();
            visited[cur.x][cur.y] = true;

//            인접 노드가 현재 노드보다 높은가?
            if (!check(cur.x, cur.y))
                result = false;

//            같은 높이 노드 탐색
            for (int i = 0; i < 8; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m || visited[nx][ny]) continue;

                if (map[cur.x][cur.y] == map[nx][ny]) {
                    q.add(new Node(nx, ny));
                }
            }
        }
        return result;
    }

    private static boolean check(int x, int y) {
        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue;

            if (map[x][y] < map[nx][ny]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = parseInt(st.nextToken());
        m = parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = parseInt(st.nextToken());
            }
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
//                산 봉우리라면 카운트 증가
                if (!visited[i][j] && bfs(i, j))
                    count++;
            }
        }

        System.out.println(count);
    }
}
