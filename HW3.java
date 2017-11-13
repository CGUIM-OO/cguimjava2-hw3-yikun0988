import java.util.ArrayList;
import java.util.HashMap;
//import java.util.Scanner;

/**
 * @author TODO: please add student ID and name here
 * �Ǹ��GB0344223
 * �m�W�G�B�q�[
 * 
 * Try to write some comments for your codes (methods, 10 points)
 * �N�����u�O�]���ϥ�enumerated type�Ӱ����ܪ��{���X�A
 * �u���ۤv�g���������u���bDeck class��shuffle()�H��getOneCard()���method�C
 * 
 * shuffle()�n�����ƴN�O��Ҧ��P�����^�ӵM��~�P�A
 * ���N�O�O�ѤF�p�G�n�~�P�N������usedCard�o��array�M�šA
 * �ҥH�N�O���ϥ�addAll()��usedCard�̭����d�K���[�icards�M��ϥ�random�H������
 * ���H����m���d�����̫᭱�M��R���A�M���clear()��usedCard�M�šA
 * �H�Χ�ϥιL���P��nUsed���k�s�C
 * 
 * ��getOneCard()�n�����N�O���P�O�O���O�w�g�S���P�i�H�ϥΡA
 * �ϥ�if-else�P�O�p�G�S���P�A�N��Ҧ��ιL���P�����^�Өì~�P�AnUserd�n�k�s
 * �A�M�����̤W�����P�A�O�ѤF�o�i�P�٭n���usedCard�N��w�g�ϥιL�A
 * �M���٭n��nUsed+1�N��h�@�i�P�w�ιL�C
 * 
 */
public class HW3 {
	public static void main(String[] args) {
		//Scanner sc = new Scanner(System.in);
		//System.out.println("input N(deck of cards):");
		//String testn= sc.nextLine(); 
		int nDeck=1;
		//TODO: please add new fields and methods to Deck class (35)
		//usedCard (5 points)
		//nUsed (5 points)
		//getOneCard (10 points)
		//shuffle (10 points)
		//constructor (5 points)
		Deck deck=new Deck(nDeck);
		
		//TODO: please check your output, make sure that you print newCard and newCard2 on your screen  (10 points)
		//TODO: please add new fields and methods to Card class (25)
		//Use enumerated type in Card (10 points)
		//Constructor (5 points)
		//printCard (5 points)
		//getSuit (5 points)
		Card newCard=deck.getOneCard();
		newCard.printCard();
		Card newCard2=deck.getOneCard();
		newCard2.printCard();
		deck.shuffle();
		if(isAllCardsCorrect(deck.getAllCards(),nDeck)){
			if(!isShuffleWorking(deck,newCard,newCard2)){
				System.out.println("All Card: Well done! But shufller is not working");
			}else{
				System.out.println("Well done!");
			}
			
		}else{
			System.out.println("All Card: Error, please check your sourse code");
		}

	}
	/**
	 * This method is used for checking your result, not a part of your HW3
	 */
	private static boolean isShuffleWorking(Deck deck,Card newCard,Card newCard2){
		deck.shuffle();
		boolean isCorrect=true;
		if(newCard.getSuit().equals(newCard2.getSuit()) &&
				newCard.getRank()==newCard2.getRank()){
					isCorrect=false;
					return isCorrect;
		}
		for(int i=0;i<53;i++){
			deck.getOneCard();
		}
		if(deck.nUsed!=1){
			isCorrect=false;
		}
		return isCorrect;
	}
	
	private static boolean isAllCardsCorrect(ArrayList<Card> allCards,int nDeck){
		//check the output 
		boolean isCorrect=true;;
		HashMap <String,Integer> checkHash=new HashMap<String,Integer>();
		for(Card card:allCards){
			Card.Suit suit= card.getSuit();
			int rank = card.getRank();
			if(rank>13||rank<1){
				isCorrect=false;
				break;
			}
			if(checkHash.containsKey(suit+","+rank)){
				checkHash.put(suit+","+rank, 
						checkHash.get(suit+","+rank)+1);
			}else{
				checkHash.put(suit+","+rank, 1);
			}

		}
		if(checkHash.keySet().size()==52||checkHash.keySet().size()==50){
			for(int value:checkHash.values()){
				if(value!=nDeck){
					isCorrect=false;
					break;
				}
			}
		}else{
			isCorrect=false;
		}
		return isCorrect;
	}

}
