package com.test.questions;

public class HeightOfBT {
	
	public static void main(String[] args){
		Node root = new Node();
		Node first = new Node();
		Node second = new Node();
		Node third = new Node();
		Node fourth = new Node();
		Node fifth = new Node();
		Node sixth = new Node();
		
		root.setData(1);
		first.setData(2);
		second.setData(3);
		third.setData(4);
		fourth.setData(5);
		fifth.setData(6);
		sixth.setData(7);
		
		
		root.setLeft(first);
		root.setRight(second);
		first.setLeft(third);
		first.setRight(fourth);
		//third.setLeft(fourth);
		//fourth.setLeft(fifth);
		second.setLeft(fifth);
		second.setRight(sixth);
		
		
		
		//int height = heightOfTree(root);
		//System.out.println("height of tree is : " +height);
		//topViewOfTree(root);
		boolean isBalanced = isBalanced(root);
		System.out.println("Is Balanced ? " +isBalanced);
	}
	
	// find height of the tree
	public static int heightOfTree(Node root){
		if(root == null){
			return -1;
		}	
		
		int leftHeight = heightOfTree(root.getLeft());
		System.out.println("height of left subtree : " +leftHeight);
		int rightHeight = heightOfTree(root.getRight());
		System.out.println("height of right subtree is : " +rightHeight);
		//System.out.println(Math.max(heightOfTree(root.getLeft()), heightOfTree(root.getRight())));
		return 1 + Math.max(leftHeight, rightHeight);
	}
	
//	public static int maxDepth(Node node) 
//    {
//        if (node == null)
//            return 0;
//        else
//        {
//            /* compute the depth of each subtree */
//            int lDepth = maxDepth(node.getLeft());
//            System.out.println("the left height is : " +lDepth);
//            int rDepth = maxDepth(node.getRight());
//            System.out.println("the right height is : " +rDepth);
//  
//            /* use the larger one */
//            if (lDepth > rDepth)
//                return (lDepth + 1);
//             else
//                return (rDepth + 1);
//        }
//    }
	
	
	public static void topViewOfTree(Node root){
		if(root == null){
			System.out.println("");
		}
		if(root != null){
			topViewOfTree(root.getLeft());
			System.out.println(root.getData());
		}
		if(root != null){
			topViewOfTree(root.getRight());
			System.out.println(root.getData());
		}
		//if(root.getRight() != null){
			//topViewOfTree(root.getRight());
		//}
		
	}
	
	// mistake I made was only check for the root node : if it is balanced or not
	// I did not check if for any node, if the two subtrees differ in height by not more than 1
	// fix is in else : recursively check if balanced for root.left and root.right
	// but this time complexity 0(NLOGN) because each node is touched once per node above it
	public static boolean checkIfBalancedTree(Node root){
		if(root == null){
			return true;
		}

		int leftHeight = heightOfSubTree(root.getLeft());
		int rightHeight = heightOfSubTree(root.getRight());

		if(Math.abs(leftHeight) - Math.abs(rightHeight) > 1){
			return false;
		} else{
			return checkIfBalancedTree(root.getLeft()) && checkIfBalancedTree(root.getRight());
		}
	}
	
	public static int heightOfSubTree(Node root){
		if(root == null){
			return -1;
		}
		return 1 + Math.max(heightOfSubTree(root.getLeft()), heightOfSubTree(root.getRight()));
	}
	
	
	// another approach to check if a tree is balanced is when we calculate the height of the tree, 
	// check if is balanced at the same time while checking heights. 
	// if not balanced return error code 
	// algorithm is :
	// On each node, recursively get the height of the left and right subtrees
	// check if the subtree is balanced, return the height of the subtree
	// if the subtree is not balanced, return error code which is can be taken as Intger.MinValue
	// runs in O(N) time and O(H) space
	public static boolean isBalanced(Node root){
		return calculateHeight(root) != Integer.MIN_VALUE;
	}

	private static int calculateHeight(Node root) {
		if(root == null){
			return -1;
		}
		
		int leftHeight = calculateHeight(root.getLeft());
		if(leftHeight == Integer.MIN_VALUE){
			return Integer.MIN_VALUE;
		}
		System.out.println("whats the height of the left subtree : " +leftHeight);
		
		int rightHeight = calculateHeight(root.getRight());
		if(rightHeight == Integer.MIN_VALUE){
			return Integer.MIN_VALUE;
		}
		System.out.println("whats the height of the right subtree : " +rightHeight);
		int heightDiff = leftHeight - rightHeight;
		System.out.println("height of the subtree is ? " +Math.abs(heightDiff));
		if(Math.abs(heightDiff) > 1){
			return Integer.MIN_VALUE;
		}else{
			return 1 + Math.max(leftHeight, rightHeight);
		}
		
	}
	
}
