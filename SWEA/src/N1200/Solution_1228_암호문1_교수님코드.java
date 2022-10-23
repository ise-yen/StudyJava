package N1200;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution_1228_암호문1_교수님코드 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = 10;
		for (int t = 0; t < T; t++) {

			int N = Integer.parseInt(br.readLine());
			LinkedList<String> list = new LinkedList<>();

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				list.add(st.nextToken());
			}

			int M = Integer.parseInt(br.readLine());

			st = new StringTokenizer(br.readLine());

			for (int i = 0; i < M; i++) {
				st.nextElement(); // i
				int index = Integer.parseInt(st.nextToken());
				int num = Integer.parseInt(st.nextToken());

				for (int j = index, end = index + num; j < end; j++) {

				}
			}
			System.out.print("#" + t + " ");
			for (int i = 0; i < 10; i++) {
				System.out.print(" ");
			}
			System.out.println();
		}

	}

}
