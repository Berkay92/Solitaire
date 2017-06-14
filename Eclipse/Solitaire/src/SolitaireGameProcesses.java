import java.awt.Color;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;
import enigma.console.TextAttributes;
import enigma.core.Enigma;



public class SolitaireGameProcesses{
	public enigma.console.Console cn = Enigma.getConsole("Solitaire",180,47,false);
	enigma.console.TextWindow window = cn.getTextWindow();



	public SolitaireGameProcesses() throws Exception {	

		Deck myDeck = new Deck();
		myDeck.shuffle();

		MultiLinkedList multi = new MultiLinkedList();
		multi.addPileToRight("P1");
		multi.addPileToRight("P2");
		multi.addPileToRight("P3");
		multi.addPileToRight("P4");
		multi.addPileToRight("P5");
		multi.addPileToRight("P6");
		multi.addPileToRight("P7");

		for(int i=2;i<45;i++)
		{
			print(41, i, "|");
		}		

		for(int i=4;i<40;i+=2)
		{
			print(i,11,"_");
		}

		for(int i=4;i<40;i+=2)
		{
			print(i,36,"_");
		}


		print(49, 0, "P1");
		print(49+20, 0 , "P2");
		print(49+(20*2), 0 , "P3");
		print(49+(20*3), 0 , "P4");
		print(49+(20*4), 0 , "P5");
		print(49+(20*5), 0 , "P6");
		print(49+(20*6), 0 , "P7");

		print(9, 0 , "ST");
		print(25,0,"Score : ");

		print(9, 14 , "OC");
		print(9, 25, "OS");
		print(29, 14 , "OD");
		print(29, 25 , "OH");


		for(int i=1;i<=7;i++)
		{
			int temp = i;
			while(temp > 0)
			{
				multi.addCard(i, myDeck.getCardFromTop());

				if(temp == 1) 
				{
					myDeck.getCardFromTop().setOpen(true);
				}

				myDeck.throwCardFromTop();
				temp--;
			}

		}

		multi.display();


		CircularLinkedList stockList = new CircularLinkedList();



		while(myDeck.available())
		{
			stockList.addLast(myDeck.getCardFromTop());

			myDeck.throwCardFromTop();
		}

		Pile stckLeft = new Pile("StockLeft");
		Pile stock = new Pile("Stock");
		Pile heart = new Pile("Heart") ;
		Pile diamond = new Pile("Diamond");
		Pile spade = new Pile("Spade");
		Pile club = new Pile("Club");

		Stack stckHeart = new Stack(15);
		Stack stckDiamond = new Stack(15);
		Stack stckSpade = new Stack(15);
		Stack stckClub = new Stack(15);


		boolean endGame = false;
		int score = 0;
		Scanner scn = new Scanner(System.in);
		String from,to,startType;

		Card chosenCard = new Card();



		while(!endGame)
		{

			print(33,0,""+score);


			((Card)stockList.getHead().getData()).setOpen(false);
			multi.cardDisplay(stckLeft, (Card)stockList.getHead().getData());
			((Card)stockList.getHead().getData()).setOpen(true);
			multi.cardDisplay(stock, (Card)stockList.getHead().getData());


			print (5,38,"                                 ");
			print (5,39,"                                 ");
			print (5,40,"                                 ");
			print (5,41,"                                 ");

			print(5, 38,"> From : ");
			from = scn.next();

			if(from.equals("E"))
			{
				break;
				//System.exit(0);
			}

			print(5, 39, "> To : ");
			to = scn.next();


			if(from.equals("ST") && to.equals("ST"))
			{

				stockList.setHead(stockList.getHead().getLink());
				((Card)stockList.getHead().getData()).setOpen(true);
				multi.cardDisplay(stock, (Card)stockList.getHead().getData());

			}


			else if((from.equals("ST")) && ((to.equals("P1") || to.equals("P2") || to.equals("P3") || to.equals("P4") || to.equals("P5") || to.equals("P6") || to.equals("P7") || to.equals("OC") || to.equals("OS") || to.equals("OD") || to.equals("OH"))))
			{
				if(to.equals("OC") && ((Card)stockList.getHead().getData()).getSuit().equals("club"))
				{
					if(stckClub.isEmpty() && ((Card)stockList.getHead().getData()).getSuit().equals("club") && ((Card)stockList.getHead().getData()).getStrValue().equals("A"))	
					{
						//print(50,50,"1");
						stckClub.push((Card)stockList.getHead().getData());
						stockList.setHead(stockList.getHead().getLink());
						stockList.delete(stockList.getPrevNode(stockList.getHead()));
						multi.cardDisplay(club, (Card)stckClub.peek());
						score+=10;
					}

					else if(((Card)stckClub.peek()).getSuit().equals("club") && ((Card)stckClub.peek()).getStrValue().equals("A") &&  ((Card)stockList.getHead().getData()).getSuit().equals("club") && ((Card)stockList.getHead().getData()).getStrValue().equals("2"))
					{
						stckClub.push((Card)stockList.getHead().getData());
						stockList.setHead(stockList.getHead().getLink());
						stockList.delete(stockList.getPrevNode(stockList.getHead()));
						multi.cardDisplay(club, (Card)stckClub.peek());
						score+=10;
					}

					else if((((Card)stckClub.peek()).getIntValue() + 1 == ((Card)stockList.getHead().getData()).getIntValue())  && ((Card)stckClub.peek()).getSuit().equals("club"))
					{
						stckClub.push((Card)stockList.getHead().getData());
						stockList.setHead(stockList.getHead().getLink());
						stockList.delete(stockList.getPrevNode(stockList.getHead()));
						multi.cardDisplay(club, (Card)stckClub.peek());
						score+=10;
					}


				}

				else if(to.equals("OS")  && ((Card)stockList.getHead().getData()).getSuit().equals("spade"))
				{
					if(stckSpade.isEmpty() && ((Card)stockList.getHead().getData()).getSuit().equals("spade") && ((Card)stockList.getHead().getData()).getStrValue().equals("A"))	
					{
						//print(50,50,"2");
						stckSpade.push((Card)stockList.getHead().getData());
						stockList.setHead(stockList.getHead().getLink());
						stockList.delete(stockList.getPrevNode(stockList.getHead()));
						multi.cardDisplay(spade, (Card)stckSpade.peek());
						score+=10;
					}

					else if(((Card)stckSpade.peek()).getSuit().equals("spade") && ((Card)stckSpade.peek()).getStrValue().equals("A") &&  ((Card)stockList.getHead().getData()).getSuit().equals("spade") && ((Card)stockList.getHead().getData()).getStrValue().equals("2"))
					{
						stckSpade.push((Card)stockList.getHead().getData());
						stockList.setHead(stockList.getHead().getLink());
						stockList.delete(stockList.getPrevNode(stockList.getHead()));
						multi.cardDisplay(spade, (Card)stckSpade.peek());
						score+=10;
					}

					else if((((Card)stckSpade.peek()).getIntValue() + 1 == ((Card)stockList.getHead().getData()).getIntValue())  && ((Card)stckSpade.peek()).getSuit().equals("spade"))
					{
						stckSpade.push((Card)stockList.getHead().getData());
						stockList.setHead(stockList.getHead().getLink());
						stockList.delete(stockList.getPrevNode(stockList.getHead()));
						multi.cardDisplay(spade, (Card)stckSpade.peek());
						score+=10;
					}


				}

				else if(to.equals("OD") && ((Card)stockList.getHead().getData()).getSuit().equals("diamond"))
				{
					if(stckDiamond.isEmpty() && ((Card)stockList.getHead().getData()).getSuit().equals("diamond") && ((Card)stockList.getHead().getData()).getStrValue().equals("A"))	
					{
						//print(50,50,"3");
						stckDiamond.push((Card)stockList.getHead().getData());
						stockList.setHead(stockList.getHead().getLink());
						stockList.delete(stockList.getPrevNode(stockList.getHead()));
						multi.cardDisplay(diamond, (Card)stckDiamond.peek());
						score+=10;
					}

					else if(((Card)stckDiamond.peek()).getSuit().equals("diamond") && ((Card)stckDiamond.peek()).getStrValue().equals("A") &&  ((Card)stockList.getHead().getData()).getSuit().equals("diamond") && ((Card)stockList.getHead().getData()).getStrValue().equals("2"))
					{
						stckDiamond.push((Card)stockList.getHead().getData());
						stockList.setHead(stockList.getHead().getLink());
						stockList.delete(stockList.getPrevNode(stockList.getHead()));
						multi.cardDisplay(diamond, (Card)stckDiamond.peek());
						score+=10;
					}

					else if((((Card)stckDiamond.peek()).getIntValue() + 1 == ((Card)stockList.getHead().getData()).getIntValue())  && ((Card)stckDiamond.peek()).getSuit().equals("diamond"))
					{
						stckDiamond.push((Card)stockList.getHead().getData());
						stockList.setHead(stockList.getHead().getLink());
						stockList.delete(stockList.getPrevNode(stockList.getHead()));
						multi.cardDisplay(diamond, (Card)stckDiamond.peek());
						score+=10;
					}


				}
				else if(to.equals("OH") && ((Card)stockList.getHead().getData()).getSuit().equals("heart"))
				{
					if(stckHeart.isEmpty() && ((Card)stockList.getHead().getData()).getSuit().equals("heart") && ((Card)stockList.getHead().getData()).getStrValue().equals("A"))	
					{

						stckHeart.push((Card)stockList.getHead().getData());
						stockList.setHead(stockList.getHead().getLink());
						stockList.delete(stockList.getPrevNode(stockList.getHead()));
						multi.cardDisplay(heart, (Card)stckHeart.peek());
						score+=10;
					}

					else if(((Card)stckHeart.peek()).getSuit().equals("heart") && ((Card)stckHeart.peek()).getStrValue().equals("A") &&  ((Card)stockList.getHead().getData()).getSuit().equals("heart") && ((Card)stockList.getHead().getData()).getStrValue().equals("2"))
					{
						stckHeart.push((Card)stockList.getHead().getData());
						stockList.setHead(stockList.getHead().getLink());
						stockList.delete(stockList.getPrevNode(stockList.getHead()));
						multi.cardDisplay(heart, (Card)stckHeart.peek());
						score+=10;
					}

					else if((((Card)stckHeart.peek()).getIntValue() + 1 == ((Card)stockList.getHead().getData()).getIntValue())  && ((Card)stckHeart.peek()).getSuit().equals("heart"))
					{
						stckHeart.push((Card)stockList.getHead().getData());
						stockList.setHead(stockList.getHead().getLink());
						stockList.delete(stockList.getPrevNode(stockList.getHead()));
						multi.cardDisplay(heart, (Card)stckHeart.peek());
						score+=10;
					}


				}

				else if(!to.equals("OC") && !to.equals("OS") && !to.equals("OD") && !to.equals("OH"))

				{
					if(multi.getPile(to).getDown() == null)
					{
						if(((Card)stockList.getHead().getData()).getStrValue().equals("K"))
						{
							CardNode newNode = new CardNode(((Card)stockList.getHead().getData()));
							multi.getPile(to).setDown(newNode);

							if(stockList.getHead().getLink() != stockList.getHead())
							{
								stockList.setHead(stockList.getHead().getLink());
								stockList.delete(stockList.getPrevNode(stockList.getHead()));
							}

							multi.display();
						}
					}

					else if((!multi.getLastCard(to).getColour().equals(((Card)stockList.getHead().getData()).getColour())) & (multi.getLastCard(to).getIntValue()-1 == ((Card)stockList.getHead().getData()).getIntValue()))
					{
						CardNode addNode = new CardNode(((Card)stockList.getHead().getData()));
						multi.getCardNode(to, multi.getLastCard(to)).setNext(addNode);
						multi.display();
						multi.deleteDisplay(stock, ((Card)stockList.getHead().getData()));
						stockList.setHead(stockList.getHead().getLink());
						stockList.delete(stockList.getPrevNode(stockList.getHead()));
						score+=5;
					}


				}



			}


			else if((from.equals("P1") || from.equals("P2") || from.equals("P3") || from.equals("P4") || from.equals("P5") || from.equals("P6") || from.equals("P7")) && to.equals("OC") || to.equals("OS") || to.equals("OD") || to.equals("OH"))
			{
				if(to.equals("OC") && multi.getLastCard(from).getSuit().equals("club"))
				{
					if(stckClub.isEmpty() && (multi.getLastCard(from).getSuit().equals("club") && multi.getLastCard(from).getStrValue().equals("A")))
					{

						stckClub.push(multi.getLastCard(from));
						multi.setCardNodeNull(from, multi.getCardNode(from, multi.getLastCard(from)));					
						multi.cardDisplay(club, (Card)stckClub.peek());
						score+=10;
					}

					else if(((Card)stckClub.peek()).getSuit().equals("club") && ((Card)stckClub.peek()).getStrValue().equals("A") &&  (multi.getLastCard(from).getSuit().equals("club") && (multi.getLastCard(from).getStrValue().equals("2"))))
					{
						stckClub.push(multi.getLastCard(from));
						multi.setCardNodeNull(from, multi.getCardNode(from, multi.getLastCard(from)));					
						multi.cardDisplay(club, (Card)stckClub.peek());
						score+=10;
					}

					else if(((Card)stckClub.peek()).getSuit().equals("club") && ((Card)stckClub.peek()).getIntValue() + 1 == (multi.getLastCard(from).getIntValue()))
					{
						stckClub.push(multi.getLastCard(from));
						multi.setCardNodeNull(from, multi.getCardNode(from, multi.getLastCard(from)));					
						multi.cardDisplay(club, (Card)stckClub.peek());
						score+=10;
					}


				}

				else if(to.equals("OS") && multi.getLastCard(from).getSuit().equals("spade"))
				{

					if(stckSpade.isEmpty() && (multi.getLastCard(from).getSuit().equals("spade") && multi.getLastCard(from).getStrValue().equals("A")))
					{

						stckSpade.push(multi.getLastCard(from));
						multi.setCardNodeNull(from, multi.getCardNode(from, multi.getLastCard(from)));					
						multi.cardDisplay(spade, (Card)stckSpade.peek());
						score+=10;
					}

					else if(((Card)stckSpade.peek()).getSuit().equals("spade") && ((Card)stckSpade.peek()).getStrValue().equals("A") &&  (multi.getLastCard(from).getSuit().equals("spade") && (multi.getLastCard(from).getStrValue().equals("2"))))
					{
						stckSpade.push(multi.getLastCard(from));
						multi.setCardNodeNull(from, multi.getCardNode(from, multi.getLastCard(from)));					
						multi.cardDisplay(spade, (Card)stckSpade.peek());
						score+=10;
					}

					else if(((Card)stckSpade.peek()).getSuit().equals("spade") && ((Card)stckSpade.peek()).getIntValue() + 1 == (multi.getLastCard(from).getIntValue()))
					{
						stckSpade.push(multi.getLastCard(from));
						multi.setCardNodeNull(from, multi.getCardNode(from, multi.getLastCard(from)));					
						multi.cardDisplay(spade, (Card)stckSpade.peek());
						score+=10;
					}



				}

				else if(to.equals("OD") && multi.getLastCard(from).getSuit().equals("diamond"))
				{

					if(stckDiamond.isEmpty() && (multi.getLastCard(from).getSuit().equals("diamond") && multi.getLastCard(from).getStrValue().equals("A")))
					{

						stckDiamond.push(multi.getLastCard(from));
						multi.setCardNodeNull(from, multi.getCardNode(from, multi.getLastCard(from)));					
						multi.cardDisplay(diamond, (Card)stckDiamond.peek());
						score+=10;
					}

					else if(((Card)stckDiamond.peek()).getSuit().equals("diamond") && ((Card)stckDiamond.peek()).getStrValue().equals("A") &&  (multi.getLastCard(from).getSuit().equals("diamond") && (multi.getLastCard(from).getStrValue().equals("2"))))
					{
						stckDiamond.push(multi.getLastCard(from));
						multi.setCardNodeNull(from, multi.getCardNode(from, multi.getLastCard(from)));					
						multi.cardDisplay(diamond, (Card)stckDiamond.peek());
						score+=10;
					}

					else if(((Card)stckDiamond.peek()).getSuit().equals("diamond") && ((Card)stckDiamond.peek()).getIntValue() + 1 == (multi.getLastCard(from).getIntValue()))
					{
						stckDiamond.push(multi.getLastCard(from));
						multi.setCardNodeNull(from, multi.getCardNode(from, multi.getLastCard(from)));					
						multi.cardDisplay(diamond, (Card)stckDiamond.peek());
						score+=10;
					}


				}
				else if(to.equals("OH") && multi.getLastCard(from).getSuit().equals("heart"))
				{

					if(stckHeart.isEmpty() && (multi.getLastCard(from).getSuit().equals("heart") && multi.getLastCard(from).getStrValue().equals("A")))
					{

						stckHeart.push(multi.getLastCard(from));
						multi.setCardNodeNull(from, multi.getCardNode(from, multi.getLastCard(from)));					
						multi.cardDisplay(heart, (Card)stckHeart.peek());
						score+=10;
					}

					else if(((Card)stckHeart.peek()).getSuit().equals("heart") && ((Card)stckHeart.peek()).getStrValue().equals("A") &&  (multi.getLastCard(from).getSuit().equals("heart") && (multi.getLastCard(from).getStrValue().equals("2"))))
					{
						stckHeart.push(multi.getLastCard(from));
						multi.setCardNodeNull(from, multi.getCardNode(from, multi.getLastCard(from)));					
						multi.cardDisplay(heart, (Card)stckHeart.peek());
						score+=10;
					}

					else if(((Card)stckHeart.peek()).getSuit().equals("heart") && ((Card)stckHeart.peek()).getIntValue() + 1 == (multi.getLastCard(from).getIntValue()))
					{
						stckHeart.push(multi.getLastCard(from));
						multi.setCardNodeNull(from, multi.getCardNode(from, multi.getLastCard(from)));					
						multi.cardDisplay(heart, (Card)stckHeart.peek());
						score+=10;
					}

				}


				if(multi.getLastCard(from) != null)
				{
					multi.getLastCard(from).setOpen(true);
				}


				multi.display();

			}


			else if((from.equals("P1") || from.equals("P2") || from.equals("P3") || from.equals("P4") || from.equals("P5") || from.equals("P6") || from.equals("P7")) && ((to.equals("P1") || to.equals("P2") || to.equals("P3") || to.equals("P4") || to.equals("P5") || to.equals("P6") || to.equals("P7") || to.equals("OC") || to.equals("OS") || to.equals("OD") || to.equals("OH"))))
			{



				print(5, 40,"> Start card : ");
				startType = scn.next();


				String suit = null;

				if(startType.charAt(0) == 'C')
				{
					suit = "club";
				}

				else if(startType.charAt(0) == 'D')
				{
					suit = "diamond";
				}

				else if(startType.charAt(0) == 'S')
				{
					suit = "spade";
				}
				else if(startType.charAt(0) == 'H')
				{
					suit = "heart";
				}


				String value;

				if(startType.length() == 3)
				{
					value = startType.substring(1, 3);
				}
				else
				{
					value = startType.substring(1, 2);
				}


				if(suit != null)
				{
					chosenCard.setSuit(suit);
					chosenCard.setStrValue(value);



					if(multi.getPile(from) != null)
					{
						if(multi.getCardNode(from, chosenCard) != null && multi.getCard(from, chosenCard).isOpen())
						{
							if(multi.getPile(to).getDown() == null )
							{
								if(multi.getCardNode(from, chosenCard).getCard().getStrValue().equals("K"))
								{
									multi.getPile(to).setDown(multi.getCardNode(from, chosenCard));
									multi.setCardNodeNull(from, multi.getCardNode(from, chosenCard));

									if(multi.getLastCard(from) != null)
									{
										multi.getLastCard(from).setOpen(true);
									}


									score+=5;
									multi.display();
								}
							}
							else if((!multi.getLastCard(to).getColour().equals(multi.getCard(from, chosenCard).getColour())) & (multi.getLastCard(to).getIntValue()-1 == multi.getCard(from, chosenCard).getIntValue()))
							{

								multi.getCardNode(to, multi.getLastCard(to)).setNext(multi.getCardNode(from, chosenCard));




								multi.setCardNodeNull(from, multi.getCardNode(from, chosenCard));


								if(multi.getLastCard(from) != null)
								{
									multi.getLastCard(from).setOpen(true);
								}


								score+=5;
								multi.display();
							}

						}

					}


				}


				if(!stckClub.isEmpty() && !stckDiamond.isEmpty() && !stckHeart.isEmpty() && !stckSpade.isEmpty())	
				{
					if(((Card)stckClub.peek()).getStrValue().equals("K") && ((Card)stckDiamond.peek()).getStrValue().equals("K") && ((Card)stckHeart.peek()).getStrValue().equals("K") && ((Card)stckSpade.peek()).getStrValue().equals("K"))
					{
						print(5, 38,"Game over");

						break;
					}
				}

			}
		}//End of while


		for(int i=0;i<cn.getTextWindow().getColumns();i++)
		{
			for(int j=0;j<cn.getTextWindow().getRows();j++)
			{
				print(i, j, " ");
			}
		}

		String strScore = String.valueOf(score);



		file_operation(strScore);




	}


