import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution {
    static int length, count;
    static char[][] board;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();

        for (int testCase = 1; testCase <= 10; testCase++) {

            length = Integer.parseInt(br.readLine().trim());
            board = new char[8][8];

            for (int i = 0; i < 8; i++) {
                board[i] = br.readLine().trim().toCharArray();
            }

            count = 0;

            for (int i = 0; i < 8; i++) {
                for (int j = 0; j <= 8 - length; j++) {
                    boolean isRowPalindrome = true;
                    boolean isColPalindrome = true;

                    for (int k = 0; k < length / 2; k++) {
                        if (board[i][j + k]
                                != board[i][j + length - 1 - k]) {
                            isRowPalindrome = false;
                        }

                        if (board[j + k][i]
                                != board[j + length - 1 - k][i]) {
                            isColPalindrome = false;
                        }
                    }

                    if (isRowPalindrome) {
                        count++;
                    }

                    if (isColPalindrome) {
                        count++;
                    }
                }
            }

            result.append("#")
                    .append(testCase)
                    .append(" ")
                    .append(count)
                    .append("\n");
        }

        System.out.print(result);
    }
}