
public class Brett {
	
	final private int HEIGTH = 10;
	final private int WIDTH = 10;
	private Rute[][] brett;
	
	
	public Brett() {
		
		Egenskap egenskaper = new Egenskap();
		
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
	
}
