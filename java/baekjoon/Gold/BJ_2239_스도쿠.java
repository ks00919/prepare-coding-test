import static java.lang.Integer.*;

import java.io.*;
import java.util.*;

/**
 * [G4] 백준 2239 스도쿠
 * 메모리 : 17116KB
 * 시간 : 540ms
 * 코드길이 : 1891B
 * 
 * @author 김민주
 * @see <a href="https://www.acmicpc.net/problem/2239">
 */
public class Main {

    static int[][] board = new int[9][9];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 9; i++) {
            String input = br.readLine();
            for (int j = 0; j < 9; j++) {
                board[i][j] = input.charAt(j) - '0';
            }
        }

        dfs(0, 0);
    }

    // 백트래킹
    public static void dfs(int row, int col) {
        // 만약 행의 끝까지 왔다면 다음 행으로 재귀호출
        if (col == 9) {
            dfs(row + 1, 0);
            return;
        }

        // 만약 모든 행과 열 끝까지 탐색에 성공했다면 결과 출력
        if (row == 9) {
            printResult();
        }

        // 비어있는 칸일 때
        if (board[row][col] == 0) {
            for (int i = 1; i < 10; i++) {
                // 1 - 9 중에 반복하면서 들어갈 수 있는 수인지 체크
                if (check(row, col, i)) {
                    board[row][col] = i;
                    dfs(row, col + 1);
                }
            }
            board[row][col] = 0;
            return;
        }

        // 비어있지 않은 칸이면 다음 칸으로 이동
        dfs(row, col + 1);
    }

    public static boolean check(int row, int col, int value) {
        for (int i = 0; i < 9; i++) {
            // 가로 줄 체크
            if (board[row][i] == value)
                return false;

            // 세로 줄 체크
            if (board[i][col] == value)
                return false;
        }

        // 현재 있는 영역의 처음 칸 인덱스 계산
        int x = (row / 3) * 3;
        int y = col - col % 3;

        // 현재 영역에서 들어갈 수 있는 수 인지 체크
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[x + i][y + j] == value)
                    return false;
            }
        }

        return true;
    }

    // 결과 출력 후 프로그램 종료
    public static void printResult() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sb.append(board[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
        System.exit(0);
    }
}
