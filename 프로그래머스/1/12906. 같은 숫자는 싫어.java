import java.util.*;

public class Solution {
public static int[] solution(int[] arr) {
        List<Integer> list = new ArrayList<>();
        int previous = arr[0];
        list.add(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            if (previous != arr[i]) {
                previous = arr[i];
                list.add(previous);
            }
        }
        return list.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}