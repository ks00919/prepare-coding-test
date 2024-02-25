import static java.lang.Double.*;
import static java.lang.Integer.*;
import java.io.*;
import java.util.Queue;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * [D4] SWEA 1251 [S/W 문제해결 응용] 4일차 - 하나로
 * 메모리 : 86828KB
 * 실행시간 : 1004ms
 * 코드 길이 : 2630
 * 
 * @author 김민주
 */
class Solution {

    static double E;
    static int[] xs;
    static int[] ys;
    static int[] parents;

    // 간선 클래스
    static class Edge implements Comparable<Edge> {
        int from;
        int to;
        double weight;

        public Edge(int from, int to, double weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Solution.Edge o) {
            return Double.compare(this.weight, o.weight);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            int N = parseInt(br.readLine());

            xs = new int[N];
            ys = new int[N];
            make(N);

            StringTokenizer st1 = new StringTokenizer(br.readLine());
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                xs[i] = parseInt(st1.nextToken());
                ys[i] = parseInt(st2.nextToken());
            }

            E = parseDouble(br.readLine());

            // 우선순위 큐 사용
            Queue<Edge> q = new PriorityQueue<>();
            for (int i = 0; i < N; i++) {
                for (int j = i + 1; j < N; j++) {
                    double distance = Math.pow(xs[i] - xs[j], 2) + Math.pow(ys[i] - ys[j], 2);
                    // 세율 * 거리 제곱을 가중치로 하는 간선
                    q.add(new Edge(i, j, E * distance));
                }
            }

            // 최소 신장 트리
            // 최소 환경 부담금으로 하는 모든 섬을 연결하는 값
            double sum = 0;
            while (!q.isEmpty()) {
                Edge edge = q.poll();

                if (!union(edge.from, edge.to)) // 사이클 발생 !!
                    continue;

                sum += edge.weight;
            }

            sb.append(String.format("#%d %.0f%n", tc, sum));
        }
        System.out.println(sb);
    }

    public static void make(int N) {
        parents = new int[N];
        for (int i = 0; i < N; i++) {
            parents[i] = i;
        }
    }

    public static boolean union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA == rootB)
            return false;

        parents[rootB] = rootA;
        return true;
    }

    public static int find(int a) {
        if (parents[a] == a)
            return a;
        return parents[a] = find(parents[a]);
    }
}