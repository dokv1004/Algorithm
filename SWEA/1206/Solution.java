import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = 10;

		for (int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();
            int answer = 0;
            int[] buildings = new int[N];
            
            for (int i = 0; i < N; i++) {
                buildings[i] = sc.nextInt();
            }

            for (int i = 2; i < N-2; i++) {
                int left2 = buildings[i-2];
                int left1 = buildings[i-1];
                int now = buildings[i];
                int right1 = buildings[i+1];
                int right2 = buildings[i+2];

                int leftrightMax = Math.max(
                    Math.max(left2, left1), Math.max(right1, right2)
                );
                if (now >= leftrightMax) answer += now - leftrightMax;
            }
            
            System.out.println("#" + test_case + " " + answer);
		}
	}
}