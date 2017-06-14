import java.awt.Color;

import enigma.console.TextAttributes;
import enigma.core.Enigma;

public class MultiLinkedList {

	public enigma.console.Console cn = Enigma.getConsole("Solitaire", 180, 47,
			false);
	enigma.console.TextWindow window = cn.getTextWindow();

	private PileNode head;


	public MultiLinkedList() {
		head = null;

	}

	public void addPileToRight(String PileNumber) {
		PileNode temp;
		if (head == null) {
			temp = new PileNode(PileNumber);
			head = temp;
		} else {
			temp = head;
			while (temp.getRight() != null) {
				temp = temp.getRight();
			}
			PileNode newNode = new PileNode(PileNumber);
			temp.setRight(newNode);
		}

	}

	public void addCard(String pileNumber, Card card) {
		if (head == null) {
			System.out.println("Add a pile before card");
		} else {
			PileNode tempPile = head;
			while (tempPile != null) {
				if (pileNumber.equals(tempPile.getstrPileNumber())) {
					CardNode tempCard = tempPile.getDown();
					if (tempCard == null) {
						tempCard = new CardNode(card);
						tempPile.setDown(tempCard);
					} else {
						while (tempCard.getNext() != null) {
							tempCard = tempCard.getNext();
						}
						CardNode newNode = new CardNode(card);
						tempCard.setNext(newNode);
					}
				}
				tempPile = tempPile.getRight();

			}
		}

	}

	public void addCard(int pileNumber, Card card) {
		if (head == null) {
			System.out.println("Add a pile before card");
		} else {
			PileNode tempPile = head;
			while (tempPile != null) {
				if (pileNumber == tempPile.getintPileNumber()) {
					CardNode tempCard = tempPile.getDown();
					if (tempCard == null) {
						tempCard = new CardNode(card);
						tempPile.setDown(tempCard);
					} else {
						while (tempCard.getNext() != null) {
							tempCard = tempCard.getNext();
						}
						CardNode newNode = new CardNode(card);
						tempCard.setNext(newNode);
					}
				}
				tempPile = tempPile.getRight();

			}
		}

	}

	public PileNode getPile(String pileNumber) {
		if (head == null) {
			System.err.println("Pile has not been created");
			return null;
		} else {
			PileNode tempPile = head;
			while (tempPile != null) {
				if (pileNumber.equals(tempPile.getstrPileNumber())) {
					return tempPile;
				}
				tempPile = tempPile.getRight();

			}
		}
		return null;

	}

	public CardNode getCardNode(String pileNumber, Card card) {
		if (head == null) {
			return null;
		} else {
			PileNode tempPile = getPile(pileNumber);
			CardNode tempCard = tempPile.getDown();
			while (tempCard != null) {

				if (tempCard.getCard().getSuit().equals(card.getSuit())
						&& tempCard.getCard().getIntValue() == card
						.getIntValue()) {
					return tempCard;
				}

				tempCard = tempCard.getNext();

			}

			return null;

		}
	}


	public void setCardNodeNull(String pileNumber,CardNode cardNode)
	{

		PileNode tempPile = getPile(pileNumber);
		CardNode tempprevCard = tempPile.getDown();

		if(tempprevCard == cardNode)
		{
			tempPile.setDown(null);
			return;
		}


		CardNode tempCard = tempprevCard.getNext();



		if(tempCard == null && tempprevCard != null )
		{
			tempPile.setDown(null);

		}


		else
		{


			while (tempCard != cardNode) {


				tempprevCard = tempCard;
				tempCard = tempCard.getNext();

			}

			if (tempCard.getCard().getSuit().equals(cardNode.getCard().getSuit())
					&& tempCard.getCard().getIntValue() == cardNode.getCard().getIntValue()) {

				getCardNode(pileNumber, tempprevCard.getCard()).setNext(null);

			}


		}

	}


	public Card getCard(String pileNumber, Card card) {
		if (head == null) {
			return null;
		} else {
			PileNode tempPile = getPile(pileNumber);
			CardNode tempCard = tempPile.getDown();
			while (tempCard != null) {
				if (tempCard.getCard().getSuit().equals(card.getSuit())
						&& tempCard.getCard().getIntValue() == card
						.getIntValue()) {
					return tempCard.getCard();
				}

				tempCard = tempCard.getNext();

			}

			return null;

		}
	}

	public Card getLastCard(String pileNumber) {

		if (getPile(pileNumber) == null) {
			return null;
		} else {
			CardNode tempCard = getPile(pileNumber).getDown();
			if (tempCard == null) {
				return null;
			} else {
				while (tempCard.getNext() != null) {
					tempCard = tempCard.getNext();
				}

				return tempCard.getCard();
			}

		}

	}

