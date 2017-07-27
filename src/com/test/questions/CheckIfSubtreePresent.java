package com.test.questions;

public class CheckIfSubtreePresent {
	
	public static void main(String[] args){
		Node node1 = new Node();
		Node node2 = new Node();
		Node node3 = new Node();
		Node node4 = new Node();
		
		Node node5 = new Node();
		Node node6 = new Node();
		Node node7 = new Node();
		
		node1.setData(5);
		node2.setData(4);
		node3.setData(3);
		node4.setData(7);
		
		node5.setData(4);
		node6.setData(3);
		node7.setData(7);
		
		node1.setLeft(node2);
		node2.setLeft(node3);
		node2.setRight(node4);
		
		node5.setLeft(node6);
		node5.setRight(node7);
			
		CheckIfSubtreePresent subtree = new CheckIfSubtreePresent();
		boolean val = subtree.checkSubtree(node1, node5);
		System.out.println(val);
	}
	
	public boolean checkSubtree(Node node1, Node node2){
		if(node2 == null){
			return true;
		}
		return isSubtree(node1, node2);
	}
	
	// complete this
	public boolean isSubtree(Node node1, Node node2){
		if(node1 == null){
			return false;
		}
		if(node1.getData() == node2.getData()){
			return match(node1, node2);
		}
		boolean leftOfBigTree = isSubtree(node1.getLeft(), node2);
		boolean rightOfBigTree = isSubtree(node1.getRight(), node2);
		return leftOfBigTree || rightOfBigTree;
		
	}
	
	// complete this tomorrow
	public boolean match(Node node1, Node node2){

		if(node1 == null && node2 == null){
			return true;
		}
		
		else if(node1 == null || node2 == null){
			return false;
		}
		else if(node1.getData() != node2.getData()){
			return false;
		}else{
			boolean left = match(node1.getLeft(), node2.getLeft());
			boolean right = match(node1.getRight(), node2.getRight());
		return left && right;
	}
	
	}

}
