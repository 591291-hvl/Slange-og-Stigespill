
public class Brikke {
	
	private static int idTeller = 0;
	private int ID = 0;
	private boolean vunnet;
	private boolean hjemme;
	private int posisjon;
	

	public Brikke(){
		idTeller++;
		this.ID = idTeller;
		this.vunnet = false;
		this.hjemme = false;
		this.posisjon = 1;
	}

	public boolean flytt(int antall, int size) {
		if(hjemme) {
			if(antall != 6) {
				System.out.println("Spiller " + ID + " trilte " + antall + ", m� trille 6 for � kunne g� ut av hjem");
			}
			else {
				System.out.println("Spiller " + ID + " trilte " + antall + " og har n� g�tt ut av hjem");
				hjemme = false;
			}
			return true;
		}
		
		if(posisjon + antall > size) {
			//her m� det v�re en m�te � sjekke antall brikker
			System.out.println("Spiller " + ID + " trillte " + antall + " og flytter ikke videre, blir st�ende p� " + posisjon );
			return false;
		}
		System.out.print("Spiller " + ID + " trillte " + antall +  " og flytter fra " + posisjon);
		posisjon += antall;
		System.out.print(" til " + posisjon + "\n");
		return true;
	}
	
	public void flyttHjem() {
		System.out.println("Spiller " + ID + " trillte 6 3 ganger p� rad og flyttet dermed hjem(1)");
		posisjon = 1;
		hjemme = true;
	}
	
	public int getPosisjon() {
		return posisjon;
	}

	public void setPosisjon(int posisjon) {
		this.posisjon = posisjon;
	}
	
	public int getID() {
		return ID;
	}

	public boolean isVunnet() {
		return vunnet;
	}

	public void setVunnet(boolean vunnet) {
		this.vunnet = vunnet;
	}

}
