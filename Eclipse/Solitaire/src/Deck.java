import java.util.Random;

public class Deck {

	private SingleLinkedList deck;

	public Deck()
	{
		Card temp;
		String suit;
		deck = new SingleLinkedList();

		for(int i=0;i<4;i++)
		{
			for(int j=2;j<15;j++)
			{
				if(i==0)
					suit="heart";
				else if(i==1)
					suit="diamond";
				else if(i==2)
					suit="spade";
				else
					suit="club";

				temp = new Card(suit,j);

				deck.addToHead(temp);

			}
		}



	}



	public void shuffle()
	{
		if(deck.getHead() == null)
		{
			System.out.println("Deck has not been cretaed");
		}
		else
		{

			for(int a=0;a<100;a++)
			{
				Random rnd = new Random();
				int temp;

				do{
					temp = rnd.nextInt(51);
				}while(temp==0);

				SLLNode shuffleNode = deck.getHead().getNext_link();
				SLLNode tempNode = deck.getHead();

				for(int i=0;i<temp;i++)
				{
					tempNode = tempNode.getNext_link();
					shuffleNode = shuffleNode.getNext_link();
				}

				tempNode.setNext_link(shuffleNode.getNext_link());

				shuffleNode.setNext_link(deck.getHead());
				deck.setHead(shuffleNode);


			}
		}

	}



	public SingleLinkedList getDeck() {
		return deck;
	}



	public void setDeck(SingleLinkedList deck) {
		this.deck = deck;
	}


	public Card getCardFromTop()
	{
		return (Card)deck.getHead().getData();
	}

	public void throwCardFromTop()
	{
		deck.setHead(deck.getHead().getNext_link());
	}

	public boolean available()
	{
		if(deck.getHead() != null)
			return true;
		else
			return false;
	}


}
