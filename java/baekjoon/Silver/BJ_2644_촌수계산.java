import static java.lang.Integer.*;

import java.io.*;
import java.util.*;

/**
 * [S2] 백준 2644 촌수계산
 * 메모리 : 11708KB
 * 시간 : 80ms
 * 코드 길이 : 1549B
 */
class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = parseInt(st.nextToken());
        int b = parseInt(st.nextToken());

        int m = parseInt(br.readLine());

        // 입력범위만큼 미리 배열 생성
        List<Integer>[] list = new ArrayList[101];
        int[] visited = new int[101];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int parent = parseInt(st.nextToken());
            int child = parseInt(st.nextToken());

            // 무방향 그래프이므로 양쪽에 모두 add, 만약 리스트가 없을 때 생성
            if (list[child] == null)
                list[child] = new ArrayList<>();

            if (list[parent] == null)
                list[parent] = new ArrayList<>();

            list[child].add(parent);
            list[parent].add(child);
        }

        // 시작 노드 큐에 초기화
        Queue<Integer> q = new ArrayDeque<>();
        q.add(a);

        while (!q.isEmpty()) {
            int person = q.poll();

            // 찾았다면 반복문 종료
            if (person == b)
                break;

            // 연결된 노드가 없다면 continue
            if (list[person] == null)
                continue;

            for (int p : list[person]) {
                if (visited[p] == 0) {
                    q.add(p);
                    // 촌수 계산
                    visited[p] = visited[person] + 1;
                }
            }
        }

        // 촌수가 0이라면 -1 출력, 아니라면 촌수 계산 출력
        System.out.println(visited[b] == 0 ? -1 : visited[b]);
    }

}