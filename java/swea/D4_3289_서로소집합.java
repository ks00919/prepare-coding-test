import static java.lang.Integer.parseInt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * [D4] SWEA 3289 서로소 집합
 * 메모리 : 103768KB
 * 실행시간 : 468ms
 * 코드 길이 : 1371
 * 
 * @author 김민주
 */
public class Solution {

	static int[] parent;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");

			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = parseInt(st.nextToken());
			int m = parseInt(st.nextToken());

			parent = new int[n + 1];

			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int order = parseInt(st.nextToken());

				if (order == 0) {
					// 0이라면 합집합 연산
					union(parseInt(st.nextToken()), parseInt(st.nextToken()));
				} else if (order == 1) {
					// 1이라면 입력 숫자가 포함된 대표 노드끼리 비교해서 같다면 같은 집합에 있는 것!
					if (find(parseInt(st.nextToken())) == find(parseInt(st.nextToken())))
						sb.append(1);
					else
						sb.append(0);
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	// 서로의 대표 노드를 찾아서 루트를 루트 1에 연결
	public static void union(int a, int b) {
		int root1 = find(a);
		int root2 = find(b);

		parent[root2] = root1;
	}

	// 집합의 대표 노드 찾기
	// path Compression을 적용하여 대표 노드 찾기
	public static int find(int node) {
		if (parent[node] == 0 || parent[node] == node)
			return node;
		return parent[node] = find(parent[node]);
	}
}
