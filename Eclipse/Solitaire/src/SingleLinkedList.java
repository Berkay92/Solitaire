
public class SingleLinkedList {

	private SLLNode head;
	private int elementNumber;

	public SingleLinkedList()
	{
		head = null;
		elementNumber = 0;
	}

	public SingleLinkedList(Object head)
	{
		SLLNode headNode = new SLLNode(head);
		this.head = headNode;
		elementNumber = 1;
	}	

	public void addToHead(Object current) 
	{

		if(head == null)
		{
			SLLNode temp = new SLLNode(current);
			head = temp;
		}
		else  
		{
			SLLNode headNode = new SLLNode(current);
			headNode.setNext_link(head);
			head = headNode;
		}

		elementNumber++;

	}


	public void addToLast(Object current)  
	{

		if(head == null)
		{
			SLLNode temp = new SLLNode(current);
			head = temp;
		}
		else  
		{
			SLLNode temp = head;
			while(temp.getNext_link() != null)
			{
				temp = temp.getNext_link();
			}
			SLLNode newNode = new SLLNode(current);
			temp.setNext_link(newNode);
		}

		elementNumber++;

	}

	public void deleteFromHead()
	{
		if(head == null)
		{
			System.out.println("There is no item for deleting!");
		}
		else
		{
			head = head.getNext_link();
		}
	}


	public void display()
	{
		if(head == null)
		{
			System.out.println("Single linked list is empty!");
		}
		else
		{
			SLLNode temp = head;
			while(temp!=null)
			{
				System.out.print(" "+(temp.getData()));
				temp = temp.getNext_link();
			}
		}
	}



	public int elementNumber()
	{

		return elementNumber;
	}



	public SLLNode getHead() {
		return head;
	}

	public void setHead(SLLNode head) {
		this.head = head;
	}



}
