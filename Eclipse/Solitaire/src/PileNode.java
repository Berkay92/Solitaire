
public class PileNode {

	private int intPileNumber;
	private String strPileNumber;
	private PileNode right;
	private CardNode down;
	
	public PileNode(String pileNumber)
	{
		this.strPileNumber = pileNumber;
		if(pileNumber.equals("P1"))
		{
			intPileNumber = 1;
		}
		else if(pileNumber.equals("P2"))
		{
			intPileNumber = 2;
		}
		else if(pileNumber.equals("P3"))
		{
			intPileNumber = 3;
		}
		else if(pileNumber.equals("P4"))
		{
			intPileNumber = 4;
		}
		else if(pileNumber.equals("P5"))
		{
			intPileNumber = 5;
		}
		else if(pileNumber.equals("P6"))
		{
			intPileNumber = 6;
		}
		else if(pileNumber.equals("P7"))
		{
			intPileNumber = 7;
		}
		right = null;
		down = null;
	}

	public String getstrPileNumber() {
		return strPileNumber;
	}

	public int getintPileNumber() {
		return intPileNumber;
	}

	public PileNode getRight() {
		return right;
	}

	public void setRight(PileNode right) {
		this.right = right;
	}

	public CardNode getDown() {
		return down;
	}

	public void setDown(CardNode down) {
		this.down = down;
	}
	
	
}
