import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * [B5] 백준 1330 두 수 비교하기
 * 
 * 메모리 : 11504KB
 * 시간 : 76ms
 * 코드 길이 : 516B
 * 
 * @author 김민주
 * @see <a href="https://www.acmicpc.net/problem/1330">
 */
class Main {
    public static void main(String[] args) throws IOException {
        // 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 입력받은 문자열에서 A, B 정수 형변환
        String[] numbers = br.readLine().split(" ");
        int a = Integer.parseInt(numbers[0]);
        int b = Integer.parseInt(numbers[1]);

        // A가 B보다 크다면 > 출력
        if (a > b) {
            System.out.println(">");
            // B가 A보다 크다면 < 출력
        } else if (a < b) {
            System.out.println("<");
            // A와 B가 같을때 == 출력
        } else {
            System.out.println("==");
        }
    }
}