import static java.lang.Integer.*;
import java.io.*;
import java.util.*;

/**
 * [G4] 백준 14925 목장 건설하기
 * 메모리 : 73244KB
 * 시간 : 412ms
 * 코드 길이 : 807B
 * 
 * @author 김민주
 * @see <a href="https://www.acmicpc.net/problem/14925"/>
 */
public class Main {

	// dp 점화식으로 해결할 수 있었던 문제!
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int M = parseInt(st.nextToken());
		int N = parseInt(st.nextToken());

		int[][] map = new int[M + 1][N + 1];
		int max = 0;
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				map[i][j] = parseInt(st.nextToken());

				if (map[i][j] != 0) {
					map[i][j] = 0;
					continue;
				}

				map[i][j] = Math.min(Math.min(map[i - 1][j], map[i][j - 1]), map[i - 1][j - 1]) + 1;
				max = Math.max(max, map[i][j]);
			}
		}
		System.out.println(max);
	}
}
