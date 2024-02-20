import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * [S2] 백준 2512 예산
 * 메모리 : 14140KB
 * 시간 : 124ms
 * 코드 길이 : 1055B
 * 
 * @author 김민주
 * @see <a href="https://www.acmicpc.net/problem/2512">
 */
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = parseInt(br.readLine());

		int[] budgets = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		int sum = 0;
		for (int i = 0; i < N; i++) {
			budgets[i] = parseInt(st.nextToken());
			sum += budgets[i];
		}
		int budget = parseInt(br.readLine());
		// 입력받은 예산들 정렬
		Arrays.sort(budgets);

		// 만약 모든 예산을 범위 내에서 줄 수 있다면 제일 큰 예산 출력 후 프로그램 종료
		if (budget == sum) {
			System.out.println(budgets[N - 1]);
			System.exit(0);
		}

		// 시작, 끝
		int min = 0;
		int max = budgets[N - 1];

		// 이진 탐색
		while (min <= max) {
			sum = 0;
			// 가장 큰 제한값과 가장 작은 제한값의 중간값을 제한으로 생각
			int limit = (min + max) / 2;

			for (int i = 0; i < N; i++) {
				// 제한보다 작다면 예산 지급, 아니면 제한만큼 지급
				sum += Math.min(limit, budgets[i]);
			}

			// 지급한 예산의 합이 예산 총액보다 작다면 오른쪽 탐색(최소 크기 늘리기)
			if (sum <= budget) {
				min = limit + 1;
			} else {
				// 크다면 왼쪽 탐색(최대 크기 줄이기)
				max = limit - 1;
			}
		}

		System.out.println(max);
	}
}
