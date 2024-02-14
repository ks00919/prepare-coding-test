import static java.lang.Integer.*;

import java.io.*;

/**
 * [S1] 백준 1992 쿼드트리
 * 메모리 : 11668KB
 * 시간 : 80ms
 * 코드 길이 : 1364B
 * 
 * @author 김민주
 * @see <a href="">
 */
class Main {
    // 영상 저장
    static int[][] pixel;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = parseInt(br.readLine());
        pixel = new int[N][N];

        // 입력
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < N; j++) {
                pixel[i][j] = input.charAt(j) - '0';
            }
        }
        solution(N, 0, 0);
        System.out.println(sb);
    }

    public static void solution(int size, int x, int y) {
        int p = pixel[x][y];
        int dx = x + size;
        int dy = y + size;
        // 현재 배열이 모두 0이거나 1인지 검사
        boolean same = true;
        for (int i = x; i < dx; i++) {
            for (int j = y; j < dy; j++) {
                if (pixel[i][j] != p) {
                    same = false;
                    break;
                }
            }
        }

        // 모두 0이거나 1이라면 해당 수를 결과 문자열에 저장
        if (same) {
            sb.append(p);
            return;
        }

        // 모두 0이나 1이 아니라면 괄호 열기
        sb.append("(");
        int half = size / 2;
        // 왼쪽 위, 오른쪽 위, 왼쪽 아래, 오른쪽 아래 순서대로 분할
        solution(half, x, y);
        solution(half, x, y + half);
        solution(half, x + half, y);
        solution(half, x + half, y + half);
        sb.append(")");
    }
}