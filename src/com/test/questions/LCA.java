package com.test.questions;

public class LCA {
	
	static boolean v1 = false;
	static boolean v2 = false;
	
	public static void main(String[] args){
		Node node = new Node();
		int n1=0;
		int n2=0;
		findLCAV2(node, n1, n2);
		
	}
	
	
	// another approach by having v1 and v2
		public static Node findLCAV2(Node node, int n1, int n2){
			
			Node lca = findLCAUtil(node, n1,n2);
			
			if(v1 && v2){
				return lca;
			}
			return null;
		}
		
		public static Node findLCAUtil(Node node, int n1, int n2){
			if(node == null){
				return null;
			}
			
			if(n1 == node.getData()){
				v1 = true;
				return node;
			}
			
			if(n2 == node.getData()){
				v2 = true;
				return node;
			}
			
			Node left = findLCAUtil(node.getLeft(), n1, n2);
			Node right = findLCAUtil(node.getRight(), n1, n2);
			
			if(left != null && right != null){
				return node;
			}
			
			if(left == null && right == null){
				return null;
			}
			
			return (left != null) ? left : right;
		}
		}


