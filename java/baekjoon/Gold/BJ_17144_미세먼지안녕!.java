import static java.lang.Integer.*;

import java.util.*;
import java.io.*;

/**
 * [G4] 백준 17144 미세먼지 안녕!
 * 메모리 : 29928KB
 * 시간 : 284ms
 * 코드 길이 : 3197B
 * 
 * @see <a href="https://www.acmicpc.net/problem/17144">
 */
public class Main {

    static int R, C, T;

    static int up;
    static int down;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = parseInt(st.nextToken());
        C = parseInt(st.nextToken());
        T = parseInt(st.nextToken());

        map = new int[R][C];
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                map[i][j] = parseInt(st.nextToken());

                if (map[i][j] == -1) {
                    if (up == 0)
                        up = i;
                    else
                        down = i;
                }
            }
        }

        for (int i = 0; i < T; i++) {
            dust();
            purification();
        }

        System.out.println(count());
    }

    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, 1, -1 };

    // 먼지를 찾으면 확산 실행
    public static void dust() {
        int[][] temp = new int[R][C];
        temp[up][0] = -1;
        temp[down][0] = -1;

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] > 0) {
                    difusion(temp, i, j);
                }
            }
        }

        // 확산이 끝난 곳에 잔여 먼지 합산하기
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] > 0) {
                    temp[i][j] += map[i][j];
                }
            }
        }

        // 배열 바꾸기
        map = temp;
    }

    // 문제 조건에서 모든 확산은 동시에 일어난다고 되어있기 때문에, 확산 후 잔여 먼지는 반복문에 포함되면 안되므로 추후에 한번에 합치기
    public static void difusion(int[][] dust, int x, int y) {
        int amount = map[x][y] / 5;
        int count = 0;

        // 공기청정기와 칸 수를 벗어나는 경우에는 확산하지 않음
        for (int i = 0; i < 4; i++) {
            int difX = x + dx[i];
            int difY = y + dy[i];

            if (difX < 0 || difY < 0 || difX >= R || difY >= C || map[difX][difY] == -1)
                continue;

            // 먼지 확산
            dust[difX][difY] += amount;
            count++;
        }

        // 확산된 양에 확산된 칸 수 만큼 곱해서 원래 먼지에서 빼기
        map[x][y] -= amount * count;
    }

    // 공기 정화
    // 범위 다르게 테두리만 돌리기!! - 배열돌리기1 문제와 같음
    public static void purification() {
        // 공기청정기를 기준으로 아래 부분
        int x = down + 1;
        int y = 0;

        while (x + 1 < R) {
            map[x][y] = map[++x][y];
        }

        while (y + 1 < C) {
            map[x][y] = map[x][++y];
        }

        while (x > down) {
            map[x][y] = map[--x][y];
        }

        while (y > 1) {
            map[x][y] = map[x][--y];
        }
        // 새로 나온 공기 초기화
        map[x][y] = 0;

        // 공기청정기 기준 위쪽 부분 순환
        x = up - 1;
        y = 0;

        while (x > 0) {
            map[x][y] = map[--x][y];
        }

        while (y + 1 < C) {
            map[x][y] = map[x][++y];
        }

        while (x < up) {
            map[x][y] = map[++x][y];
        }

        while (y > 1) {
            map[x][y] = map[x][--y];
        }

        map[x][y] = 0;
    }

    // 남아있는 먼지 세기
    static long count() {
        long cnt = 0l;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] > 0)
                    cnt += map[i][j];
            }
        }
        return cnt;
    }

}
