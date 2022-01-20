
public class Spiller {
	
	private Brikke[] brikke;
	private int antall = 0;
	
	public Spiller(int antall) {
		brikke = new Brikke[antall];
		for(int i = 0; i < antall; i++) {
			brikke[i] = new Brikke();
		}
		this.antall = antall;
		
	}
	
	public Brikke[] getSpillere() {
		return brikke;
	}
	
	public int antallSpillere() {
		return antall;
	}
	
	public boolean erFull() {
		return antall > brikke.length;
	}


}
