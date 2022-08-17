package N1000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main_1541_잃어버린괄호 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();

		// (문자열형)숫자, -, +를 순서대로 받는 리스트
		ArrayList<String> expression = new ArrayList<>();
		StringBuffer sb = new StringBuffer(); // 문자형 숫자를 문자열형 숫자로 만들기 위한 버퍼
		
		// 0. 리스트에 식 분해해서 넣기
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if(c != '-' && c!= '+') {
				sb.append(c);
			}
			else {
				// 기존꺼 expression에 넣고 초기화
				expression.add(sb.toString());
				sb.delete(0, sb.length()); 
				sb = new StringBuffer();
				expression.add(Character.toString(c));
			}
		}
		
		// [DEBUG] 리스트에 잘 들어왔는지 체크
		for(int i =0; i < expression.size(); i++) {
			System.out.println(expression.get(i));
		}

		// 1. 리스트에 ( ) 넣기
		/*
		 * 1-1. index=0에는 '('
		 */
	}

}
