import static java.lang.Integer.*;

import java.util.*;
import java.io.*;

/**
 * [G4] 백준 4485 녹색 옷 입은 애가 젤다지?
 * 메모리 : 17696KB
 * 시간 : 176KB
 * 코드 길이 : 2025B
 * 
 * @author 김민주
 * @see <a href="https://www.acmicpc.net/problem/4485">
 */
public class Main {

    // 간선 클래스
    static class Edge implements Comparable<Edge> {
        int x;
        int y;
        int weight;

        public Edge(int x, int y, int weight) {
            this.x = x;
            this.y = y;
            this.weight = weight;
        }

        @Override
        public int compareTo(Main.Edge o) {
            return this.weight - o.weight;
        }
    }

    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, 1, -1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = 0;
        int tc = 1;

        // N이 0이면 테스트 케이스 입력 종료
        while ((N = parseInt(br.readLine())) != 0) {
            int[][] map = new int[N][N];

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = parseInt(st.nextToken());
                }
            }

            boolean[][] visited = new boolean[N][N];
            // [0][0]에서 출발
            Edge last = new Edge(0, 0, map[0][0]);

            // 우선순위 큐 사용, 가장 잃은 코인이 적은 것부터 뽑기
            Queue<Edge> q = new PriorityQueue<>();
            q.add(last);
            visited[0][0] = true;

            while (!q.isEmpty()) {
                last = q.poll();

                // 만약 목적지에 도착하면 종료
                if (last.x == N - 1 && last.y == N - 1)
                    break;

                // 4방 탐색
                for (int i = 0; i < 4; i++) {
                    int x = last.x + dx[i];
                    int y = last.y + dy[i];

                    if (x < 0 || y < 0 || x >= N || y >= N || visited[x][y])
                        continue;

                    visited[x][y] = true;
                    q.add(new Edge(x, y, last.weight + map[x][y]));
                }
            }

            sb.append("Problem ").append(tc++).append(": ").append(last.weight).append("\n");
        }

        System.out.println(sb);
    }
}
