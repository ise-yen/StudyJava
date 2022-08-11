package N1000;

import java.util.Scanner;

public class Main_1062_가르침 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 배운 단어 개수
		int K = sc.nextInt(); // 배울 수 있는 알파벳 개수

		// 배울 단어들 입력
		String[] words = new String[N];
		for (int i = 0; i < N; i++) {
			words[i] = sc.next();
		}
		int res = 0;
		int alphabetCnt = 0; // 기존에 배운 알파벳 개수

		int[] alphabet = new int[26]; // 배운 알파벳 체크

		for (int i = 0; i < words.length; i++) {
			int newCnt = 0; // 새로 배운 알파벳

			for (int j = 0; j < words[i].length(); j++) {
				alphabet[words[i].charAt(j) - 'a']++;
				
				// 새로 배운 것만 newCnt에 카운트
				if (alphabet[words[i].charAt(j) - 'a'] == 0)
					newCnt++;
			}
			
			// 뇌용량 초과라면 리셋
			if (alphabetCnt + newCnt > K) {
				for (int j = 0; j < words[i].length(); j++) {
					alphabet[words[i].charAt(j) - 'a']--;
				}
			}
			// 기존 배운거 + 새로 배운거가 뇌용량 한도내라면
			else {
				res++; // 2개
				// 지금까지 배운 알파벳 개수 기록
				alphabetCnt += newCnt; // 6  + x(1r개) 7개
			}
		}

		System.out.println(res);
		sc.close();
	}
}
