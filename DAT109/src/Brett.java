
public class Brett {
	
	final private int HEIGTH = 10;
	final private int WIDTH = 10;
	
	public Brett() {
		
		Rute[][] brett = new Rute[HEIGTH][WIDTH];
		for(int i = 0; i < HEIGTH; i++) {
			Rute[] rekke = new Rute[WIDTH];
			for(int j = 0; j < rekke.length; j++) {
				rekke[j] = new Rute(i*WIDTH + j);
			}
			brett[i] = rekke;
			
		}
		
	}
	
	public int getAntall() {
		return HEIGTH * WIDTH;
	}
	
}
