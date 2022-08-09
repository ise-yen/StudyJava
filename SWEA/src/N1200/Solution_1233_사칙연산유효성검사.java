package N1200;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1233_사칙연산유효성검사 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = 10;
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			char[] arr = new char[N + 1];
			boolean[] visited = new boolean[N + 1];
			int res = 1;
			for (int i = 1; i < arr.length; i++) {
				st = new StringTokenizer(br.readLine());
				int index = Integer.parseInt(st.nextToken());
				arr[index] = st.nextToken().charAt(0);
			}

			for (int i = 1; i < arr.length; i++) {
				if(!visited[i]) {
					if (arr[i] == '+' || arr[i] == '-' || arr[i] == '*' || arr[i] == '/') {
						if (arr[2 * i] == '+' || arr[2 * i] == '-' || arr[2 * i] == '*' || arr[2 * i] == '/') {
						}
						if (arr[2 * i + 1] == '+' || arr[2 * i + 1] == '-' || arr[2 * i + 1] == '*'
								|| arr[2 * i + 1] == '/') {
						}
					} else {
						if (arr[2 * i] == '+' || arr[2 * i] == '-' || arr[2 * i] == '*' || arr[2 * i] == '/') {

						}
					}
				}
				else continue;
			}

			System.out.println("#" + t + " " + res);
		}
	}

	void Checking() {

	}

}
