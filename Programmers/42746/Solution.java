import java.util.Arrays;

class Solution {
    public String solution(int[] numbers) {
        String[] strNum = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            strNum[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(strNum, (a, b) -> (b + a).compareTo(a + b));

        if (strNum[0].equals("0")) {
            return "0";
        }

        StringBuilder answer = new StringBuilder();

        for (String num : strNum) {
            answer.append(num);
        }

        return answer.toString();
    }
}
