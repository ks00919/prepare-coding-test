import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * [S2] 백준 11501 주식
 * 
 * 메모리 : 324284KB
 * 시간 : 1072ms
 * 코드 길이 : 1091B
 * 
 * @see <a href="https://www.acmicpc.net/problem/11501"/>
 */
public class Main {

    /*
     * 그리디
     * 문제에서 나오는 자료형을 주의해야하는 문제
     * 
     * 부호가 있는 8비트 정수 : byte
     * 부호가 있는 16비트 정수 : short
     * 부호가 있는 32비트 정수 : int
     * 부호가 있는 64비트 정수 : long
     * 
     * 전체 배열에서 뒤부터 탐색
     * - 현재 값보다 작으면 주식을 산다 : 현재 값 - 주식 구매값 = 순이익
     * - 현재 값보다 크면 주식을 판다 : 현재 값을 새 주식값으로 갱신
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int tc = 0; tc < t; tc++) {
            int n = Integer.parseInt(br.readLine());

            long[] money = new long[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                money[i] = Long.parseLong(st.nextToken());
            }

            long sum = 0;
            long max = money[n - 1];

            // 최대 이익 계산하는 부분
            for (int i = n - 2; i >= 0; i--) {
                if (money[i] > max) {
                    max = money[i];
                    continue;
                }

                sum += max - money[i];
            }

            sb.append(sum).append("\n");
        }
        System.out.println(sb);
    }
}