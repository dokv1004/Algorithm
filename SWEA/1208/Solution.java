import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
  static int dump, maxV, minV, maxI, minI;
  static int result;
  static int[] boxes;


	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for(int t = 1; t <= 10; t++) {
      dump = Integer.parseInt(br.readLine().trim());
      boxes = new int[100];
      StringTokenizer st = new StringTokenizer(br.readLine());;

      for (int i = 0; i < 100; i++) {
        boxes[i] = Integer.parseInt(st.nextToken());
      }

      for (int cnt = 0; cnt < dump; cnt++) {
        maxV = boxes[0];
        minV = boxes[0];
        maxI = 0;
        minI = 0;

        for (int i = 1; i < boxes.length; i++) {
          if (boxes[i] > maxV) {
            maxV = boxes[i];
            maxI = i;
          }
          if (boxes[i] < minV) {
            minV = boxes[i];
            minI = i;
          }
        }
        boxes[maxI]--;
        boxes[minI]++;
      }
      
      maxV = boxes[0];
      minV = boxes[0];

      for (int i = 1; i < boxes.length; i++) {
        if (boxes[i] > maxV) {
          maxV = boxes[i];
        }

        if (boxes[i] < minV) {
          minV = boxes[i];
        }
      }
      result = maxV - minV;
      System.out.println("#" + t + " " + result);
		}
	}
}