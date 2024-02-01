import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * [S3] 백준 15655 N과 M (6)
 * 메모리 : 11556KB
 * 시간 : 96ms
 * 코드 길이 : 1125B
 * 
 * @author 김민주
 * @see <a href="https://www.acmicpc.net/problem/15655">
 */
public class Main {
	// 입력받은 값 정렬
	static int[] value;
	// 결과값 저장
	static int[] result;
	// 출력값 저장
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = parseInt(st.nextToken());
		int m = parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		value = new int[n];
		for (int i = 0; i < n; i++) {
			value[i] = parseInt(st.nextToken());
		}
		// 배열을 입력받아서 오름차순으로 정렬
		Arrays.sort(value);

		result = new int[m];
		// 메서드 실행
		solution(n, m, 0, 0);
		// 결과 출력
		System.out.println(sb);
	}

	// 첫 시작하는 인덱스를 파라미터로 전달 - 중복 방지, 오름차순으로 조합
	public static void solution(int n, int m, int depth, int index) {
		// 결과
		if (depth == m) {
			for (int number : result) {
				sb.append(number).append(' ');
			}
			sb.append('\n');
			return;
		}

		for (int i = index; i < n; i++) {
			result[depth] = value[i];
			// 지금 숫자와 중복이 되지 않도록 index + 1
			solution(n, m, depth + 1, i + 1);
		}
	}
}
