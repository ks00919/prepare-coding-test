import static java.lang.Integer.*;
import java.io.*;
import java.util.*;

/**
 * [S2] 백준 5567 결혼식
 * 메모리 : 17320KB
 * 시간 : 136ms
 * 코드 길이 : 1157B
 * 
 * @author 김민주
 * @see <a href="https://www.acmicpc.net/problem/5567"/>
 */
public class Main {

	static class Pair {
		int number;
		int depth;

		public Pair(int number, int depth) {
			super();
			this.number = number;
			this.depth = depth;
		}

	}
	
	// 단순 bfs

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = parseInt(br.readLine());
		int m = parseInt(br.readLine());

		int[][] map = new int[n + 1][n + 1];
		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = parseInt(st.nextToken());
			int b = parseInt(st.nextToken());

			map[a][b] = 1;
			map[b][a] = 1;
		}

		Queue<Pair> q = new ArrayDeque<>();
		q.add(new Pair(1, 0));

		int count = 0;
		boolean[] visited = new boolean[n + 1];
		visited[1] = true;
		while (!q.isEmpty()) {
			Pair curr = q.poll();
			if (curr.depth >= 2)
				continue;

			for (int i = 1; i <= n; i++) {
				if (visited[i] || map[curr.number][i] == 0)
					continue;
				visited[i] = true;
				count++;
				q.add(new Pair(i, curr.depth + 1));
			}
		}

		System.out.println(count);
	}
}
