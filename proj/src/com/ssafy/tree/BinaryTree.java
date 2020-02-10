package com.ssafy.tree;

public class BinaryTree {

	private Object[] nodes;
	private final int SIZE;// 어떤객체를 만들더라도 SIZE를 이렇게 지정한다가 아닌
	private int lastIndex;
	private static int limit=1;
	private static int height=1;
	private static int[] limit_height;
	// 어떨떄는 10개 어떨땐 20개 이런식으로 구성!
	// 값은 초기화를 시켜야된다
	public BinaryTree(int size) {
		super();
		SIZE = size;
		nodes = new Object[size + 1]; // 루트노드를 1인덱스부터 사용이 목적!
		
	}

	public boolean isEmpty() {
		return lastIndex == 0;
	}

	public boolean isFull() {
		return lastIndex == SIZE;
	}

	public void add(Object e) {
		if (isFull())
			throw new RuntimeException("이진트리가 포화상태입니다.");
		nodes[++lastIndex] = e;
	}

	public void printTreeByPreOrder() {
		//printTreeByPreOrder(1);
		heightCount(5);
	}

	private void printTreeByPreOrder(int current) {
		if (current > lastIndex) {
			return;
		}
			System.out.print(nodes[current] + " "); // 현재노드
			printTreeByPreOrder(current * 2); // 왼쪽 자식노드
			printTreeByPreOrder(current * 2 + 1); // 오른쪽 자식노드
	}
	public void heightCount(int index) {
		int temp=1; // 자식 노드를 더하기 위한 변수
		while(SIZE>limit) {
			temp=temp*2;
			limit=limit+temp; 
			height++;
		}	
		temp=1; //높이 각각의 최대 노드 인덱스 저장
		limit_height=new int[height]; //높이 배열을 담는것이므로 높이만큼 배열지정
		limit_height[0]=1; //루트노드는 1로 설정
		
		for(int i=1;i<height;i++) {	
			limit_height[i]=temp=temp*2;
		}
		int count=0;
		temp=0;
		System.out.print("높이"+(temp+1)+": ");
		
		if(index==1) {
			for(int i=1;i<=SIZE;i++) {
				if(nodes[i]!=null) {
					if(limit_height[temp]==count) {
						temp++;
						System.out.println();
						System.out.print("높이"+(temp+1)+": ");
						count=0;
					}
					count++;
					System.out.print(nodes[i]+" ");
						
				}
			}
		}else{
			int sample=index-1;
			for(int i=index;i<=SIZE;i++) {
				if(nodes[i]!=null) {
					if(limit_height[temp]==count) {
						temp++;
						i=i+sample;
						sample=sample*2;
						if(i>SIZE) {
						break;
					}
						System.out.println();
						System.out.print("높이"+(temp+1)+": ");
						count=0;					
					}
					count++;
					System.out.print(nodes[i]+" ");
						
				}
			}
		}		
	}
		
	

	public void printTreeByInOrder() {
		printTreeByInOrder(1);
	}

	private void printTreeByInOrder(int current) {
		if (current > lastIndex)
			return;
		
		printTreeByInOrder(current * 2); // 왼쪽 자식노드
		System.out.print(nodes[current] + " "); // 현재노드
		printTreeByInOrder(current * 2 + 1); // 오른쪽 자식노드

	}

	public void printTreeByPostOrder() {
		printTreeByPostOrder(1);
	}

	private void printTreeByPostOrder(int current) {
		if (current > lastIndex)
			return;

		printTreeByPostOrder(current * 2); // 왼쪽 자식노드
		printTreeByPostOrder(current * 2 + 1); // 오른쪽 자식노드
		System.out.print(nodes[current] + " "); // 현재노드

	}

}
