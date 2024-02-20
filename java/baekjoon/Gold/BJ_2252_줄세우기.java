import static java.lang.Integer.*;

import java.util.*;
import java.io.*;

/**
 * [G3] 백준 2252 줄 세우기
 * 메모리 : 47184KB
 * 시간 : 400ms
 * 코드 길이 : 1909B
 * 
 * @author 김민주
 * @see <a href="https://www.acmicpc.net/problem/2252">
 */
class Main {

    // 노드 클래스
    static class Node {
        int value;
        // 현재 노드의 간선에 연결된 노드들
        List<Integer> list;

        public Node(int value) {
            this.value = value;
            list = new ArrayList<>();
        }
    }

    // 위상정렬 사용
    // 방향 그래프에서 간선으로 주어진 정점간 선후관계를 위배하지 않도록 나열한 정렬
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = parseInt(st.nextToken());
        int M = parseInt(st.nextToken());

        // 만약 학생이 한명이라면 1 출력 후 종료
        if (N == 1) {
            System.out.println(1);
            System.exit(0);
        }

        Node[] students = new Node[N + 1];
        int[] indegree = new int[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int left = parseInt(st.nextToken());
            int right = parseInt(st.nextToken());

            if (students[left] == null) {
                students[left] = new Node(left);
            }

            // left노드의 리스트에 인접 노드 추가
            students[left].list.add(right);
            // right 노드를 가리키고 있는 간선의 개수 1 증가
            indegree[right]++;
        }

        Queue<Integer> q = new ArrayDeque<>();
        // 진입 차수 0인 노드들만 큐에 추가
        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0)
                q.add(i);
        }

        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            int node = q.poll();
            sb.append(node).append(" ");

            // 연결된 자식 노드가 없다면 넘기기
            if (students[node] == null)
                continue;

            // 연결된 자식 노드들 순회
            for (int number : students[node].list) {
                // 간선 제거(indegree 1 감소) 후 진입 차수가 0이라면 큐에 추가
                if (--indegree[number] == 0) {
                    if (students[number] == null) {
                        sb.append(number).append(" ");
                        continue;
                    }
                    q.add(number);
                }
            }
        }

        System.out.println(sb);
    }

}