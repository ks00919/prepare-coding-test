import java.util.Map;
import java.util.HashMap;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char character = s.charAt(i);
            if (!map.containsKey(character)) {
                answer[i] = -1;
                map.put(character, i);
            } else {
                answer[i] = i - map.get(character);
                map.put(character, i);
            }
        }
        return answer;
    }
}