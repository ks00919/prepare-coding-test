import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * [D2] SWEA 2001 파리 퇴치
 * 메모리 : 18844KB
 * 실행시간 : 107ms
 * 코드길이 : 1669
 * 
 * @author 김민주
 * @see <a href=
 *      "https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5PzOCKAigDFAUq">
 */
class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int t = parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        // test case 수만큼 반복
        for (int testCase = 1; testCase <= t; testCase++) {
            st = new StringTokenizer(br.readLine());
            int n = parseInt(st.nextToken());
            int m = parseInt(st.nextToken());

            // 파리 수 배열에 초기화
            int[][] fly = new int[n][n];

            // 열 별로 누적합
            for (int i = 0; i < n; i++) {
                int sum = 0;
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    sum += parseInt(st.nextToken());
                    fly[i][j] = sum;
                }
            }

            int max = -1;
            for (int i = 0; m + i - 1 < n; i++) {
                for (int j = 0; m + j - 1 < n; j++) {

                    int value = 0;
                    // 파리채 영역만큼의 합계산 (열별 마지막 누적합 - 이전 누적합)
                    for (int k = 0; k < m; k++) {
                        value += j == 0 ? fly[i + k][j + m - 1] : fly[i + k][j + m - 1] - fly[i + k][j - 1];
                    }

                    if (value > max) {
                        max = value;
                    }
                }
            }

            // 결과 출력
            sb.append(String.format("#%d %d%n", testCase, max));
        }
        System.out.println(sb);
    }
}
