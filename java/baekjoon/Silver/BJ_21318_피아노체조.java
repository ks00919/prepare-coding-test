import static java.lang.Integer.*;
import java.io.*;
import java.util.StringTokenizer;

/**
 * [S1] 백준 21318 피아노 체조
 * 메모리 : 63936
 * 시간 : 676ms
 * 코드 길이 : 1124B
 * 
 * @author 김민주
 * @see <a href="https://www.acmicpc.net/problem/21318">
 */
class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = parseInt(br.readLine());

        // 악보 난이도 저장
        int[] sheet = new int[n];
        // 실수 횟수 누적합 저장
        int[] miss = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            // 배열 초기화
            sheet[i] = parseInt(st.nextToken());
        }

        // 만약 이전 난이도가 이후 난이도보다 높다면 실수 횟수 1 추가(첫번째 악보는 실수 0)
        for (int i = 1; i < n; i++) {
            if (sheet[i - 1] > sheet[i]) {
                miss[i]++;
            }
            miss[i] += miss[i - 1];
        }

        int q = parseInt(br.readLine());
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            // 시작 악보
            int start = parseInt(st.nextToken()) - 1;
            // 끝 악보
            int end = parseInt(st.nextToken()) - 1;
            // 끝 인덱스 누적합 - 시작 인덱스 누적합
            int result = miss[end] - miss[start];
            sb.append(result).append('\n');
        }
        System.out.println(sb);
    }
}