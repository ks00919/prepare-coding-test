import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * [G3] 백준 2623 음악프로그램
 * 메모리 : 12300KB
 * 시간 : 104ms
 * 코드 길이 : 1610B
 * 
 * @author 김민주
 * @see <a href="https://www.acmicpc.net/problem/2623">
 */
public class Main {

	// 위상 정렬로 풀이
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = parseInt(st.nextToken());
		int M = parseInt(st.nextToken());

		List<Integer>[] singers = new ArrayList[N + 1];
		int[] indegree = new int[N + 1];
		List<Integer> list = new ArrayList<>();

		// 피디가 정한 순서 입력 받기
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			// 다음에 나올 가수 수 토큰 넘기기
			st.nextToken();
			// 이전 순서
			int prev = parseInt(st.nextToken());

			while (st.hasMoreTokens()) {
				int next = parseInt(st.nextToken());
				// 다음 가수 입력 차수 1 증가
				indegree[next]++;

				// 연결 노드 없어서 list가 null이라면 생성
				if (singers[prev] == null)
					singers[prev] = new ArrayList<>();
				
				// 연결 노드 추가(방향 그래프)
				singers[prev].add(next);
				prev = next;
			}

		}
		
		// 입력 차수가 0인 노드들 큐에 추가
		Queue<Integer> q = new ArrayDeque<>();
		for (int i = 1; i <= N; i++) {
			if (indegree[i] == 0)
				q.add(i);
		}
		
		// 큐가 빌 때까지 반복
		while (!q.isEmpty()) {
			int singer = q.poll();
			
			// 리스트에 추가
			list.add(singer);
			
			// 연결 노드가 없다면 넘기기
			if (singers[singer] == null)
				continue;

			// 간선을 제거하고 입력차수가 0인 노드 추가
			for (int number : singers[singer]) {
				if (--indegree[number] == 0)
					q.add(number);
			}
		}

		// 만약 사이클이 있었다면 N 크기의 리스트가 만들어지지 않기 때문에 0 출력
		if (list.size() != N) {
			System.out.println(0);
		} else {
			// 만들어진 결과 출력
			StringBuilder sb = new StringBuilder();
			for (int singer : list) {
				sb.append(singer).append("\n");
			}
			System.out.println(sb);
		}
	}

}
