import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

/**
 * [G3] 백준 14442 벽 부수고 이동하기 2
 * 메모리 : 370772KB
 * 시간 : 1520ms
 * 코드 길이 : 2378B
 * 
 * 3차원 방문 체크 배열을 사용해서 벽을 부수는 경우의 수 고려
 *
 * @see <a href="https://www.acmicpc.net/problem/14442"></a>
 */
public class Main {

    private static int n;
    private static int m;
    private static int k;

    private static int[][] map;

    private static int[] dx = {0, 0, -1, 1};
    private static int[] dy = {1, -1, 0, 0};

    private static class Node {
        int x;
        int y;
        int k;
        int count;

        public Node(int x, int y, int k, int count) {
            this.x = x;
            this.y = y;
            this.k = k;
            this.count = count;
        }
    }

    private static int bfs() {
        Queue<Node> q = new ArrayDeque<>();
        q.add(new Node(0, 0, 0, 1));
        boolean[][][] visited = new boolean[n][m][k + 1];

        int goalX = n - 1;
        int goalY = m - 1;

        while (!q.isEmpty()) {
            Node cur = q.poll();

            if (visited[cur.x][cur.y][cur.k]) {
                continue;
            }
            visited[cur.x][cur.y][cur.k] = true;

            if (cur.x == goalX && cur.y == goalY) {
                return cur.count;
            }

            for (int i = 0; i < 4; i++) {
                int x = cur.x + dx[i];
                int y = cur.y + dy[i];

                if (x < 0 || y < 0 || x >= n || y >= m || visited[x][y][cur.k]) {
                    continue;
                }

                if (map[x][y] == 0) {
                    q.add(new Node(x, y, cur.k, cur.count + 1));
                } else if (cur.k < k) {
                    q.add(new Node(x, y, cur.k + 1, cur.count + 1));
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = parseInt(st.nextToken());
        m = parseInt(st.nextToken());
        k = parseInt(st.nextToken());

        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = input.charAt(j) - '0';
            }
        }

        System.out.println(bfs());
    }
}
