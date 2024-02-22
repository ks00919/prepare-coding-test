import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * [D4] SWEA 3124 최소 스패닝 트리
 * 메모리 : 115524KB
 * 실행시간 : 1993ms
 * 코드 길이 : 1832
 * 
 * @author 김민주
 */
public class Solution {

	// 크루스칼 알고리즘을 사용해서 최소 스패닝 트리 계산
	// 문제에서 제시하는 범위를 잘 읽고 타입을 잘 선택해야 한다..
	
	// 간선 클래스
	static class Edge implements Comparable<Edge> {
		int from, to, weight;

		public Edge(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
		
		// 정렬하기 위해서 Comparable 인터페이스를 구현
		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight;
		}
	}

	static int V, E;
	static Edge[] edgeList;
	static int[] parents;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {

			StringTokenizer st = new StringTokenizer(br.readLine());
			V = parseInt(st.nextToken());
			E = parseInt(st.nextToken());
			
			edgeList = new Edge[E];
			parents = new int[V + 1];

			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());

				int from = parseInt(st.nextToken());
				int to = parseInt(st.nextToken());
				int weight = parseInt(st.nextToken());
				
				// 리스트에 간선 저장
				edgeList[i] = new Edge(from, to, weight);
			}

			// 가중치를 오름차순으로 저장
			Arrays.sort(edgeList);

			// 합계를 int 타입으로 설정하면 최악의 경우에 오버플로우가 발생한다!!
			// 간선의 개수 20_0000개일 때 가중치가 100_0000...
			long weight = 0l;
			for (Edge edge : edgeList) {
				// 두 연결점의 대표 노드가 같다면 사이클이 발생하기 때문에 가중치 합산X
				if (!union(edge.from, edge.to))
					continue;
				weight += edge.weight;
			}
			
			// 최소 가중치 출력
			sb.append(String.format("#%d ", tc)).append(weight).append("\n");
		}

		System.out.println(sb);
	}

	// 합집합 연산
	public static boolean union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);

		if (rootA == rootB)
			return false;
		
		// 루트 연결
		parents[rootA] = rootB;
		return true;
	}

	// 대표 노드 찾기, 최적화 진행
	public static int find(int x) {
		if (parents[x] == 0 || parents[x] == x)
			return x;
		return parents[x] = find(parents[x]);
	}

}
