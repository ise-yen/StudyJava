package N10000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_10026_적록색약 {
	static int N;
	static int[][] map;
	static int[][] mapEyes;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		mapEyes = new int[N][N];
		for (int i = 0; i < map.length; i++) {
			String str = br.readLine();
			for (int j = 0; j < map[i].length; j++) {
				map[i][j] = str.charAt(j);
				if (str.charAt(j) == 'G') {
					mapEyes[i][j] = 'R';
				} else {
					mapEyes[i][j] = str.charAt(j);
				}
			}
		}

		int[][] deltas = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
			}
		}

	}

}
