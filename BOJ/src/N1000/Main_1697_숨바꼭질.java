package N1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1697_숨바꼭질 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int res = 0;
		while (K != N) {
			if (K > N) {
				if (K % 2 == 0) {
					K /= 2;
				} else {
					K--;
				}
			} else if (K < N) {
				K++;
			}
			System.out.println("K : " + K);
			res++;
		}
		System.out.println(res);
	}

}
