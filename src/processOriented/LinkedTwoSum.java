package processOriented;

class ListNode {
	  int val;
	  ListNode next;
	  ListNode(int x) { val = x; }
	  
	  public static void getList(ListNode node) {
	      while(node!=null) {
	         System.out.print(node.val);
	         node=node.next;
	      }
	  }
}

public class LinkedTwoSum{ 
	
	 public ListNode ListNodeaddTwoNumbers (ListNode l1, ListNode l2) {
		 if (l1==null || l2==null) {
		 return l1 == null? l2:l1;
		 }
		 int value=l1.val +l2.val;
		 ListNode ans= new ListNode (value % 10);//节点相加
		 ans.next=ListNodeaddTwoNumbers(l1.next,l2.next);
		 if(value >=10) {
		  ans.next =ListNodeaddTwoNumbers(new ListNode(value/10),ans.next);//进位
		 }
		 return ans;
	 }
	 
	//Test
	public static void main(String[] args) {

		 ListNode l1 =new ListNode(2);
		 ListNode l2=l1.next=new ListNode(4);
		 l2.next=new ListNode(3);
		 
		 ListNode l4 =new ListNode(5);
		 ListNode l5=l4.next=new ListNode(6);
		 l5.next=new ListNode(4);
		 
		 LinkedTwoSum test=new LinkedTwoSum();
		 ListNode.getList(test.ListNodeaddTwoNumbers(l1, l4));
	 }
	
}
