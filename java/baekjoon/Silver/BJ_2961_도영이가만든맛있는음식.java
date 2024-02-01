import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * [S2] 백준 2961 도영이가 만든 맛있는 음식
 * 메모리 : 11476KB
 * 시간 : 76ms
 * 코드 길이 : 1039B
 * 
 * @author 김민주
 * @see <a href="https://www.acmicpc.net/problem/2961">
 */
class Main {

	static int result;
	static int[][] food;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = parseInt(br.readLine());
		StringTokenizer st;
		food = new int[n][2];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			food[i][0] = parseInt(st.nextToken());
			food[i][1] = parseInt(st.nextToken());
		}
		
		// 초기값으로 첫번째 재료만 들어갔을 때 맛 저장
		result = Math.abs(food[0][0] - food[0][1]);

		solution(n, 0, 1, 0);
		System.out.println(result);
	}

	public static void solution(int n, int depth, int sour, int bitter) {
		// 전체 수를 고려했을 때
		if (depth == n) {
			int value = Math.abs(sour - bitter);
			// 신맛과 쓴맛이 초기값이 아니고 저장된 값보다 작을때 값 갱신
			if ((sour | bitter) != 1 && result > value) {
				result = value;
			}
			return;
		}
		
		// 지금 값 포함
		solution(n, depth + 1, sour * food[depth][0], bitter + food[depth][1]);
		// 지금 값 미포함
		solution(n, depth + 1, sour, bitter);
	}
}