	public void printtt(int x_coordinate,int y_coordinate,String output)
	{

		window.setCursorPosition(x_coordinate, y_coordinate);
		window.output(output);

	}


	public void cardDisplay(Pile pile,Card card)
	{
		String suit = card.getSuit();
		String value = card.getStrValue();
		Color backgr;
		if(card.isOpen())
		{
			backgr = Color.WHITE;
		}
		else
		{
			backgr = Color.ORANGE;
		}
		Color foregr = null;
		String symbol = null;

		if(suit.equals("heart"))
		{
			foregr = Color.RED;
			symbol = "♥";
		}
		else if(suit.equals("diamond"))
		{
			foregr = Color.RED;
			symbol = "♦";
		}
		else if(suit.equals("spade"))
		{
			foregr = Color.BLACK;
			symbol = "♠";
		}
		else if(suit.equals("club"))
		{
			foregr = Color.BLACK;
			symbol = "♣";
		}


		int last_i = pile.getCurrentPoint_x() + 10;
		int last_j = pile.getCurrentPoint_y() + 8;

		for(int i=pile.getCurrentPoint_x();i<last_i;i++)
		{
			for(int j=pile.getCurrentPoint_y();j<last_j;j++)
			{

				if(card.isOpen())
				{

					print(i,j," ",foregr,backgr);
				}
				else
				{
					print(i,j," ",foregr,backgr);
				}
			}

		}		

		if(card.isOpen())
		{

			for(int i=pile.getCurrentPoint_x();i<last_i;i++)
			{
				for(int j=pile.getCurrentPoint_y();j<last_j;j++)
				{
					if((i == pile.getCurrentPoint_x() && j == pile.getCurrentPoint_y()) || (i == pile.getCurrentPoint_x()+8 && j == pile.getCurrentPoint_y()+7))
					{
						print(i,j,value,foregr,backgr);
					}

					else if((i == pile.getCurrentPoint_x() && j == pile.getCurrentPoint_y()+1) || (i == pile.getCurrentPoint_x()+8 && j == pile.getCurrentPoint_y()+6))
					{
						print(i,j,symbol+" ",foregr,backgr);
					}
				}

			}
		}


		if(pile.getPileLinked().elementNumber() != 0)		
			print(pile.getCurrentPoint_x(), pile.getCurrentPoint_y()-1, "----------",Color.BLACK,backgr);

		pile.add(card);


	}




