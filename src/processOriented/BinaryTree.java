package processOriented;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}

public class BinaryTree {
	 public List<List<Integer>> levelOrder(TreeNode root) {
		 List<List<Integer>> ans = new ArrayList<>(); 
		 if(root == null)
			 return ans;
		 Queue<TreeNode> q = new LinkedList<>();
		 //先进先出的队列     
		 ArrayList<Integer> temp = new ArrayList<>(); 
		 //用来记录存放当前层的结点    
		 q.offer(root);
		 //首先让根节点入队
		 int curnode = 1; 
		 //当前层结点数目 初值为1 是根节点的初始化
		 int nextnode = 0;//下一层节点数目   
		 while(!q.isEmpty()){
			 TreeNode node;        
			 node = q.poll();//出队    
			 temp.add(node.val);
			 curnode--;           
			 if(node.left != null){   
				 q.offer(node.left); 
				 //左子节点入队      
				 nextnode++; 
				 }           
			 if(node.right != null){ 
				 q.offer(node.right); 
				 // 右子节点入队      
				 nextnode++;          
				 }           
			 if(curnode == 0){ 
				 //说明当前层已遍历完    
				 curnode = nextnode;    
				 nextnode = 0;          
				 ans.add(temp); 
				 //加入结果集     
				 temp = new ArrayList<>();   
				 }          
			 }       
		 return ans; 
		 } 
	 
	//Test
	 public static void main(String[] args) {
		 
		 TreeNode t1 = new TreeNode(3);
		 t1.left=new TreeNode(9);
		 TreeNode t3=t1.right=new TreeNode(20);
		 t3.left=new TreeNode(15);
		 t3.right=new TreeNode(7);
		 
		 BinaryTree test = new BinaryTree();
		 System.out.println(test.levelOrder(t1));
	 }
}


