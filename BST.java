package Lab07;

class BST{
	private Node top;
	private class Node {
		Book data;
		Node left;
		Node right;
	}

	BST(){
		top=null;
	}
			//GET()
	public java.lang.Object get(java.lang.Comparable theKey){
		Node temp=top;
		while(temp!=null)
		{
			if(theKey.compareTo(Integer.parseInt(temp.data.getIsbn()))==0)
			{
				System.out.print("\n::Book Found :  ");
				System.out.println(temp.data);
				break;
			}
			else if(theKey.compareTo(Integer.parseInt(temp.data.getIsbn())) > 0)
				temp=temp.right;
			else
				temp=temp.left;
		}
		return temp.data;
	}

			//PUT()
	public void put(java.lang.Comparable theKey, java.lang.Object x){
		Node curr = top;
		Node parent = null;
		if (top == null) {
			Node temp=new Node();
			temp.data=(Book) x;
			temp.left=null;temp.right=null;
			top=temp;
			System.out.print("\t@@@@@__BOOK INSERTED SUCCESSFULLY_________ : ");
			System.out.println((Book)x);
		}
		else{
			while (curr != null)
			{
			    parent = curr;
			    if (theKey.compareTo(Integer.parseInt(curr.data.getIsbn())) >=0) {
				curr = curr.right;
			    }
			    else {
				curr = curr.left;
			    }
			}
			Node temp=new Node();
			temp.data=(Book) x;
			temp.left=null;temp.right=null;
			if (theKey.compareTo(Integer.parseInt(parent.data.getIsbn())) < 0) 
			   { parent.left=temp;}
			else 
			   {parent.right=temp;}
			System.out.print("\t++BOOK INSERTED SUCCESSFULLY : ");
			System.out.println((Book)x);
		}
	}

			//REMOVE()
	public java.lang.Object remove(java.lang.Comparable theKey){
		if(top==null){
			System.out.println("______NO BOOK PRESENT______ ");
			return top.data;
		}
		Node prev=top;
		Node temp=top;
		Node removeObject=new Node();
		removeObject = null;
		if(theKey.compareTo(Integer.parseInt(top.data.getIsbn())) ==0)
		{
			Node temp1=top;
			if(temp1.left==null){
				top=top.right;	return temp1.data;}
			else if(temp1.right==null){
				top=null;	return temp1.data;}
			else
			{
				Node min=temp1.right;
				while(min.left!=null)
					min=min.left;
				removeObject=top;
				top.data=min.data;
				theKey=(java.lang.Comparable)Integer.parseInt(min.data.getIsbn());
				temp=top.right;
			}
		}
		int dir=1;
		while(temp!=null){
			if(theKey.compareTo(Integer.parseInt(temp.data.getIsbn())) < 0){
				prev=temp;      temp=temp.left;		dir=1;}
			else if(theKey.compareTo(Integer.parseInt(temp.data.getIsbn())) > 0){
				prev=temp;      temp=temp.right;	dir=2;}
			else
			{
				removeObject=temp;
				if(temp.left==null){
					if(dir==1){
						prev.left=temp.right;
					}
					else{
						prev.right=temp.right;
					}
					System.out.println("___________Book deleted Successfully : "+temp.data);
					removeObject = temp;
					break;
				}
				else if(temp.right==null){
					if(dir==1){
						prev.left=temp.left;
					}
					else{
						prev.right=temp.left;
					}
					System.out.println("________Book deleted Successfully_______ : "+temp.data);
					removeObject = temp;
					break;
				}
				Node min=temp.right;
				while(min.left!=null)
					min=min.left;
				temp.data=min.data;
				int minKey=Integer.parseInt(min.data.getIsbn());
				prev=temp;
				temp=temp.right;
				while(temp.left!=null)
				{
					prev=temp;
					temp=temp.left;
				}
				prev.left=temp.right;
				System.out.println("Book deleted Successfully : "+temp.data);
				if(removeObject==null)
					removeObject = temp;
				break;
			}
		
		}//end of while
		return top.data;
	}
	public boolean isEmpty(){
		if(top==null)
			return true;
		else
			return false;
	}
			//PREORDER
	public void preOrderOutput(java.io.PrintStream out)
	{
		out.println("\n\n----------------------PREORDER--------------------");
		if (top == null)
		    return; 

		Stack<Node> nodeStack = new Stack<Node>(); 
		nodeStack.push(top); 

		while (nodeStack.empty() == false) { 
		    Node mynode = nodeStack.peek(); 
		   out.println(mynode.data + " "); 
		    nodeStack.pop(); 
		    if (mynode.right != null) { 
		        nodeStack.push(mynode.right); 
		    } 
		    if (mynode.left != null) { 
		        nodeStack.push(mynode.left); 
		    } 
		} 

	}
			//INORDER
	public void inOrderOutput(java.io.PrintStream out)
	{
		out.println("\n\n----------------------INORDER--------------------");
		if (top == null) 
		    return; 
	  
	  
		Stack<Node> s = new Stack<Node>(); 
		Node curr = top; 
	  
		while (curr != null || s.size() > 0) 
		{ 
		    while (curr !=  null) 
		    { 
		        s.push(curr); 
		        curr = curr.left; 
		    } 
		    curr = s.pop(); 
		    out.println(curr.data + " "); 
		    curr = curr.right; 
		} 
	}
			//POSTOREDR
	public void postOrderOutput(java.io.PrintStream out)
	{
		out.println("\n\n----------------------POSTORDER--------------------");
		Stack<Node> s1 = new Stack<Node>(); 
		Stack<Node> s2 = new Stack<Node>();  
	  
		if (top == null) 
		    return; 

		s1.push(top); 
		while (!s1.isEmpty()) { 
		    Node temp = s1.pop(); 
		    s2.push(temp); 
		    if (temp.left != null) 
		        s1.push(temp.left); 
		    if (temp.right != null) 
		        s1.push(temp.right); 
		} 
		while (!s2.isEmpty()) { 
		    Node temp = s2.pop(); 
		    out.println(temp.data + " "); 
		}

	}
}
