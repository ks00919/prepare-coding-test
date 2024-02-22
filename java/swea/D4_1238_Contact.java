import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * [D4] SWEA 1238 [S/W 문제해결 기본] 10일차 - Contact
 * 메모리 : 19664KB
 * 실행시간 : 119ms
 * 코드 길이 : 1665
 * 
 * @author 김민주
 */
public class Solution {

	// 우선순위 큐 사용해서 너비우선 탐색 풀이
	// 연락 가능한 마지막 차수 중에 가장 큰 숫자 출력
	static class Node implements Comparable<Node> {
		int number;
		int degree;

		public Node(int number, int degree) {
			this.number = number;
			this.degree = degree;
		}

		// 우선순위 큐 사용을 위해 Comparable 인터페이스 구현
		// 차수가 다르면 차수가 작은 것 부터, 차수가 같다면 숫자가 더 작은 것을 우선적으로 poll
		@Override
		public int compareTo(Node o) {
			return degree - o.degree == 0 ? number - o.number : degree - o.degree;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for (int tc = 1; tc <= 10; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int n = parseInt(st.nextToken());
			int v = parseInt(st.nextToken());

			// 인접행렬 사용(넘버링 최대 숫자가 100)
			int[][] people = new int[101][101];
			boolean[] visited = new boolean[101];

			st = new StringTokenizer(br.readLine());

			// 방향 그래프
			for (int i = 0; i < n / 2; i++) {
				int from = parseInt(st.nextToken());
				int to = parseInt(st.nextToken());

				if (from == to)
					continue;

				people[from][to] = 1;
			}
			
			// 우선순위 큐 사용 - 같은 차수 중에서 작은 번호부터 탐색
			Queue<Node> q = new PriorityQueue<>();
			q.offer(new Node(v, 0));
			visited[v] = true;

			Node person = q.peek();
			while (!q.isEmpty()) {
				person = q.poll();
				
				// 인접노드 확인해서 큐에 추가
				for (int i = 1; i < 101; i++) {
					if (people[person.number][i] == 1 && !visited[i]) {
						visited[i] = true;
						q.offer(new Node(i, person.degree + 1));
					}
				}
			}
			
			// 마지막으로 연락받은 사람 번호 출력
			sb.append(String.format("#%d %d%n", tc, person.number));
		}
		System.out.println(sb);
	}
}
