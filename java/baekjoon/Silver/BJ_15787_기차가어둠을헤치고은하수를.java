import static java.lang.Integer.*;

import java.util.*;
import java.io.*;

/**
 * [S2] 백준 15787 기차가 어둠을 헤치고 은하수를
 * 메모리 : 37656KB
 * 시간 : 336ms
 * 코드 길이 : 1207B
 * 
 * @author 김민주
 * @see <a href="https://www.acmicpc.net/problem/15787">
 */
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = parseInt(st.nextToken());
        int m = parseInt(st.nextToken());

        int[] train = new int[n];

        // m개 명령 실행
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int order = parseInt(st.nextToken());
            int index = parseInt(st.nextToken()) - 1;
            if (order == 1) {
                // index번째 비트 or 연산(승객 태우기)
                train[index] |= 1 << (parseInt(st.nextToken()) - 1);
            } else if (order == 2) {
                // index번째 비트 and 연산(승객 하차)
                train[index] &= ~(1 << (parseInt(st.nextToken()) - 1));
            } else if (order == 3) {
                // 20번째 승객 내리고 이동
                train[index] = (train[index] & ~(1 << 19)) << 1;
            } else {
                // 1번째 승객 내리고 이동
                train[index] = (train[index] & ~1) >> 1;
            }
        }

        // 중복 제거
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(train[i]);
        }
        // 결과 출력
        System.out.println(set.size());
    }
}
