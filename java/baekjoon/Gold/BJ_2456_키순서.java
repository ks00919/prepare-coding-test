import static java.lang.Integer.*;

import java.io.*;
import java.util.*;

/**
 * [G4] 백준 2456 키 순서
 * 메모리 : 41812KB
 * 시간 : 596ms
 * 코드 길이 : 1470B
 * 
 * @author 김민주
 * @see <a href="https://www.acmicpc.net/problem/2458"/>
 */
public class Main {

	static int N;
	static int[] in;
	static int[] out;
	static List<Integer>[] students;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = parseInt(st.nextToken());
		int M = parseInt(st.nextToken());

		students = new ArrayList[N + 1];

		for (int i = 0; i < N + 1; i++) {
			students[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = parseInt(st.nextToken());
			int b = parseInt(st.nextToken());

			students[a].add(b);
		}

		in = new int[N + 1];
		out = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			bfs(i);
		}

		int result = 0;
		int size = N - 1;
		for (int i = 1; i <= N; i++) {
			if (in[i] + out[i] == size)
				result++;
		}

		System.out.println(result);
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

				in[student]++;
				q.add(student);
			}
		}

		for (int i = 1; i <= N; i++) {
			if (index == i || !visited[i])
				continue;
			out[index]++;
		}
	}

}
