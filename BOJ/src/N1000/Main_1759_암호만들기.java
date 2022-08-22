package N1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1759_암호만들기 {
	static char[] words;
	static char[] passwords;

	public static void main(String[] args) throws IOException {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int L = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine(), " ");
		passwords = new char[L];
		words = new char[C];
		for (int c = 0; c < C; c++) {
			words[c] = st.nextToken().charAt(0);
		}
		
		// 오름차순 정렬
		Arrays.sort(words); 

		// 비밀번호 뽑기
		comb(0, L, 0);
	}

	private static void comb(int cnt, int L, int start) {
		if (cnt == L) {
			// 자모음 개수 카운트
			int moum = 0;
			int jaum = 0;
			for (int i = 0; i < passwords.length; i++) {
				if (passwords[i] == 'a' || passwords[i] == 'e' || passwords[i] == 'i' || passwords[i] == 'o'
						|| passwords[i] == 'u')
					moum++;
				else {
					jaum++;
				}
			}
			
			// 조건에 맞을 때만 출력
			if (moum > 0 && jaum >= 2) {
				for (int i = 0; i < passwords.length; i++) {
					System.out.print(passwords[i]);
				}
				System.out.println();
			}

			return;
		}
		for (int i = start; i < words.length; i++) {
			passwords[cnt] = words[i];
			comb(cnt + 1, L, i + 1);
		}
	}

}
