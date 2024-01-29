import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * [S3] 백준 15651 N과 M (3)
 * 메모리 : 111872KB 
 * 시간 : 328ms 
 * 코드 길이 : 986B
 * 
 * @author 김민주
 * @see <a href="https://www.acmicpc.net/problem/15651">
 */
public class Main {

	// 결과 임시 저장 배열
	static int[] result;
	// 출력 결과 저장 Builder
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		// 1부터 N까지 자연수
		int n = Integer.parseInt(st.nextToken());
		// N개 중에 3개 선택
		int m = Integer.parseInt(st.nextToken());

		result = new int[m];

		// 메서드 호출
		solution(n, m, 0);
		// 결과 출력
		System.out.println(sb);
	}

	public static void solution(int n, int m, int depth) {
		// 만약 임시 저장 배열에 값을 다 저장했다면, 문자열 변환
		if (m == depth) {
			for (int number : result) {
				sb.append(number).append(' ');
			}
			sb.append('\n');
			return;
		}

		for (int i = 0; i < n; i++) {
			// 같은 숫자 중복 허용
			result[depth] = i + 1;
			solution(n, m, depth + 1);
		}
	}
}
