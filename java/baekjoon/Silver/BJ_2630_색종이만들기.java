import static java.lang.Integer.*;

import java.io.*;
import java.util.*;

/**
 * [S2] 백준 2630 색종이 만들기
 * 메모리 : 12956KB
 * 시간 : 108ms
 * 코드 길이 : 1712B
 * 
 * @author 김민주
 * @see <a href="https://www.acmicpc.net/problem/2630">
 */
public class Main {

    static int[][] papers;

    // 분할 정복
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = parseInt(br.readLine());
        papers = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                papers[i][j] = parseInt(st.nextToken());
            }
        }

        recursion(N, 0, 0);

        StringBuilder sb = new StringBuilder();
        sb.append(count[0]).append('\n');
        sb.append(count[1]);
        System.out.println(sb);
    }

    static int[] count = new int[2];

    public static void recursion(int size, int startX, int startY) {
        int color = papers[startX][startY];

        // 만약 종이 사이즈가 1이라면 무조건 색종이
        if (size == 1) {
            count[color]++;
            return;
        }

        int endX = startX + size;
        int endY = startY + size;

        for (int i = startX; i < endX; i++) {
            for (int j = startY; j < endY; j++) {

                if (color != papers[i][j]) {
                    size /= 2;
                    endX = startX + size;
                    endY = startY + size;
                    // 다른 색깔이 있다면 현재 영역 4분할해서 재귀 호출
                    recursion(size, startX, startY);
                    recursion(size, startX, endY);
                    recursion(size, endX, startY);
                    recursion(size, endX, endY);
                    return;
                }
            }
        }
        // 현재 영역 모두 같은 색이라면 count 증가
        count[color]++;
    }

}
