package N13000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

// ABCDE
public class Main_13023_ABCDE {

	static LinkedList<Character> tmp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		ArrayList<LinkedList> friends = new ArrayList<>();

		for (int m = 0; m < M; m++) {
			String str = br.readLine();
			char a = str.charAt(0);
			char b = str.charAt(2);

			System.out.println(a + " => " + b);

			// 초기값 넣기
			if (m == 0) {
				LinkedList<Character> person = new LinkedList<>();
				person.add(a);
				person.add(b);
				friends.add(person);
				System.out.println(friends.get(0));
				System.out.println();
			}
			// 꼬리잇기
			else {
				boolean isFriends = false;
				boolean isSame = false;
				for (int i = 0; i < friends.size(); i++) {
					if (friends.get(i).size() > 0) { // 범위예외 처리
						if (friends.get(i).equals(a)) {
							if (friends.get(i).contains(b))
								break;
						} else if (friends.get(i).equals(b)) {
							if (friends.get(i).contains(a))
								break;
						} else {
							if (friends.get(i).get(friends.get(i).size() - 1).equals(a)) {
								tmp = (LinkedList<Character>) friends.get(i).clone();
								friends.get(i).add(b);
								if (friends.get(i).size() >= 5) {
									System.out.println(1);
									return;
								}
								System.out.println("요깅");
								isFriends = true;
								continue;
							} else if (friends.get(i).get(friends.get(i).size() - 1).equals(b)) {
								tmp = (LinkedList<Character>) friends.get(i).clone();
								friends.get(i).add(a);

								if (friends.get(i).size() >= 5) {
									System.out.println(1);
									return;
								}
								System.out.println("요깅2");
								isFriends = true;
								continue;
							}

						}
					} // end of 범위예외
				} // end of 꼬리잇기

				// 친구 없는 애는 friends 리스트에 추가
				if (!isFriends) {
					LinkedList<Character> person = new LinkedList<>();
					person.add(a);
					person.add(b);
					friends.add(person);
					continue;
				}
				friends.add(tmp);
				for (int i = 0; i < friends.size(); i++) {
					System.out.println(friends.get(i));
				}
				System.out.println();
			}

		}

		System.out.println(0);
	}

}