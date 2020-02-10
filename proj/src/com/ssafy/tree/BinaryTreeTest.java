package com.ssafy.tree;

public class BinaryTreeTest {

	public static void main(String[] args) {
		int size = 10;
		BinaryTree tree = new BinaryTree(size);
		for(int i=0;i<size;i++) {
			tree.add((char)(65+i));
		}
		tree.printTreeByPreOrder();		
		System.out.println();
//		tree.printTreeByInOrder();
//		System.out.println();
//		tree.printTreeByPostOrder();
		
	}

}
