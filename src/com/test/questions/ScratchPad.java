package com.test.questions;

public class ScratchPad {
	
	public static void main(String[] args){
		Node root = new Node();
		Node leftNode = new Node();
		Node rightNode = new Node();
		root.setData(8);
		leftNode.setData(5);
		rightNode.setData(10);
		
		root.setLeft(leftNode);
		root.setRight(rightNode);
		
		Node first = new Node();
		Node second = new Node();
		first.setData(2);
		second.setData(6);
		
		leftNode.setLeft(first);
		leftNode.setRight(second);
		
		//boolean search = search(6, root);
		//System.out.println("is element present " +search);
		
		Node newNode = new Node();
		newNode.setData(1);
		Node insertedNode = insert(newNode, root);
		System.out.println("inserted node is : " +insertedNode.getData());
		
		// inorder traversal : LNR
		//inorderTraversal(root);
		//preorderTraversal(root);
		//postOrderTraversal(root);
		
		//boolean isBST = checkBTisBST(root);
		//System.out.println("Is the tree a BST : " +isBST);
		
		
	}

	// LNR
	private static void inorderTraversal(Node root) {
		if(root != null){
			inorderTraversal(root.getLeft());
			System.out.println("Node is : " +root.getData());
			inorderTraversal(root.getRight());
		}
	}
	
	   // NLR
		private static void preorderTraversal(Node root) {
			if(root != null){
				System.out.println("Node is : " +root.getData());
				preorderTraversal(root.getLeft());
				preorderTraversal(root.getRight());
			}
		}
		
		// LRN
		private static void postOrderTraversal(Node root) {
			if(root != null){
				postOrderTraversal(root.getLeft());
				postOrderTraversal(root.getRight());
				System.out.println("Node is : " +root.getData());
			}
		}
		
	// check if a BT is a BST 
	// BT : has upto 2 children
	// BST : left child <= root < right child
	// input : left child, root, right child
	// output : boolean value : true if the bt is a BST
	//   5
    // 2   10
	private static boolean checkBTisBST(Node node){
		return checkBST(node, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private static boolean checkBST(Node node, int minValue, int maxValue) {
		if(node == null){
			return true;
		}
		if(node.getData() < minValue || node.getData() > maxValue){
			return false;
		}
		
		return checkBST(node.getLeft(), minValue, node.getData()) && checkBST(node.getRight(), node.getData(), maxValue);
	}
	
	// search for an element in a BST

	// inputs : element to search, root of the tree

//	public static Node search(int data, Node root){
//		if(root.getData() == data){
//			return root;
//		}
//		if(data < root.getData()){
//			root = root.getLeft();
//			return search(data, root);
//		}
//			root = root.getRight();
//			return search(data, root);
//		}
//	}

	public static boolean search(int data, Node root){
		if(root.getData() == data){
			return true;
	}
		if(data < root.getData()){
			root = root.getLeft();
			return search(data, root);
	}
		root = root.getRight();
		return search(data, root);
	}
	
	// insert an element in a BST

	// input : Node to be inserted 
	// output : Node inserted in the tree
	// ask prash about this implementation?
	
	public static Node insert(Node node, Node root){
		// if there is no tree at all
		if(root == null){
			return node;
		}
		if(node.getData() <=  root.getData()){
			if(root.getLeft() == null){
				root.setLeft(node);
				return node;
			}
			return insert(node, root.getLeft());
		}
		if(root.getRight() == null){
			root.setRight(node);
			return node;
		}
		return insert(node, root.getRight());
	}
	
	// O(n) : time complexity -- bottom up approach tree traversal
	// assumes that both nodes are present in the tree.only if one key is present, returns 
	// the present keys as the LCA. ( should have returned null)
	// we can get past this by having 2 boolean values, v1 and v2
	// v1 is set to true if n1 is present in the tree
	// v2 is set to true if n2 is present in the tree
	public static Node findLCA(Node node, int n1, int n2){
		if(node == null){
			return null;
		}
		
		if(n1 == node.getData() || n2 == node.getData()){
			return node;
		}
		
		Node left = findLCA(node.getLeft(), n1, n2);
		Node right = findLCA(node.getRight(), n1, n2);
		
		if(left != null && right != null){
			return node;
		}
		
		if(left == null && right == null){
			return null;
		}
		
		return (left != null) ? left : right;
	}
	
	
	
	
}

