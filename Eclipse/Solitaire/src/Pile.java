
public class Pile {

	private SingleLinkedList PileLinked;
	private int number;
	private int currentPoint_x;
	private int currentPoint_y;

	public Pile(int number)
	{
		PileLinked = new SingleLinkedList();
		this.number = number;
		if(number == 1) 
		{
			currentPoint_x = 45;
			currentPoint_y = 2;
		}
		else if(number == 2) 
		{
			currentPoint_x = 65;
			currentPoint_y = 2;
		}
		else if(number == 3)
		{
			currentPoint_x = 85;
			currentPoint_y = 2;
		}
		else if(number == 4)
		{
			currentPoint_x = 105;
			currentPoint_y = 2;
		}
		else if(number == 5)
		{
			currentPoint_x = 125;
			currentPoint_y = 2;
		}
		else if(number == 6)
		{
			currentPoint_x = 145;
			currentPoint_y = 2;
		}
		else if(number == 7)
		{
			currentPoint_x = 165;
			currentPoint_y = 2;
		}




	}




	public Pile(String stackType)
	{
		PileLinked = new SingleLinkedList();


		if(stackType.equals("Club")) 
		{
			number = 8;
			currentPoint_x = 5;
			currentPoint_y = 15;
		}
		else if(stackType.equals("Spade")) 
		{
			number = 9;
			currentPoint_x = 5;
			currentPoint_y = 26;
		}
		else if(stackType.equals("Diamond"))
		{
			number = 10;
			currentPoint_x = 25;
			currentPoint_y = 15;
		}
		else if(stackType.equals("Heart"))
		{
			number = 11;
			currentPoint_x = 25;
			currentPoint_y = 26;
		}
		else if(stackType.equals("Stock"))
		{
			number = 12;
			currentPoint_x = 25;
			currentPoint_y = 2;
		}
		else if(stackType.equals("StockLeft"))
		{
			number = 12;
			currentPoint_x = 5;
			currentPoint_y = 2;
		}

	}


	public void add (Card newCard)
	{

		PileLinked.addToHead(newCard);
		if(number==1 || number==2 || number==3 || number==4 || number==5 || number==6 || number == 7)
		{
			currentPoint_y+=3;
		}
	}



	public int getCurrentPoint_x() {
		return currentPoint_x;
	}



	public int getCurrentPoint_y() {
		return currentPoint_y;
	}


	public int getNumber() {
		return number;
	}

	public SingleLinkedList getPileLinked() {
		return PileLinked;
	}


}