	public void print(int x_coordinate,int y_coordinate,String output)
	{

		window.setCursorPosition(x_coordinate, y_coordinate);
		window.output(output);

	}

	public void print(int x_coordinate,int y_coordinate,char value,Color foreground,Color background)
	{

		TextAttributes attrs = new TextAttributes(foreground,background);
		window.output(value, attrs);

	}

	public void print(int x_coordinate,int y_coordinate,String value,Color foreground,Color background)
	{

		window.setCursorPosition(x_coordinate, y_coordinate);	
		TextAttributes attrs = new TextAttributes(foreground,background);	
		window.output(value, attrs);

	}





	public void readoperation()
	{
		Scanner input=null;
		String line="";
		String [] array={" "," "};
		try {
			input = new Scanner(new File( "data.txt" ) );
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		DoubleLinkedList list = new DoubleLinkedList();
		while(input.hasNextLine())
		{

			line=input.nextLine();
			array=line.split(",");
			Player plyr = new Player(array[0], array[1]);
			list.add((Object)plyr);

		}
		System.out.println();
		list.display_descending();
		System.out.println();
		list.display_ascending();
	}
	public void writeoperation(String tempfiletext)
	{
		try{
			File file1 = new File("data.txt");
			FileWriter printer = new FileWriter(file1,true);
			BufferedWriter print = new BufferedWriter(printer);
			print.write(tempfiletext+"\n");
			print.close();
		}
		catch (Exception hata){
			hata.printStackTrace();
		}

	}
	public void file_operation(String inscore)
	{
		Scanner scan=new Scanner(System.in);

		cn.getTextWindow().setCursorPosition(60, 5);
		System.out.print("Please enter your name : ");
		String inname=scan.next();
		cn.getTextWindow().setCursorPosition(60, 6);
		System.out.print("Please enter your surname : ");
		String insurname=scan.next();


		String text=inname+"   "+insurname+"					 ,"+inscore;
		writeoperation(text);
		readoperation();

	}

}




