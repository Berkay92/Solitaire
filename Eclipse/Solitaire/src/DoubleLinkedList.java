import enigma.core.Enigma;


public class DoubleLinkedList {
	DLLNode head;
	DLLNode tail;

	public enigma.console.Console cn = Enigma.getConsole("Solitaire",180,47,false);
	enigma.console.TextWindow window = cn.getTextWindow();

	public DoubleLinkedList() {

		head = null;
		tail = null;
	}

	public void add(Object data)
	{
		DLLNode newDLLNode = new DLLNode( data );

		if( head == null && tail == null  )
		{
			head = tail = newDLLNode;
		}
		else
		{
			// find place to insert 
			DLLNode current = head;	
			while( current != null && ((Player)current.getData()).getScore()<((Player)data).getScore() )
				current = current.getNext();

			if( current == head ) // add first
			{
				head.setPrev( newDLLNode );
				newDLLNode.setNext( head ); // ( if head == tail, no need to change tail , it still shows the last DLLNode )
				head = newDLLNode;
			}

			else if( current == null ) // add last
			{
				tail.setNext( newDLLNode );
				newDLLNode.setPrev( tail );
				tail = newDLLNode;
			}

			else
			{
				// add between
				newDLLNode.setNext( current );
				newDLLNode.setPrev( current.getPrev() );
				current.getPrev().setNext( newDLLNode );
				current.setPrev( newDLLNode );
			}
		}
	}

	public void remove( String inname,int inscore )
	{
		DLLNode temp = head;

		while(temp != null && (((Player)temp.getData()).getName().compareTo(inname)!=0)&&(((Player)temp.getData()).getScore()==inscore))
		{
			temp = temp.getNext();
		}

		// delete head
		if(temp == head)
		{
			if( head == tail ) // only 1 element in the list
			{
				head = tail = null;
			}
			else
			{
				head = head.getNext();
				head.setPrev( null );
			}
		}

		// delete tail
		else if( temp == tail )
		{
			tail.getPrev().setNext( null );
			tail = tail.getPrev();
		}
		else
		{
			// delete middle
			temp.getPrev().setNext( temp.getNext() );
			temp.getNext().setPrev( temp.getPrev() );
		}

	}

	public void display_ascending()
	{   int counter1=1;
	DLLNode temp = head;

	cn.getTextWindow().setCursorPosition(10, 8);
	System.out.println(" Ascending Order ");

	cn.getTextWindow().setCursorPosition(10, 9);
	System.out.println(" Name							Score ");

	cn.getTextWindow().setCursorPosition(10, 10);
	System.out.println("--------------------------------------");

	while(temp != null)
	{
		if(counter1 > 10)
			break;

		cn.getTextWindow().setCursorPosition(10, 10+counter1);
		System.out.println(counter1+".");
		cn.getTextWindow().setCursorPosition(13, 10+counter1);
		System.out.println(((Player)temp.getData()).getName());
		cn.getTextWindow().setCursorPosition(45, 10+counter1);
		System.out.println(((Player)temp.getData()).getScore());


		temp = temp.getNext();
		counter1++;
	}
	System.out.println();
	}

	public void display_descending()
	{   int counter2=1;
	DLLNode temp = tail;


	cn.getTextWindow().setCursorPosition(110, 8);
	System.out.println(" Descending Order ");

	cn.getTextWindow().setCursorPosition(110, 9);
	System.out.println(" Name							Score ");

	cn.getTextWindow().setCursorPosition(110, 10);
	System.out.println("--------------------------------------");


	while(temp != null)
	{   
		if(counter2 > 10)
			break;
		cn.getTextWindow().setCursorPosition(110, 10+counter2);
		System.out.println(counter2+".");
		cn.getTextWindow().setCursorPosition(113, 10+counter2);
		System.out.println(((Player)temp.getData()).getName());
		cn.getTextWindow().setCursorPosition(145, 10+counter2);
		System.out.println(((Player)temp.getData()).getScore());

		temp = temp.getPrev();
		counter2++;
	}
	System.out.println();
	}
}

