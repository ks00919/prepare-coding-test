import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * [G4] 백준 1987 알파벳
 * 메모리 : 12268KB
 * 시간 : 1020ms
 * 코드 길이 : 1302B
 * 
 * @author 김민주
 * @see <a href="https://www.acmicpc.net/problem/1987">
 */
class Main {

	static int R, C;
	static char[][] alphabet;
	// 알파벳의 개수만큼 배열을 만들어서 사용했는지 체크
	static int[] isUsed = new int[26];
	static int[][] idx = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		R = parseInt(st.nextToken());
		C = parseInt(st.nextToken());

		alphabet = new char[R][C];
		for (int i = 0; i < R; i++) {
			String input = br.readLine();
			for (int j = 0; j < C; j++) {
				alphabet[i][j] = input.charAt(j);
			}
		}

		// 배열의 크기가 1일 때에는 dfs에서 사방탐색이 진행되지 않기 때문에 시작점이 카운트에 들어가지 않는다!!
		if (R == C && R == 1) {
			System.out.println(1);
		} else {
			// 배열의 크기가 1 이상 일때 dfs 탐색
			dfs(0, 0, 0);
			System.out.println(max);
		}
	}

	static int max;

	public static void dfs(int count, int x, int y) {
		int c = alphabet[x][y] - 'A';
		
		// 사용한 문자열을 만났다면 지금까지의 depth와 최대 depth 비교 후 갱신
		if (isUsed[c] != 0) {
			max = Math.max(max, count);
			return;
		}

		isUsed[alphabet[x][y] - 'A']++;
		// 위아래양옆 4방탐색
		for (int i = 0; i < 4; i++) {
			int dx = x + idx[i][0];
			int dy = y + idx[i][1];

			if (dx < 0 || dy < 0 || dx >= R || dy >= C)
				continue;

			dfs(count + 1, dx, dy);
		}
		// 사방탐색을 한 후에는 선택을 취소
		isUsed[c]--;
	}
}
