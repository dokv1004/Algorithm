import java.util.HashMap;
import java.util.Scanner;

public class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		
		for (int test_case = 1; test_case <= T; test_case++) {
			int tc = sc.nextInt();
			int[] arr = new int[1000];
			HashMap<Integer, Integer> cnt = new HashMap<>();
			int bc = 0;
			int bs = Integer.MIN_VALUE;
			
			for (int i = 0; i < 1000; i++) {
				arr[i] = sc.nextInt();
			}
			
			for (int score: arr) {
				cnt.put(score, cnt.getOrDefault(score, 0) + 1); 
			}
			
			for (int score: cnt.keySet()) {
				if (cnt.get(score) > bc) {
					bc = cnt.get(score);
					bs = score;
				} else if (cnt.get(score) == bc && score > bs) {
					bs = score;
				}
			}
			
			System.out.println("#" + tc + " " + bs);
		}
	}
}
