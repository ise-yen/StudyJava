package N10000;

import java.util.LinkedList;
import java.util.Queue;

public class CompleteBinaryTree {
	private char[] nodes;
	private int lastIndex = 0; // 마지막 노드의 인덱스
	private final int SIZE;
	
	public CompleteBinaryTree(int size) {
		SIZE = size;
		nodes = new char[size+1]; // 1 인데스부터 사용
	}
	
	public boolean add(char e) {
		// 완전 이진트리에 맞게 추가
		if(lastIndex == SIZE) return false;
		
		nodes[++lastIndex] = e;
		return true;
	}
	
	public void bfs() {
		Queue<Integer> qTree = new LinkedList<Integer>();
		qTree.offer(1); // 루트 노드

		while (!qTree.isEmpty()) { // 방문대상이 있을 때까지 반복
			int current = qTree.poll(); // 방문 차례인 대상 정보 꺼내기
			System.out.println(nodes[current] + " "); // 방문해서 해야할 일 처리

			// 현재 방문 노드의 자식 노드들을 대기열에 넣기
			if (current * 2 <= lastIndex) { // 왼쪽자식
				qTree.offer(current * 2);
			}
			if (current * 2 + 1 <= lastIndex) { // 오른쪽자식
				qTree.offer(current * 2 +1);
			}
		}
		System.out.println();
	}
}
