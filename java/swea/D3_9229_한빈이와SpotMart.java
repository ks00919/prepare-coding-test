import static java.lang.Integer.*;

import java.util.*;
import java.io.*;

/**
 * [D3] SWEA 9229 한빈이와 Spot Mart
 * 메모리 : 24264KB
 * 실행시간 : 196ms
 * 코드길이 : 1652
 * 
 * @author 김민주
 */
class Solution {

    // 과자 무게
    static int[] weight;
    // 선택한 과자 무게 저장
    static int[] select = new int[2];
    // 전체 선택할 수 있는 무게 차이
    static int min;
    // 한 경우라도 들 수 있는 과자를 찾았는지
    static boolean possible = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = parseInt(br.readLine());
        // 입력된 테스트 케이스 개수만큼
        for (int test = 1; test <= tc; test++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            // 처음 값 초기화
            possible = false;
            min = Integer.MAX_VALUE;

            // 입력
            int n = parseInt(st.nextToken());
            int m = parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            weight = new int[n];
            for (int i = 0; i < n; i++) {
                weight[i] = parseInt(st.nextToken());
            }
            // 메서드 호출
            solution(0, n, m, 0);
            // 찾았다면 최대 무게에서 최소 차이 빼서 출력
            if (possible) {
                sb.append(String.format("#%d %d%n", test, m - min));
            } else { // 못 찾았다면 -1
                sb.append(String.format("#%d %d%n", test, -1));
            }
        }

        System.out.println(sb);
    }

    public static void solution(int depth, int n, int m, int index) {
        // 과자 두개를 골랐을 때 최대 무게를 넘겼다면 그대로 return
        // 무게 합계가 최대 무게보다 작을때 최소 차이보다 작다면 저장
        if (depth == 2) {
            int sum = m - (select[0] + select[1]);
            if (sum >= 0 && sum < min) {
                min = sum;
                possible = true;
            }
            return;
        }

        for (int i = index; i < n; i++) {
            select[depth] = weight[i];
            solution(depth + 1, n, m, i + 1);
        }
    }
}
