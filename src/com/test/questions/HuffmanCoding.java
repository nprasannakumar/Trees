package com.test.questions;

public class HuffmanCoding {
	
	public static void main(String args[]){
		NodeHuffman root = new NodeHuffman();
		
		
	}
	
	
	public static void decode(String s, NodeHuffman root){
		NodeHuffman n = root;
		for(int i=0; i<s.length(); i++){
			if(s.charAt(i) == '0'){
				n = n.left;
			}else{
				n = n.right;
			}
			
			if(n.left == null || n.right == null){
				System.out.print(n.data);
				n = root;
			}
		}
	}

}
