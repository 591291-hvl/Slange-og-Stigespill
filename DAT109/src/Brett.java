
public class Brett {
	
	final private int HEIGTH = 10;
	final private int WIDTH = 10;
	private Rute[][] brett;
	private Spiller spillere;
	
	
	public Brett(Spiller spillere) {
		
		Egenskap egenskaper = new Egenskap();
		this.spillere = spillere;
		
		brett = new Rute[HEIGTH][WIDTH];
		for(int i = 0; i < HEIGTH; i++) {
			Rute[] rekke = new Rute[WIDTH];
			for(int j = 1; j <= rekke.length; j++) {
				int ruteVerdi = i*WIDTH + j;
				int nyRuteVerdi = egenskaper.giEgenskap(ruteVerdi); 
				
				if(nyRuteVerdi == -1) {
					rekke[j-1] = new Rute(ruteVerdi, 0, -1);
				}else {
					if(nyRuteVerdi > ruteVerdi) {
						rekke[j-1] = new Rute(ruteVerdi, 1, nyRuteVerdi);
					}else if(nyRuteVerdi < ruteVerdi) {
						rekke[j-1] = new Rute(ruteVerdi, -1, nyRuteVerdi);
						
					}
				}
				
			}
			brett[i] = rekke;
			
		}
		
	}
	
	public Rute[][] getBrett() {
		return brett;
	}
	
	public Rute getRute(int rute) {
		rute--;
		return brett[rute/10][rute%10];
		
	}
	
	public int getAntall() {
		return HEIGTH * WIDTH;
	}
	
	
	
	//Mal
	//========
	//||+xx||	+/- indikerer stige(+), slange(-) opp/ned
	//|| 00||	xx verdi på ruten
	//|| 00||	2x2 tall indikerer hvilken brikke er der, ingen(0), resten(1-4) id
	//========
	
	//Til den som leser dette:
	//til mitt forsvar så hadde jeg en ide, og når jeg har en ide til noe så må jeg fullføre
	//er dette viktig? -> nei
	//går dette langt utenfor oppgaven -> ja
	//har jeg kastet vekk mye tid -> ja
	//skulle jeg ha brukt tiden til noe viktig -> ja
	//ble jeg ferdig sent på natten -> ja
	public String toString() {
		
		Rute[] rekke = new Rute[brett.length];
		String str = "";
		String str1 = "";
		String str2 = "";
		String str3 = "";
		
		int temp = 0;
		
		for(int i = brett.length -1; i >= 0; i--) {
			str += "\n" + "====================================================";
			str1 = "||";
			str2 = "||";
			str3 = "||";
			
			rekke = brett[i]; 
			
			
			for(int j = 0; j < rekke.length; j++) {
				//flip
				if(i % 2 != 0) {
					temp = j;
					j = rekke.length - j - 1;
				}
				//Slange/Stige
				if(rekke[j].getPosisjon() == 100) {
					str2 += " ";
					str3 += " ";
				}else if(rekke[j].getFlytt() < 0 ) {
					str1 += "-";
					str2 += " ";
					str3 += " ";
				}else if(rekke[j].getFlytt() > 0) {
					str1 += "+";
					str2 += " ";
					str3 += " ";
				}else {
					str1 += " ";
					str2 += " ";
					str3 += " ";
				}
				//Tall verdi
				//(må ha 100 også)
				if(rekke[j].getPosisjon() <= 9) {
					str1 += " " + rekke[j].getPosisjon();
				}else {
					str1 += rekke[j].getPosisjon();
				}
				//Spiller
				Brikke[] brikker = spillere.getSpillere();
				boolean[] spillerPos = new boolean[4];
				for(int k = 0; k < brikker.length; k++) {
					if(brikker[k].getRute().getPosisjon() == rekke[j].getPosisjon()) {
						if(brikker[k].getID() == 1) {
							spillerPos[0] = true;
						}
						if(brikker[k].getID() == 2) {
							spillerPos[1] = true;
						}
						if(brikker[k].getID() == 3) {
							spillerPos[2] = true;
						}
						if(brikker[k].getID() == 4) {
							spillerPos[3] = true;
						}
					}
					
					
				}
				if(spillerPos[0]) {
					str2 += "1";
				}else {
					str2 += "0";
				}
				if(spillerPos[1]){
					str2 += "2";
				}else {
					str2 += "0";
				}
				if(spillerPos[2]) {
					str3 += "3";
				}else {
					str3 += "0";
				}
				if(spillerPos[3]) {
					str3 += "4";
				}else {
					str3 += "0";
				}
				
				str1 += "||";
				str2 += "||";
				str3 += "||";
				
				//flop
				if(i % 2 != 0) {
					j = temp;
				}
			}
			str += "\n" + str1 + "\n" + str2 + "\n" + str3;
		}
		
		
		return str;
	}
	
}
