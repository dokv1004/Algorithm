import java.util.HashSet;
import java.util.Set;



class Solution {

    private Set<Integer> candidates;
    private int[] numArr;
    private boolean[] visited;

    public int solution(String numbers) {
        int len = numbers.length();
        numArr = new int[len];
        visited = new boolean[len];
        candidates = new HashSet<>();
        int answer = 0;

        for (int i = 0; i < numbers.length(); i++) {
            numArr[i] = numbers.charAt(i) - '0';
        }

        makeNum(0, 0, len);

        for (int number : candidates) {
            if (isPrime(number)) {
                answer++;
            }
        }

        return answer;
    }

    public void makeNum(int current, int depth, int len) {
        if (depth == len) {
            return;
        }

        for (int i = 0; i < len; i++) {
            if (visited[i]) {
                continue;
            }

            visited[i] = true;

            int digit = numArr[i];
            int next = current * 10 + digit;

            candidates.add(next);

            makeNum(next, depth + 1, len);

            visited[i] = false;
        }
    }

    public boolean isPrime(int num) {
        if (num <= 1) return false;
        if (num == 2) return true;
        if (num % 2 == 0) return false;
        for (int i = 3; i * i <= num; i += 2) {
            if (num % i == 0) {
                return false; 
            }
        }
        return true;
    }
}
