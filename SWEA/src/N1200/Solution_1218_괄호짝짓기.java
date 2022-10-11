package N1200;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_1218_괄호짝짓기 {
	static int brackets[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 1; t <= 10; t++) {
			brackets = new int[4];
			int num = Integer.parseInt(br.readLine());
			String str = br.readLine();
			int res = -1;
			// 문자열 체크
			for (int i = 0; i < num; i++) {
				int pos = -1;
				switch (str.charAt(i)) {
				case '(':
				case ')':
					pos = 0;
					break;
				case '[':
				case ']':
					pos = 1;
					break;
				case '{':
				case '}':
					pos = 2;
					break;
				case '<':
				case '>':
					pos = 3;
					break;
				default:
					break;
				}
				if (str.charAt(i) == '(' || str.charAt(i) == '[' || str.charAt(i) == '{' || str.charAt(i) == '<')
					brackets[pos]++;
				else
					brackets[pos]--;
			} // 문자열 체크 끝
			for (int i = 0; i < brackets.length; i++) {
				if (brackets[i] == 0)
					res = 1;
				else {
					res = 0;
					break;
				}
			}
			System.out.println("#" + t + " " + res);
		}

		br.close();
	}

}
