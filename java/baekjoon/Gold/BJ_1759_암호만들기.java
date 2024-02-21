import static java.lang.Integer.*;

import java.util.*;
import java.io.*;

/**
 * [G5] 백준 1759 암호 만들기
 * 메모리 : 11984KB
 * 시간 : 84ms
 * 코드 길이 : 1575B
 * 
 * @author 김민주
 * @see <a href="https://www.acmicpc.net/problem/1759">
 */
class Main {

    static int L, C;
    static int[] alphabet = new int[26];
    static char[] selected;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = parseInt(st.nextToken());
        C = parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        selected = new char[L];

        // 입력받은 문자의 카운트 증가
        for (int i = 0; i < C; i++) {
            alphabet[st.nextToken().charAt(0) - 'a']++;
        }

        dfs(0, 0);

        System.out.println(sb);
    }

    public static void dfs(int depth, int index) {
        // 문자열 L개를 선택했다면 모음의 개수가 1개인지, 자음의 개수가 두개인지 체크
        // 조건에 맞는 문자열일 때 결과에 추가
        if (depth == L) {
            int count = getMo();
            if (getMo() > 0 && L - count > 1)
                sb.append(selected).append("\n");
            return;
        }

        // 사전순으로 선택해야하기 때문에 index를 파라미터로 넣기
        // 백트래킹 사용
        for (int i = index; i < 26; i++) {
            if (alphabet[i] > 0) {
                alphabet[i]--;
                selected[depth] = (char) ('a' + i);
                dfs(depth + 1, i + 1);
                alphabet[i]++;
            }
        }
    }

    // 선택 문자열에 포함된 모음의 개수 세기
    public static int getMo() {
        int count = 0;

        for (int i = 0; i < L; i++) {
            if (selected[i] == 'a' || selected[i] == 'e' || selected[i] == 'i' || selected[i] == 'o'
                    || selected[i] == 'u')
                count++;
        }
        return count;
    }

}