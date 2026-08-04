import java.util.Scanner;

class Solution {
	public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int T = sc.nextInt();
    	
    	for (int tc = 1; tc <= T; tc++) {
    		int N = sc.nextInt();
    		int[][] arr = new int[N][N];
    		
    		int[] dc = {0, 1, 0, -1};
    		int[] dr = {1, 0, -1, 0};
    		
    		int c = 0;
    		int r = 0;
    		int dir = 0;
    		
    		for (int i = 1; i <= N*N; i++) {
				int nc = c + dc[dir];
				int nr = r + dr[dir];
				
				if (arr[c][r] == 0) {
					arr[c][r] = i;
				}
				
				if (0 <= nc && nc < N && 0 <= nr && nr < N && arr[nc][nr] == 0) {
					c = nc;
					r = nr;
				} else {
					dir = (dir + 1) % 4;
                    c = c + dc[dir];
                    r = r + dr[dir];
				}
			}
    		
    		System.out.println("#" + tc);
    		for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(arr[i][j] + " ");
				}
				System.out.println();
			}
    	}
    }
}
