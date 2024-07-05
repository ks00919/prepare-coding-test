import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static java.lang.Integer.parseInt;

/**
 * [S1] 2667 단지번호붙이기
 * 메모리 : 11640KB
 * 시간 : 68ms
 * 코드 길이 : 2190B
 * <p>
 * 단순 bfs, 단지의 집 개수를 세는 위치가 잘못되어 한 번 틀림
 *
 * @see <a href="https://www.acmicpc.net/problem/2667"></a>
 */
public class Main {

    private static int n;
    private static int[][] map;
    private static boolean[][] visited;
    private static List<Integer> danji = new ArrayList<>();

    private static int[] dx = {-1, 0, 1, 0};
    private static int[] dy = {0, 1, 0, -1};

    private static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static void bfs(int x, int y) {
        Queue<Node> q = new ArrayDeque<>();
        q.add(new Node(x, y));

        int count = 0;

        while (!q.isEmpty()) {
            Node cur = q.poll();
            if (visited[cur.x][cur.y]) continue;
            visited[cur.x][cur.y] = true;
            count++;

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= n || ny >= n
                        || visited[nx][ny] || map[nx][ny] == 0) continue;

                q.add(new Node(nx, ny));
            }
        }

        danji.add(count);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = parseInt(br.readLine());

        map = new int[n][n];
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = input.charAt(j) - '0';
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j]) continue;
                if (map[i][j] == 1)
                    bfs(i, j);
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(danji.size()).append("\n");
        Collections.sort(danji);
        for (int number : danji) {
            sb.append(number).append("\n");
        }
        System.out.println(sb);
    }
}
