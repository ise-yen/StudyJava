package N8000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_8458_원점으로집합 {

	int[][] deltas = {{1,0}, {-1, 0}, {0, 1}, {0,-1}};

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			int res = 0;
			int N = Integer.parseInt(br.readLine());

			
			
			
			System.out.println("#" + t + " " + res);
		}

	}

}
