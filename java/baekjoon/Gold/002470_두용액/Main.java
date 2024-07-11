import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * [G5] 백준 2470 두 용액
 * <p>
 * 메모리 : 31236KB
 * 시간 : 248ms
 * 코드 길이 : 1293B
 *
 * @see <a href="https://www.acmicpc.net/problem/2470">문제</a>
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] solutions = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            solutions[i] = Integer.parseInt(st.nextToken());
        }
        // 정렬
        Arrays.sort(solutions);

        // 시작 포인터와 끝 포인터
        int start = 0;
        int end = n - 1;

        int min = Integer.MAX_VALUE;
        int[] answers = new int[2];

        // 투 포인터 사용
        while (start < end) {
            int gap = solutions[start] + solutions[end];
            if (min > Math.abs(gap)) {
                min = Math.abs(gap);
                answers[0] = solutions[start];
                answers[1] = solutions[end];

                if (gap == 0)
                    break;
            }

            if (gap < 0) {
                start++;
            } else end--;
        }

        StringBuilder sb = new StringBuilder().append(answers[0]).append(" ").append(answers[1]);
        System.out.println(sb);
    }
}
