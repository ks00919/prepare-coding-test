import static java.lang.Integer.*;

import java.io.*;
import java.util.*;

/**
 * [D4] SWEA 5643 [Professional] 키 순서
 * 메모리 : 105860KB
 * 실행시간 : 1077ms
 * 코드 길이 : 1712
 * 
 * @author 김민주
 */
public class Solution {

	static int N;
	static int[] in;
	static int[] out;
	static List<Integer>[] students;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = parseInt(br.readLine());
			int M = parseInt(br.readLine());

			students = new ArrayList[N + 1];

			for (int i = 0; i < N + 1; i++) {
				students[i] = new ArrayList<>();
			}

			for (int i = 0; i < M; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int a = parseInt(st.nextToken());
				int b = parseInt(st.nextToken());

				students[a].add(b);
			}
			
			in = new int[N + 1];
			out = new int[N + 1];
			
			// 모든 학생들을 시작점으로 bfs하기
			for (int i = 1; i <= N; i++) {
				bfs(i);
			}
			 
			// 진입차수와 방문하는 노드의 수 합이 본인을 제외한 학생들 수이면 전체 순서를 알 수 있는 학생이다!
			int result = 0;
			int size = N - 1;
			for (int i = 1; i <= N; i++) {
				if (in[i] + out[i] == size)
					result++;
			}
			
			sb.append("#").append(tc).append(" ").append(result).append("\n");
		}

		System.out.println(sb);
	}

	public static void bfs(int index) {
		boolean[] visited = new boolean[N + 1];
		Queue<Integer> q = new ArrayDeque<>();
		q.add(index);
		visited[index] = true;

		while (!q.isEmpty()) {
			int curr = q.poll();
			for (int student : students[curr]) {
				if (visited[student])
					continue;
				visited[student] = true;

				// 진입차수 카운트하기
				in[student]++;
				q.add(student);
			}
		}
		
		// 방문한 노드 수 세기
		for (int i = 1; i <= N; i++) {
			if (index == i || !visited[i])
				continue;
			out[index]++;
		}
	}

}
