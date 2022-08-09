package src.N9000;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_9229_SpotMart {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수
		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); // 과자 봉지 개수
			int M = Integer.parseInt(st.nextToken()); // 과자 무게합
			int resSum = -1;

			st = new StringTokenizer(br.readLine());
			int[] snacks = new int[N];
			for(int i = 0; i < N; i++) {
				snacks[i] = Integer.parseInt(st.nextToken());
			}
			int max = 0;
			for (int i = 0; i < N-1; i++) {
				for(int j = 1+i; j < N; j++) {
					int sum = snacks[i] + snacks[j];
					if(max <= sum && sum <= M) {
						max = sum;
						resSum = sum;
					}
				}
			}
			System.out.println("#" + test_case + " " + resSum);
		}
	}

}
