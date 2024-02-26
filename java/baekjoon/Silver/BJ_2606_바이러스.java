import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * [S3] 백준 2606 바이러스
 * 메모리 : 11736KB
 * 시간 : 80ms
 * 코드 길이 : 1076B
 * 
 * @author 김민주
 * @see <a href="https://www.acmicpc.net/problem/2606">
**/
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = parseInt(br.readLine());
		int C = parseInt(br.readLine());

    // 인접 행렬 사용
		int[][] map = new int[N + 1][N + 1];

		for (int i = 0; i < C; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int from = parseInt(st.nextToken());
			int to = parseInt(st.nextToken());

			map[from][to] = 1;
			map[to][from] = 1;
		}

    // 그래프 너비 우선 순회
		Queue<Integer> q = new ArrayDeque<>();
		q.add(1);
		int count = 0;
		boolean[] visited = new boolean[N + 1];
		visited[1] = true;

		while (!q.isEmpty()) {
			int com = q.poll();

			for (int i = 1; i <= N; i++) {
				if (!visited[i] && map[com][i] == 1) {
					visited[i] = true;
					q.add(i);
					count++;
				}
			}
		}

		System.out.println(count);
	}
}
