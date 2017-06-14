
public class CircularLinkedList {

	private CLLNode head;


	public CircularLinkedList()
	{
		head = null;

	}

	public CircularLinkedList(Object addHead)
	{
		CLLNode headNode = new CLLNode(addHead);
		head = headNode;
		head.setLink(head);

	}	


	public void addLast(Object current)  
	{

		if(head == null)
		{
			CLLNode temp = new CLLNode(current);
			head = temp;
			temp.setLink(temp);
		}
		else  
		{
			CLLNode temp = head;
			while(temp.getLink() != head)
			{
				temp = temp.getLink();
			}
			CLLNode newNode = new CLLNode(current);
			temp.setLink(newNode);
			newNode.setLink(head);
		}



	}

	public void delete(CLLNode deleted)
	{


		CLLNode tempPrev = head;
		CLLNode temp = head.getLink();

		if(tempPrev == deleted)
		{
			tempPrev = null;
		}

		while(temp != deleted)
		{
			if(temp == null)
			{
				return;
			}
			tempPrev = temp;
			temp = temp.getLink();
		}

		if(temp == deleted)
		{
			tempPrev.setLink(temp.getLink());
		}


	}


	public CLLNode getPrevNode(CLLNode node)
	{
		if(head == null)
		{
			System.out.println("Single linked list is empty!");
		}
		else
		{
			CLLNode tempPrev = head;
			CLLNode temp = head.getLink();

			while(temp != node)
			{
				if(temp == null)
				{
					return null;
				}
				tempPrev = temp;
				temp = temp.getLink();
			}

			return tempPrev;


		}
		return null;
	}



	public void display()
	{
		if(head == null)
		{
			System.out.println("Single linked list is empty!");
		}
		else
		{
			CLLNode temp = head;
			while(temp!=null)
			{
				System.out.print(" "+(temp.getData()));//+" "+((Card)temp.getData()).getSuit()+" "+((Card)temp.getData()).getColour());
				temp = temp.getLink();
			}
		}
	}





	public CLLNode getHead() {
		return head;
	}

	public void setHead(CLLNode head) {
		this.head = head;
	}



}


