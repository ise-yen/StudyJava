package N10000;
import java.util.ArrayList;
import java.util.Scanner;

public class Main_17413_단어뒤집기2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		String[] arrStr = str.split(" ");
		ArrayList<Character> ansL = new ArrayList<Character>();
		
		for(int i = 0; i < arrStr.length; i++) {
			int k = 0; int cnt = 0;
//			while(cnt < arrStr.length) {
//				
//			}
			// 태그라면 '>' 나올때까지 그대로 넣기
			if(arrStr[i].charAt(0) == '<') {
				while(arrStr[i].charAt(k) != '>' && k < arrStr[i].length()) {
					ansL.add(arrStr[i].charAt(k));
					k++;
				}
			}
			// arrStr[i].length까지는 뒤집어서 넣기
			for(int j = arrStr[i].length()-1; j >=k; j--) {
				ansL.add(arrStr[i].charAt(j));
			}
			// ' '로 나눴으니 ' ' 넣어주기
			ansL.add(' ');
		}
		
		for(int i =0 ; i < ansL.size(); i++) {
			System.out.print(ansL.get(i));
		}
	}
}
