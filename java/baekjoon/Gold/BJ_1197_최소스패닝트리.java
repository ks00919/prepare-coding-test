import static java.lang.Integer.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * [G4] 백준 1197 최소 스패닝 트리
 * 메모리 : 48032KB
 * 시간 : 596ms
 * 코드 길이 : 1920B
 * 
 * @author 김민주
 * @see <a href="https://www.acmicpc.net/problem/1197">
 */
class Main {

    // 간선 그래프를 위한 간선 클래스
    static class Edge implements Comparable<Edge> {
        int from;
        int to;
        int weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        // 가중치를 기준으로 오름차순으로 정렬되도록 Comparable 구현
        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }

    static int V, E;
    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = parseInt(st.nextToken());
        E = parseInt(st.nextToken());

        Edge[] list = new Edge[E];
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());

            int from = parseInt(st.nextToken());
            int to = parseInt(st.nextToken());
            int weight = parseInt(st.nextToken());
            // 간선 정보 저장
            list[i] = new Edge(from, to, weight);
        }

        // 부모 노드 번호 저장
        parents = new int[V + 1];
        // 가중치를 기준으로 정렬
        Arrays.sort(list);

        long weight = 0l;

        for (Edge e : list) {
            // 합집합 연산이 실패했다면 사이클 발생!!
            if (!union(e.from, e.to))
                continue;

            // 가중치 더하기
            weight += e.weight;
        }
        // 가중치 출력
        System.out.println(weight);
    }

    static boolean union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA == rootB)
            return false;

        parents[rootB] = rootA;
        return true;
    }

    static int find(int x) {
        if (parents[x] == x || parents[x] == 0)
            return x;
        return parents[x] = find(parents[x]);
    }

}