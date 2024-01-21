import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 * [B4] 백준 15552 빠른 A + B
 * 메모리 : 259784KB
 * 시간 : 764ms
 * 코드 길이 : 791B
 * 
 * @author 김민주
 * @see <a href="https://www.acmicpc.net/problem/15552">
 */
class Main {

    public static void main(String[] args) throws IOException {
        // 입출력을 위한 BufferedReader, BuffereedWriter 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 테스트케이스 개수 T 입력
        int t = Integer.parseInt(br.readLine());

        // T만큼 반복
        for (int i = 0; i < t; i++) {
            // 테스트케이스 입력
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            // A, B 정수 형변환
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            // 개행문자를 포함해야 출력된다
            // 개행문자를 기준으로 데이터를 나눈다
            bw.write(a + b + "\n");
        }
        bw.flush();
    }

}
