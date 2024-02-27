import static java.lang.Integer.*;

import java.util.*;
import java.io.*;

/**
 * [G4] 백준 1753 최단경로
 * 메모리 : 126632KB
 * 시간 : 816ms
 * 코드 길이 : 2242B
 * 
 * @author 김민주
 * @see <a href="https://www.acmicpc.net/problem/1753">
 */
public class Main {

    // 가중치와 가리키는 노드를 저장하는 클래스
    static class Node implements Comparable<Node> {
        int to;
        int weight;

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }

    // 다익스트라 알고리즘
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = parseInt(st.nextToken());
        int E = parseInt(st.nextToken());

        int K = parseInt(br.readLine());

        // 인접 리스트 사용
        List<List<Node>> list = new ArrayList<>(V + 1);

        for (int i = 0; i <= V; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int from = parseInt(st.nextToken());
            int to = parseInt(st.nextToken());
            int weight = parseInt(st.nextToken());

            // 방향 그래프
            list.get(from).add(new Node(to, weight));
        }

        Queue<Node> q = new PriorityQueue<>();
        q.add(new Node(K, 0));

        boolean[] visited = new boolean[V + 1];
        // dp
        int[] distance = new int[V + 1];
        // 거리를 최대로 초기화, 첫 노드만 0으로
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[K] = 0;

        while (!q.isEmpty()) {
            Node curr = q.poll();
            // 만약 방문한 노드(이미 경로를 확정한 노드)라면 넘기기
            if (visited[curr.to])
                continue;

            visited[curr.to] = true;

            for (Node n : list.get(curr.to)) {
                // 이전 경로보다 새 경로가 더 최소 거리라면 갱신
                if (distance[n.to] > distance[curr.to] + n.weight)
                    distance[n.to] = distance[curr.to] + n.weight;

                // 우선 순위 큐에 넣기
                q.add(new Node(n.to, distance[n.to]));
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= V; i++) {
            if (i == K)
                sb.append(0).append("\n");
            else if (distance[i] == Integer.MAX_VALUE)
                sb.append("INF\n");
            else
                sb.append(distance[i]).append("\n");
        }
        System.out.println(sb);
    }

}
