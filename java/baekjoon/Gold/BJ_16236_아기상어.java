import static java.lang.Integer.*;

import java.util.*;
import java.io.*;

/**
 * [G3] 백준 16236 아기 상어
 * 메모리 : 19108KB
 * 시간 : 176ms
 * 코드 길이 : 2669B
 * 
 * @author 김민주
 * @see <a href="https://www.acmicpc.net/problem/16236">
 */
public class Main {

    static int N;
    static int[][] map;

    static Fish shark;
    static int eatCount;

    static class Fish implements Comparable<Fish> {
        int x, y, size;

        public Fish(int x, int y, int size) {
            this.x = x;
            this.y = y;
            this.size = size;
        }

        @Override
        public int compareTo(Fish o) {
            if (this.size != o.size) {
                return this.size - o.size;
            }
            return this.x == o.x ? this.y - o.y : this.x - o.x;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = parseInt(st.nextToken());

                if (map[i][j] == 9) {
                    shark = new Fish(i, j, 2);
                    map[i][j] = 0;
                }
            }
        }

        int time = 0;
        int move = 0;

        // 먹을 수 있는 먹이가 있는 동안 상어 위치를 기준으로 bfs 탐색
        while ((move = bfs()) != 0) {
            time += move;
        }

        System.out.println(time);
    }

    static int[] dx = { -1, 0, 0, 1 };
    static int[] dy = { 0, -1, 1, 0 };

    // 배열로 우선순위를 정의하고 중간에 끊어버리면 최적해 보장 안됨
    // 완탐으로 도착할 수 있는 모든 먹이를 찾고 가장 짧은 거리 중에 가장 위쪽의 먹이 중 가장 왼쪽에 있는 먹이를 우선순위큐로 찾음
    public static int bfs() {
        // 방문 확인 배열
        boolean[][] visited = new boolean[N][N];
        // bfs를 위한 큐
        Queue<Fish> q = new ArrayDeque<>();
        // 상어가 이동할 수 있는 곳에 있는 먹이 후보들
        Queue<Fish> pq = new PriorityQueue<>();

        q.add(new Fish(shark.x, shark.y, 0));
        visited[shark.x][shark.y] = true;

        while (!q.isEmpty()) {
            Fish location = q.poll();

            for (int i = 0; i < 4; i++) {
                int x = location.x + dx[i];
                int y = location.y + dy[i];

                if (x < 0 || y < 0 || x >= N || y >= N || visited[x][y])
                    continue;
                // 상어의 크기보다 크면 이동할 수 없는 곳!
                if (map[x][y] > shark.size)
                    continue;
                visited[x][y] = true;

                // 바다가 아니면서 상어의 크기보다 작다면 먹이 후보에 추가
                if (map[x][y] != 0 && map[x][y] < shark.size) {
                    pq.add(new Fish(x, y, location.size + 1));
                }

                q.add(new Fish(x, y, location.size + 1));
            }
        }

        // 우선순위큐가 비어있으면 먹을 수 있는 먹이가 없는 것
        if (pq.isEmpty())
            return 0;

        // 최적의 물고기 꺼내기
        Fish fish = pq.poll();

        // 상어 위치를 물고기 위치로 갱신
        shark.x = fish.x;
        shark.y = fish.y;

        // 먹이 없애기
        map[fish.x][fish.y] = 0;
        // 먹은 먹이의 수가 상어의 크기와 같다면 상어 크기 1증가 및 카운트 0 초기화
        if (++eatCount == shark.size) {
            eatCount = 0;
            shark.size++;
        }
        // 이동 거리 반환
        return fish.size;
    }

}
