package packag2;

public class BinaryTree {
    
	 public static void main(String args[]){
		 Node root = new Node(1);
		 Node node1 = new Node(2);
		 Node node2 = new Node(3);
		 Node node4 = new Node(4);
		 Node node5 = new Node(5);
		 
		 root.left = node1;
		 root.right = node2;
		 
		 node1.left = node4;
		 node1.right = node5;
		 
		 int minHeight = minimumDepth(root);
		 System.out.println("min height is : " +minHeight);
		 
	 }
//	    {
//	        BinaryTree tree = new BinaryTree();
//	        tree.root = new Node(1);
//	        tree.root.left = new Node(2);
//	        tree.root.right = new Node(3);
//	        tree.root.left.left = new Node(4);
//	        tree.root.left.right = new Node(5);
//	 
//	        System.out.println("The minimum depth of "+
//	          "binary tree is : " + tree.minimumDepth());
//	    }
	 
	 public static int minimumDepth(Node root){
		 if(root == null){
			 return 0;
		 }
		 
//		 if(root.left == null && root.right == null){
//			 return 1;
//		 }
//		 
//		 if(root.left == null){
//			 return 1 + minimumDepth(root.right);
//		 }
//		 
//		 if(root.right == null){
//			 return 1 + minimumDepth(root.left);
//		 }
		 
		 return 1 +  Math.min(minimumDepth(root.left), minimumDepth(root.right));
	 }
}
