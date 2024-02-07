import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * [G4] 백준 17406 배열 돌리기 4
 * 메모리 : 23200KB
 * 시간 : 232ms
 * 코드 길이 : 3461B
 * 
 * @author 김민주
 * @see <a href="https://www.acmicpc.net/problem/17406">
 */
class Main {
    // 입력 2차원 배열
    static int[][] array;
    // 회전 구역 저장 2차원 배열
    static int[][] operation;
    // 선택한 회전 구역 저장
    static int[] select;
    // 회전 구역 선택 유무 저장 배열
    static boolean[] isSelected;
    // 배열값의 최소값
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = parseInt(st.nextToken());
        int m = parseInt(st.nextToken());
        int k = parseInt(st.nextToken());

        array = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                array[i][j] = parseInt(st.nextToken());
            }
        }
        // 입력받은 회전 구역 저장
        operation = new int[k][3];
        // 회전 순서 저장 배열 생성
        select = new int[k];
        // 선택 유무 확인 배열 생성
        isSelected = new boolean[k];
        // 입력 배열 초기화
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                operation[i][j] = parseInt(st.nextToken());
            }
        }

        dfs(0, n, m, k);
        System.out.println(min);
    }

    // dfs 탐색, 순서가 의미 있음
    public static void dfs(int depth, int n, int m, int k) {
        // 순서를 모두 정했다면 정한 순서대로 배열 회전 후 배열값 찾기
        if (depth == k) {
            calculate(rotate(k), n, m);
        }

        for (int i = 0; i < k; i++) {
            // 만약 선택되지 않은 회전구역이라면 선택 후 다음 회전구역 선택
            // 다시 되돌아와서 다음 회전구역 선택
            if (!isSelected[i]) {
                isSelected[i] = true;
                select[depth] = i;
                dfs(depth + 1, n, m, k);
                isSelected[i] = false;
            }
        }
    }

    // 열의 합을 구해서 최소값 비교
    public static void calculate(int[][] array, int n, int m) {
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < m; j++) {
                sum += array[i][j];
            }
            if (sum < min) {
                min = sum;
            }
        }
    }

    public static int[][] rotate(int k) {
        int[][] copy = new int[array.length][];
        // 배열 깊은 복사
        for (int i = 0; i < array.length; i++) {
            copy[i] = Arrays.copyOf(array[i], array[i].length);
        }

        for (int i = 0; i < k; i++) {
            int[] o = operation[select[i]];

            int r = o[0];
            int c = o[1];
            int s = o[2];
            // 구역 좌표가 될 x, y 좌표 구하기
            int dx1 = r - s - 1;
            int dx2 = r + s - 1;
            int dy1 = c - s - 1;
            int dy2 = c + s - 1;
            // 정사각형(회전 구역)의 테두리 박스 개수
            int box = (dy2 - dy1 + 1) / 2;

            for (int j = 0; j < box; j++) {

                // 누락되는 값 저장
                int rup = copy[dx1][dy2];

                // 윗변 : 왼쪽값을 현재 인덱스에 저장
                for (int y = dy2; y > dy1; y--) {
                    copy[dx1][y] = copy[dx1][y - 1];
                }

                // 왼쪽변 : 아래값을 현재 인덱스에 저장
                for (int x = dx1; x < dx2; x++) {
                    copy[x][dy1] = copy[x + 1][dy1];
                }

                // 아랫변 : 오른쪽값을 현재 인덱스에 저장
                for (int y = dy1; y < dy2; y++) {
                    copy[dx2][y] = copy[dx2][y + 1];
                }

                // 오른쪽변 : 위쪽값을 현재 인덱스에 저장
                for (int x = dx2; x > dx1; x--) {
                    copy[x][dy2] = copy[x - 1][dy2];
                }

                // 누락된 값을 맞는 자리에 넣기
                copy[dx1 + 1][dy2] = rup;

                // 테두리 크기 한 칸 줄이기
                dx1++;
                dx2--;
                dy1++;
                dy2--;
            }
        }

        return copy;
    }
}