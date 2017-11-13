import java.util.ArrayList;
import java.util.HashMap;
//import java.util.Scanner;

/**
 * @author TODO: please add student ID and name here
 * 學號：B0344223
 * 姓名：劉益坤
 * 
 * Try to write some comments for your codes (methods, 10 points)
 * 就不說只是因為使用enumerated type而做改變的程式碼，
 * 真正自己寫的部分其實只有在Deck class的shuffle()以及getOneCard()兩個method。
 * 
 * shuffle()要做的事就是把所有牌都拿回來然後洗牌，
 * 但就是別忘了如果要洗牌就必須把usedCard這個array清空，
 * 所以就是先使用addAll()把usedCard裡面的卡便都加進cards然後使用random隨機取數
 * 把隨機位置的卡片放到最後面然後刪除，然後用clear()把usedCard清空，
 * 以及把使用過的牌數nUsed給歸零。
 * 
 * 而getOneCard()要做的就是先判別是不是已經沒有牌可以使用，
 * 使用if-else判別如果沒有牌，就把所有用過的牌都拿回來並洗牌，nUserd要歸零
 * ，然後抽取最上面的牌，別忘了這張牌還要放到usedCard代表已經使用過，
 * 然後還要把nUsed+1代表多一張牌已用過。
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
