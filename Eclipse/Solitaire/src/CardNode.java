
public class CardNode {

	private Card card;
	private CardNode next;

	public CardNode(Card newCard)
	{
		card = newCard;
		next = null;
	}

	public Card getCard() {
		return card;
	}

	public void setCard(Card card) {
		this.card = card;
	}

	public CardNode getNext() {
		return next;
	}

	public void setNext(CardNode next) {
		this.next = next;
	}


}
