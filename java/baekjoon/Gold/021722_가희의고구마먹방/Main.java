import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * [G5] 백준 21722 가희의 고구마 먹방
 * <p>
 * 메모리 : 13176KB
 * 시간 : 192ms
 * 코드 길이 : 1900B
 */
public class Main {

    private static int r;
    private static int c;
    private static int t;
    private static int max = Integer.MIN_VALUE;

    private static char[][] map;

    private static int[] dx = {-1, 0, 1, 0, 0};
    private static int[] dy = {0, -1, 0, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        map = new char[r][c];

        int startX = 0;
        int startY = 0;

        for (int i = 0; i < r; i++) {
            String input = br.readLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = input.charAt(j);

                if (map[i][j] == 'G') {
                    startX = i;
                    startY = j;
                    map[i][j] = '.';
                }
            }
        }

        dfs(startX, startY, 0, 0);
        System.out.println(max);
    }

    // 브루트포스, 백트래킹
    private static void dfs(int x, int y, int time, int sweetPotato) {
        if (time == t) {
            max = Math.max(max, sweetPotato);
            return;
        }

        for (int i = 0; i < 5; i++) {
            int tx = x + dx[i];
            int ty = y + dy[i];

            if (tx < 0 || ty < 0 || tx >= r || ty >= c || map[tx][ty] == '#') continue;

            if (map[tx][ty] == 'S') {
                map[tx][ty] = '.';
                dfs(tx, ty, time + 1, sweetPotato + 1);
                map[tx][ty] = 'S';
            } else {
                dfs(tx, ty, time + 1, sweetPotato);
            }
        }
    }
}
