package com.test.questions;

public class TreeSuccessor {
	
	private static Node parent = new Node();
	
	public static void main(String[] args){
		Node root = new Node();
		Node node1 = new Node();
		Node node2 = new Node();
		Node node3 = new Node();
		Node node4 = new Node();
		Node node5 = new Node();
		Node node6 = new Node();
		
		root.setData(20);
		node1.setData(8);
		node2.setData(22);
		node3.setData(4);
		node4.setData(12);
		node5.setData(10);
		node6.setData(21);
		
		
		root.setLeft(node1);
		root.setRight(node2);
		node1.setLeft(node3);
		node1.setRight(node4);
		node4.setLeft(node5);
		node2.setLeft(node6);
		
		Node successor = findSuccessorAgain(22, root);

		System.out.println("successor is : " +successor.getData());
	}
	
//	public static int findSuccessor(int val, Node root){
//		//Node parent = root;
//		if(val == root.getData()){
//			if(root.getRight() != null){
//				return root.getRight().getData();
//			}
//			return parent.getData();
//		}
//
//		if(val < root.getData()){
//			parent = root;
//			return findSuccessor(val, root.getLeft());
//		}
//
//		if(val > root.getData()){
//			return findSuccessor(val, root.getRight());
//		}
//		return -1;
//	}
	
	// worst case time complexity : O(h), O(1)
	public static Node findSuccessorAgain(int val, Node root){
		Node succ = null;
		while(root != null){
			if(val < root.getData()){
				succ = root;
				root = root.getLeft();
			}else{
				root = root.getRight();
			}
			
		}
		return succ;
	}
	
	// so cool
	public static Node findSuccessorOfBST(int val, Node root){
		 Node succ = null;
		    while (root != null) {
		        if (val < root.getData()) {
		            succ = root;
		            root = root.getLeft();
		        }
		        else
		            root = root.getRight();
		    }
		    return succ;
	}

}
