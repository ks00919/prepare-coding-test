import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * [S3] 백준 11659 구간 합 구하기 4
 * 메모리 : 60200KB
 * 시간 : 612ms
 * 코드 길이 : 1031B
 * 
 * @author 김민주
 * @see <a href="https://www.acmicpc.net/problem/11659">
 */
class Main {
	// 누적합을 사용하지 않고 반복문으로 풀게 되면 시간 초과가 뜬다!
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int n = parseInt(st.nextToken());
		int m = parseInt(st.nextToken());

		// 1 ~ i까지의 누적합 저장
		int[] array = new int[n];
		st = new StringTokenizer(br.readLine(), " ");
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += parseInt(st.nextToken());
			array[i] = sum;
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < m; i++) {
			// 구간 입력받기
			st = new StringTokenizer(br.readLine(), " ");
			int start = parseInt(st.nextToken());
			int end = parseInt(st.nextToken());
			// IndexOutOfBoundsException 방지
			if (start == 1) {
				sb.append(array[end - 1]).append('\n');
			} else {
				// 1~end까지의 합에서 start-1까지의 합 빼서 구간합 구하기
				sb.append(array[end - 1] - array[start - 2]).append('\n');
			}
		}
		System.out.println(sb);
	}
}
