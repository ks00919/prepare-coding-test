import static java.lang.Integer.*;

import java.io.*;

/**
 * [B4] 백준 11720 숫자의 합
 * 메모리 : 11528KB
 * 시간 : 76ms
 * 코드 길이 : 453B
 * 
 * @author 김민주
 * @see <a href="https://www.acmicpc.net/problem/11720">
 */
class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = parseInt(br.readLine());
        String input = br.readLine();
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += input.charAt(i) - '0';
        }
        System.out.println(sum);
    }

}