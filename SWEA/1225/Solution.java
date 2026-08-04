import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		for (int test_case = 1; test_case <= 10; test_case++) {
			Queue<Integer> numQ = new LinkedList<>();
			
			
			sc.nextInt();
			
			for (int i = 0; i < 8; i++) {
				int num = sc.nextInt();
				numQ.offer(num);
			}
			
			int salt = 1;
			
			while (true) {
				int first = numQ.poll();
				first -= salt++;
				if (first <= 0) {
					numQ.offer(0);
					break;
				} else {
					numQ.offer(first);
				}
				if (salt > 5) {
					salt = 1;
				}
			}
			
			System.out.print("#" + test_case + " ");
			while (!numQ.isEmpty()) {
				System.out.print(numQ.poll() + " ");
			}
			System.out.println();
		}
		
		sc.close();
	}
}
