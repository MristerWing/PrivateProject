package ch04;

class SutdaDeck {
	final int CARD_NUM = 30;
	SutdaCard[] cards = new SutdaCard[CARD_NUM];
	
	public SutdaDeck() {
		for(int i = 0;i < cards.length;i++) {
			int num = i % 10 + 1;
			boolean isKwang = (num == 3||num == 6||num == 9);
			
			cards[i] = new SutdaCard(i + 1, isKwang);
		}
	}
	
}

class SutdaCard {
	int num;
	boolean isKwang;
	
	public SutdaCard() { this(1, true); }

	public SutdaCard(int i, boolean b) {
		this.isKwang = b;
		this.num = i;
	}
	
	public String toString() {
		return num + (isKwang?"K":"");
	}
}

public class Pro3 {
	public static void main(String args[]) {
		SutdaDeck demo = new SutdaDeck();
		for(int i = 0;i < demo.cards.length;i++) {
			System.out.print(demo.cards[i] + ((i == demo.cards.length - 1)?"":", "));
		}
	}
}
