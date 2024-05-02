import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * [G1] 백준 1194 달이 차오른다, 가자.
 * 메모리 : 17128KB
 * 시간 : 168ms
 * 코드 길이 : 2562B
 * 
 * @author 김민주
 * @see <a href="https://www.acmicpc.net/problem/1194">
 */
public class Main {

    static int N, M;
    static char[][] map;

    static class Pair {
        // 열쇠를 가진 유무를 비트마스킹으로 체크
        int x, y, key, count;

        public Pair(int x, int y, int key, int count) {
            this.x = x;
            this.y = y;
            this.key = key;
            this.count = count;
        }

        @Override
        public String toString() {
            return "Pair [x=" + x + ", y=" + y + ", key=" + key + ", count=" + count + "]";
        }

    }

    // BFS + 비트마스킹
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = parseInt(st.nextToken());
        M = parseInt(st.nextToken());

        map = new char[N][M];
        Pair curr = null;
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = input.charAt(j);

                if (map[i][j] == '0')
                    curr = new Pair(i, j, 0, 0);
            }
        }

        System.out.println(bfs(curr));
    }

    static int[] dx = { 1, -1, 0, 0 };
    static int[] dy = { 0, 0, 1, -1 };

    public static int bfs(Pair start) {
        Queue<Pair> q = new ArrayDeque<>();
        q.add(start);
        // 비트 6개 저장
        boolean[][][] visited = new boolean[N][M][64];
        visited[start.x][start.y][0] = true;

        while (!q.isEmpty()) {
            Pair curr = q.poll();
            // System.out.println(curr);
            if (map[curr.x][curr.y] == '1')
                return curr.count;

            for (int i = 0; i < 4; i++) {
                int x = curr.x + dx[i];
                int y = curr.y + dy[i];

                // 전에 똑같은 열쇠를 들고 방문한 곳이거나, 벽이거나, 인덱스 범위를 넘었다면 다음으로
                if (x < 0 || y < 0 || x >= N || y >= M || map[x][y] == '#' || visited[x][y][curr.key]) {
                    continue;
                }

                visited[x][y][curr.key] = true;
                // 만약 문이라면 가지고 있는 열쇠가 있을때만 전진
                if (Character.isUpperCase(map[x][y])) {
                    if ((curr.key & (1 << (map[x][y] - 'A'))) == 0) {
                        continue;
                    }
                    q.add(new Pair(x, y, curr.key, curr.count + 1));
                // 만약 열쇠라면 가진 열쇠 추가
                } else if (Character.isLowerCase(map[x][y])) {
                    int key = curr.key | (1 << (map[x][y] - 'A'));
                    q.add(new Pair(x, y, key, curr.count + 1));
                } else {
                    // 땅이라면 그대로 전진
                    q.add(new Pair(x, y, curr.key, curr.count + 1));
                }
            }
        }

        return -1;
    }
}