	public void display() {

		Pile firstPile = new Pile(1);
		Pile secondPile = new Pile(2);
		Pile thirdPile = new Pile(3);
		Pile fourthPile = new Pile(4);
		Pile fifthPile = new Pile(5);
		Pile sixthPile = new Pile(6);
		Pile seventhPile = new Pile(7);

		PileNode tempPileNode = head;
		CardNode tempCardNode;

		tempCardNode = tempPileNode.getDown();

		for(int i=45;i<cn.getTextWindow().getColumns();i++)
		{
			for(int j=2;j<cn.getTextWindow().getRows();j++)
			{
				cn.getTextWindow().output(i, j, ' ');

			}

		}

		while (tempCardNode != null) {
			cardDisplay(firstPile, tempCardNode.getCard());
			tempCardNode = tempCardNode.getNext();
		}

		tempPileNode = tempPileNode.getRight();
		tempCardNode = tempPileNode.getDown();

		while (tempCardNode != null) {
			cardDisplay(secondPile, tempCardNode.getCard());
			tempCardNode = tempCardNode.getNext();
		}

		tempPileNode = tempPileNode.getRight();
		tempCardNode = tempPileNode.getDown();

		while (tempCardNode != null) {
			cardDisplay(thirdPile, tempCardNode.getCard());
			tempCardNode = tempCardNode.getNext();
		}

		tempPileNode = tempPileNode.getRight();
		tempCardNode = tempPileNode.getDown();

		while (tempCardNode != null) {
			cardDisplay(fourthPile, tempCardNode.getCard());
			tempCardNode = tempCardNode.getNext();
		}

		tempPileNode = tempPileNode.getRight();
		tempCardNode = tempPileNode.getDown();

		while (tempCardNode != null) {
			cardDisplay(fifthPile, tempCardNode.getCard());
			tempCardNode = tempCardNode.getNext();
		}

		tempPileNode = tempPileNode.getRight();
		tempCardNode = tempPileNode.getDown();

		while (tempCardNode != null) {
			cardDisplay(sixthPile, tempCardNode.getCard());
			tempCardNode = tempCardNode.getNext();
		}

		tempPileNode = tempPileNode.getRight();
		tempCardNode = tempPileNode.getDown();

		while (tempCardNode != null) {
			cardDisplay(seventhPile, tempCardNode.getCard());
			tempCardNode = tempCardNode.getNext();
		}

	}

	public void cardDisplay(Pile pile, Card card) {
		String suit = card.getSuit();
		String value = card.getStrValue();
		Color backgr;
		if (card.isOpen()) {
			backgr = Color.WHITE;
		} else {
			backgr = Color.ORANGE;
		}
		Color foregr = null;
		String symbol = null;

		if (suit.equals("heart")) {
			foregr = Color.RED;
			symbol = "♥";
		} else if (suit.equals("diamond")) {
			foregr = Color.RED;
			symbol = "♦";
		} else if (suit.equals("spade")) {
			foregr = Color.BLACK;
			symbol = "♠";
		} else if (suit.equals("club")) {
			foregr = Color.BLACK;
			symbol = "♣";
		}

		int last_i = pile.getCurrentPoint_x() + 10;
		int last_j = pile.getCurrentPoint_y() + 8;

		for (int i = pile.getCurrentPoint_x(); i < last_i; i++) {
			for (int j = pile.getCurrentPoint_y(); j < last_j; j++) {

				if (card.isOpen()) {

					print(i, j, " ", foregr, backgr);
				} else {
					print(i, j, " ", foregr, backgr);
				}
			}

		}

		if (card.isOpen()) {

			for (int i = pile.getCurrentPoint_x(); i < last_i; i++) {
				for (int j = pile.getCurrentPoint_y(); j < last_j; j++) {
					if ((i == pile.getCurrentPoint_x() && j == pile
							.getCurrentPoint_y())
							|| (i == pile.getCurrentPoint_x() + 8 && j == pile
							.getCurrentPoint_y() + 7)) {
						print(i, j, value, foregr, backgr);
					}

					else if ((i == pile.getCurrentPoint_x() && j == pile
							.getCurrentPoint_y() + 1)
							|| (i == pile.getCurrentPoint_x() + 8 && j == pile
							.getCurrentPoint_y() + 6)) {
						print(i, j, symbol + " ", foregr, backgr);
					}
				}

			}
		}


		if (pile.getPileLinked().elementNumber() != 0)
		{
			if(pile.getNumber() == 1 || pile.getNumber() == 2 || pile.getNumber() ==3 || pile.getNumber() ==4 || pile.getNumber() ==5 || pile.getNumber() ==6 || pile.getNumber() == 7)
				print(pile.getCurrentPoint_x(), pile.getCurrentPoint_y() - 1,"----------", Color.BLACK, backgr);

		}

		pile.add(card);

	}


	public void deleteDisplay(Pile pile, Card card) {


		int last_i = pile.getCurrentPoint_x() + 10;
		int last_j = pile.getCurrentPoint_y() + 8;

		for (int i = pile.getCurrentPoint_x(); i < last_i; i++) {
			for (int j = pile.getCurrentPoint_y(); j < last_j; j++) {

				print(i, j, " ");

			}

		}



	}





	public void print(int x_coordinate, int y_coordinate, String output) {

		window.setCursorPosition(x_coordinate, y_coordinate);
		window.output(output);

	}

	public void print(int x_coordinate, int y_coordinate, char value,
			Color foreground, Color background) {

		TextAttributes attrs = new TextAttributes(foreground, background);
		window.output(value, attrs);

	}

	public void print(int x_coordinate, int y_coordinate, String value,
			Color foreground, Color background) {

		window.setCursorPosition(x_coordinate, y_coordinate);
		TextAttributes attrs = new TextAttributes(foreground, background);
		window.output(value, attrs);

	}

}
