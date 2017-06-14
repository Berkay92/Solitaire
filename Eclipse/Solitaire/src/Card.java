
public class Card {
	private String suit;
	private String colour;
	private String strValue;
	private int intValue;
	private boolean isOpen;

	public Card(String suit,int value)
	{
		this.suit = suit;
		isOpen = false;
		intValue = value;
		if((suit.equals("heart")) || (suit.equals("diamond")))
		{
			colour = "red";
		}
		else
		{
			colour = "black";
		}

		if(value==14)
			this.strValue="A";
		else if(value==2)
			this.strValue="2";
		else if(value==3)
			this.strValue="3";
		else if(value==4)
			this.strValue="4";
		else if(value==5)
			this.strValue="5";
		else if(value==6)
			this.strValue="6";
		else if(value==7)
			this.strValue="7";
		else if(value==8)
			this.strValue="8";
		else if(value==9)
			this.strValue="9";
		else if(value==10)
			this.strValue="10";
		else if(value==11)
			this.strValue="J";
		else if(value==12)
			this.strValue="Q";
		else 
			this.strValue="K";


	}


	public Card(String suit,String value)
	{
		this.suit = suit;
		this.strValue = value;
		isOpen = true;
		if(suit.equals("heart") || suit.equals("diamond"))
		{
			colour = "red";
		}
		else
		{
			colour = "black";
		}

		if(value.equals("A"))
			this.intValue=14;
		else if(value.equals("2"))
			this.intValue=2;
		else if(value.equals("3"))
			this.intValue=3;
		else if(value.equals("4"))
			this.intValue=4;
		else if(value.equals("5"))
			this.intValue=5;
		else if(value.equals("6"))
			this.intValue=6;
		else if(value.equals("7"))
			this.intValue=7;
		else if(value.equals("8"))
			this.intValue=8;
		else if(value.equals("9"))
			this.intValue=9;
		else if(value.equals("10"))
			this.intValue=10;
		else if(value.equals("J"))
			this.intValue=11;
		else if(value.equals("Q"))
			this.intValue=12;
		else 
			this.intValue=13;


	}



	public Card() {
		isOpen = false;
	}

	public String getSuit() {
		return suit;
	}


	public String getColour() {
		return colour;
	}


	public String getStrValue() {
		return strValue;
	}

	public int getIntValue() {
		return intValue;
	}

	public boolean isOpen() {
		return isOpen;
	}



	public void setOpen(boolean isOpen) {
		this.isOpen = isOpen;
	}

	public void setSuit(String suit) {
		this.suit = suit;
		if(suit.equals("heart") || suit.equals("diamond"))
		{
			colour = "red";
		}
		else
		{
			colour = "black";
		}


	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public void setStrValue(String value) {

		this.strValue = value;

		if(value.equals("A"))
			this.intValue=14;
		else if(value.equals("2"))
			this.intValue=2;
		else if(value.equals("3"))
			this.intValue=3;
		else if(value.equals("4"))
			this.intValue=4;
		else if(value.equals("5"))
			this.intValue=5;
		else if(value.equals("6"))
			this.intValue=6;
		else if(value.equals("7"))
			this.intValue=7;
		else if(value.equals("8"))
			this.intValue=8;
		else if(value.equals("9"))
			this.intValue=9;
		else if(value.equals("10"))
			this.intValue=10;
		else if(value.equals("J"))
			this.intValue=11;
		else if(value.equals("Q"))
			this.intValue=12;
		else 
			this.intValue=13;

	}

	public void setIntValue(int value) {

		this.intValue = value;

		if(value==14)
			this.strValue="A";
		else if(value==2)
			this.strValue="2";
		else if(value==3)
			this.strValue="3";
		else if(value==4)
			this.strValue="4";
		else if(value==5)
			this.strValue="5";
		else if(value==6)
			this.strValue="6";
		else if(value==7)
			this.strValue="7";
		else if(value==8)
			this.strValue="8";
		else if(value==9)
			this.strValue="9";
		else if(value==10)
			this.strValue="10";
		else if(value==11)
			this.strValue="J";
		else if(value==12)
			this.strValue="Q";
		else 
			this.strValue="K";
	}




}
