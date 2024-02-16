import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * [G2] 백준 3109 빵집
 * 메모리 : 31848KB
 * 시간 : 308ms
 * 코드 길이 : 1169B
 * 
 * @author 김민주
 * @see <a href="https://www.acmicpc.net/problem/3109">
 */
public class Main {

	static boolean[][] map;
	static int R;
	static int C;
	static int count;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = parseInt(st.nextToken());
		C = parseInt(st.nextToken());

		map = new boolean[R][C];
		for (int i = 0; i < R; i++) {
			String input = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = input.charAt(j) == '.';
			}
		}

		// 시작점을 위부터 아래로 내려가며 경로 탐색하는 것이 최선이라고 생각하고 반복(그리디적 선택)
		for (int i = 0; i < R; i++) {
			if (dfs(i, 0))
				count++;
		}
		System.out.println(count);
	}

	// boolean 변수로 경로를 체크하고 안되는 경로는 다시 boolean 해제하니 시간초과 발생
	public static boolean dfs(int x, int y) {
		// 현재 위치 방문 체크
		// 만약 다른 경로로 현재 위치를 다시 오더라도 더이상 진행할 수 없기 때문에 방문체크 해제X
		map[x][y] = false;
		
		// 지도의 끝까지 갔다면 경로 완성
		if (y == C - 1) {
			return true;
		}

		// 오른쪽 위
		if (x > 0 && map[x - 1][y + 1]) {
			// 만약 현재 위치가 경로를 완성할 수 있다면 true 반환
			if (dfs(x - 1, y + 1))
				return true;
		}
		
		// 오른쪽
		if (map[x][y + 1]) {
			if (dfs(x, y + 1))
				return true;
		}

		// 오른쪽 아래
		if (x + 1 < R && map[x + 1][y + 1]) {
			if (dfs(x + 1, y + 1))
				return true;
		}

		return false;
	}
}
