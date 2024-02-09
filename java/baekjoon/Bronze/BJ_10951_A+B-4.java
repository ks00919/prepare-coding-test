import static java.lang.Integer.*;
import java.io.*;
import java.util.*;

/**
 * [B5] 백준 10951 A+B -4
 * 메모리 : 11604KB
 * 시간 : 80ms
 * 코드 길이 : 621B
 */
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String line = br.readLine();
        StringTokenizer st;

        // 만약 입력 문자열이 비어있다면 테스트 케이스 입력 종료
        while (line != null && !line.isEmpty()) {
            st = new StringTokenizer(line);
            sb.append(parseInt(st.nextToken()) + parseInt(st.nextToken())).append('\n');
            line = br.readLine();
        }

        System.out.println(sb);
    }
}