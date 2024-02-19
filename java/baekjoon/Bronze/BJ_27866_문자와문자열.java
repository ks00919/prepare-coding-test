import static java.lang.Integer.*;

import java.io.*;
import java.util.*;

/**
 * [B5] 백준 27866 문자와 문자열
 * 메모리 : 11472KB
 * 시간 : 80ms
 * 코드 길이 : 359B
 * 
 * @author 김민주
 * @see <a href="https://www.acmicpc.net/problem/27866">
 */
class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int i = parseInt(br.readLine());

        System.out.println(input.charAt(i - 1));
    }

}