import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

/**
 * [D4] SWEA 1227 [S/W 문제해결 기본] 7일차 - 미로2
 * 메모리 : 26564KB
 * 실행시간 : 145ms
 * 코드길이 : 2343
 * 
 * @author 김민주
 */
class Solution {
    // 미로
    static int[][] map;
    // 방문 저장 배열
    static boolean[][] visited;
    // 시작 좌표, 끝 좌표
    static Coordinate start, end;
    static boolean isArrive;

    // 좌표 저장 클래스
    static class Coordinate {
        int x, y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public boolean equals(Coordinate other) {
            return this.x == other.x && this.y == other.y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int tc = 1; tc <= 10; tc++) {
            // 전역변수 초기화
            isArrive = false;
            visited = new boolean[100][100];
            // 테스트 케이스 넘버 넘기기
            br.readLine();

            map = new int[100][100];

            // 2, 3은 시작, 도착 좌표로 미리 저장
            for (int i = 0; i < 100; i++) {
                String input = br.readLine();
                for (int j = 0; j < 100; j++) {
                    map[i][j] = input.charAt(j) - '0';

                    if (map[i][j] == 2) {
                        start = new Coordinate(i, j);
                    } else if (map[i][j] == 3) {
                        end = new Coordinate(i, j);
                    }
                }
            }

            bfs();
            sb.append(String.format("#%d %d%n", tc, isArrive ? 1 : 0));
        }
        System.out.println(sb);
    }

    static int[][] idx = { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, 1 }, { 1, 1 }, { 1, 0 }, { 1, -1 }, { 0, -1 } };

    // bfs 저장
    public static void bfs() {
        Queue<Coordinate> q = new ArrayDeque<>();
        q.offer(start);
        while (!q.isEmpty()) {
            Coordinate current = q.poll();
            // 도착했다면 반복문 종료
            if (current.equals(end))
                break;

            // 8방향 탐색
            for (int i = 0; i < 8; i++) {
                int x = current.x + idx[i][0];
                int y = current.y + idx[i][1];

                // 만약 좌표 범위를 넘거나, 벽이거나, 방문한 곳이라면 continue
                if (x < 0 || x >= 100 || y < 0 || y >= 100 || map[x][y] == 1 || visited[x][y])
                    continue;
                // 방문 체크 후 해당 좌표 대기열 추가
                visited[x][y] = true;
                q.offer(new Coordinate(x, y));
            }
        }
        // q가 비어있다면 도착하지 못한 것
        isArrive = !q.isEmpty();
    }
}