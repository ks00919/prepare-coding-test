import static java.lang.Integer.*;

import java.io.*;
import java.util.*;

/**
 * [G4] 백준 20056 마법사 상어와 파이어볼
 * 메모리 : 61088KB
 * 시간 : 408ms
 * 코드 길이 : 3928B
 *
 * @see <a href="https://www.acmicpc.net/problem/20056/>
 */
public class Main {

    /*
        인덱스 범위를 넘겼을 때 연산과 문제 조건을 정확하게 지키면 구현은 어렵지 않은 문제
        문제 조건 중 질량 0이 되면 없애야되는 조건을 지키지 않아서 1회 틀림
     */
    private static int N;
    private static List<FireBall>[][] map;

    private static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    private static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

    private static class FireBall {
        /* 위치 */
        int r;
        int c;
        /* 질량 */
        int mass;
        /* 속력 */
        int speed;
        /* 방향 */
        int direction;

        public FireBall(int r, int c, int mass, int speed, int direction) {
            this.r = r;
            this.c = c;
            this.mass = mass;
            this.speed = speed;
            this.direction = direction;
        }

    }

    public static void move() {
        List<FireBall>[][] tmp = new ArrayList[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == null)
                    continue;
                for (FireBall fireBall : map[i][j]) {
                    int x = (fireBall.r + (dx[fireBall.direction] + N) * fireBall.speed) % N;
                    int y = (fireBall.c + (dy[fireBall.direction] + N) * fireBall.speed) % N;
                    if (tmp[x][y] == null)
                        tmp[x][y] = new ArrayList<>();
                    tmp[x][y].add(new FireBall(x, y, fireBall.mass, fireBall.speed, fireBall.direction));
                }
            }
        }

        map = tmp;
    }

    public static int[][] newDirections = {{0, 2, 4, 6}, {1, 3, 5, 7}};

    public static void merge() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == null || map[i][j].size() < 2)
                    continue;

                int size = map[i][j].size();
                int mass = 0;
                int speed = 0;

                int rest = map[i][j].get(0).direction % 2;
                boolean isAllSame = true;

                for (FireBall fireBall : map[i][j]) {
                    mass += fireBall.mass;
                    speed += fireBall.speed;

                    if (rest != fireBall.direction % 2)
                        isAllSame = false;
                }
                if (mass / 5 == 0) {
                    map[i][j] = null;
                    continue;
                }


                int dIndex = isAllSame ? 0 : 1;

                map[i][j] = new ArrayList<>();
                for (int k = 0; k < 4; k++) {
                    map[i][j].add(new FireBall(i, j, mass / 5, speed / size, newDirections[dIndex][k]));
                }

            }
        }
    }

    public static int getSum() {
        int sum = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == null) continue;
                for (FireBall fireBall : map[i][j])
                    sum += fireBall.mass;
            }
        }
        return sum;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = parseInt(st.nextToken());
        int M = parseInt(st.nextToken());
        int K = parseInt(st.nextToken());

        map = new ArrayList[N][N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = parseInt(st.nextToken()) - 1;
            int c = parseInt(st.nextToken()) - 1;

            if (map[r][c] == null)
                map[r][c] = new ArrayList<>();

            map[r][c].add(
                    new FireBall(r, c, parseInt(st.nextToken()), parseInt(st.nextToken()), parseInt(st.nextToken())));
        }

        for (int i = 0; i < K; i++) {
            move();
            merge();
        }

        System.out.println(getSum());
    }
}
