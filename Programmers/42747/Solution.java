import java.util.Arrays;

class Solution {
    public int solution(int[] citations) {
        int n = citations.length;

        Arrays.sort(citations);

        return makeH(citations, 0, n - 1);
    }

    public int makeH(int[] citations, int left, int right) {
        int n = citations.length;

        if (left > right) {
            return n - left;
        }

        int mid = (left + right) / 2;
        int h = n - mid;


        if (citations[mid] >= h) {
            return makeH(citations, left, mid - 1);
        } else {
            return makeH(citations, mid + 1, right);
        }
    }
}

// citations[mid] >= n - mid
