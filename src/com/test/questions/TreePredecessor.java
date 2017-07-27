package com.test.questions;

public class TreePredecessor {
	
	public static void main(String[] args){
		
		Node root = new Node();
		Node node1 = new Node();
		Node node2 = new Node();
		Node node3 = new Node();
		Node node4 = new Node();
		Node node5 = new Node();
		
		
		root.setData(25);
		node1.setData(15);
		node2.setData(40);
		node3.setData(10);
		node4.setData(18);
		node5.setData(35);
		
		root.setLeft(node1);
		root.setRight(node2);
		node1.setLeft(node3);
		node1.setRight(node4);	
		node2.setLeft(node5);
		
		findPredecessor(root, 18);
		//System.out.println("the predecessor is : " +predecessor);
		
	}
	
//	public static int findPredecessor(int val, Node root){
//		if(val == root.getData()){
//			while(root.getLeft() != null){
//				root = root.getLeft();
//				while(root.getRight() != null){
//					root = root.getRight();
//				}
//			}
//			return root.getData();
//		}
//
//		if(val < root.getData()){
//			Node curr = root;
//			Node parent = curr;
//			while(curr.getLeft() != null){
//				if(val == curr.getData()){
//					return curr.getLeft().getData();
//				}
//				if(val < curr.getData()){
//					curr = curr.getLeft();
//				}
//				if(val > curr.getData()){
//					parent = curr;
//					curr = curr.getRight();
//				}
//
//			}
//			return parent.getData();
//		}
//
//		if(val > root.getData()){
//			Node curr = root;
//			Node parent = curr;
//			while(curr.getRight() != null){
//				if(val == curr.getData()){
//					return curr.getLeft().getData();
//				}
//				if(val < curr.getData()){
//					curr = curr.getLeft();
//				}
//				if(val > curr.getData()){
//					parent = curr;
//					curr = curr.getRight();
//				}
//
//			}
//			return parent.getData();
//			}
//		return -1;
//		}
//	}
	
//	public static int findPredecessor(int val, Node root){
//		if(val == root.getData()){
//			while(root.getLeft() != null){
//				root = root.getLeft();
//				while(root.getRight() != null){
//					root = root.getRight();
//				}
//			}
//			return root.getData();
//		}
//		
//		if(val < root.getData()){
//			Node curr = root.getLeft();
//			Node parent = null;
//			while(curr.getLeft() != null){
//				if(val == curr.getData()){
//					return curr.getLeft().getData();
//				}
//				if(val < curr.getData()){
//					curr = curr.getLeft();
//				}
//				if(val > curr.getData()){
//					parent = curr;
//					curr = curr.getRight();
//				}
//			}
//			return parent.getData();
//			
//		}
//		
//		if(val > root.getData()){
//			Node curr = root.getRight();
//			while(curr.getRight() != null && curr.getLeft() != null){
//				curr = curr.getRight();
//				if(val == curr.getData()){
//					//return root.getData();
//				}
//			}
//			return root.getData();
//			
//		}
//		return -1;
//
//	}
	
	public static void findPredecessor(Node root, int val) {
		int predecessor = -1;
		if (root != null) {
			if (root.getData() == val) {
				// go to the right most element in the left subtree, it will the
				// predecessor.
				if (root.getLeft() != null) {
					Node t = root.getLeft();
					while (t.getRight() != null) {
						t = t.getRight();
					}
					predecessor = t.getData();
				}
				if (root.getRight() != null) {
					// go to the left most element in the right subtree, it will
					// the successor.
					Node t = root.getRight();
					while (t.getLeft() != null) {
						t = t.getLeft();
					}
					//successor = t.data;
				}
				//predecessor = root.getData();
			} else if (root.getData() > val) {
				// we make the root as successor because we might have a
				// situation when value matches with the root, it wont have
				// right subtree to find the successor, in that case we need
				// parent to be the successor
				//successor = root.data;
				findPredecessor(root.getLeft(), val);
			} else if (root.getData() < val) {
				// we make the root as predecessor because we might have a
				// situation when value matches with the root, it wont have
				// right subtree to find the predecessor, in that case we need
				// parent to be the predecessor.
				//if(root.getRight() == null){
					predecessor = root.getData();
				//}
				//System.out.println("whats the predecessor? " +predecessor);
				findPredecessor(root.getRight(), val);
			}
		}
		System.out.println("whats the predecessor? " +predecessor);
	}
	
}


