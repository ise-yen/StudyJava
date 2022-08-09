package N10000;
import java.io.BufferedReader;
//import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//구간 합 구하기 5
public class Main_11660_구간합5 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int map[][] = new int[n + 1][n + 1];
		int sum[][] = new int[n + 1][n + 1];

		for (int i = 0; i <= 0; i++) {
			for (int j = 0; j < n + 1; j++) {
				map[i][j] = 0;
				sum[i][j] = 0;
			}
		}
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				sum[i][j] = sum[i][j - 1] + sum[i - 1][j] - map[i - 1][j - 1] + map[i][j];
			}
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			if (x1 == x2 && y1 == y2) {
				System.out.println(map[x1][y1]);
			} else {
				System.out.println(sum[x2][y2] - sum[x1-1][y2] - sum[x2][y1 - 1] + sum[x1 - 1][y1 - 1]);
			}
		}
	}

}
