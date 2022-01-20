
public class Brikke {
	
	private static int idTeller = 0;
	private int ID = 0;
	private boolean vunnet;
	private boolean hjemme;
	private Rute rute;
	

	public Brikke(){
		idTeller++;
		this.ID = idTeller;
		this.vunnet = false;
		this.hjemme = false;
		this.rute = new Rute(1,0,-1);
	}

	public boolean flytt(int antall, Brett brett) {
		if(hjemme) {
			if(antall != 6) {
				System.out.println("Spiller " + ID + " trilte " + antall + ", må trille 6 for å kunne gå ut av hjem");
			}
			else {
				System.out.println("Spiller " + ID + " trilte " + antall + " og har nå gått ut av hjem");
				hjemme = false;
			}
			return true;
		}
		
		if(rute.getPosisjon() + antall > brett.getAntall()) {
			//her må det være en måte å sjekke antall brikker
			System.out.println("Spiller " + ID + " trilte " + antall + " og flytter ikke videre, blir stående på " + rute.getPosisjon() );
			return false;
		}
		System.out.print("Spiller " + ID + " trilte " + antall +  " og flytter fra " + rute.getPosisjon());
		setRute(brett.getRute(rute.getPosisjon() + antall));
		System.out.print(" til " + rute.getPosisjon() + "\n");
		if(rute.getFlytt() < 0) {
			rute = brett.getRute(rute.getFlyttTil());
			System.out.println("Ruten var en slange og spiller " + ID + " flyttes til " + rute.getPosisjon());
		}else if(rute.getFlytt() > 0) {
			rute = brett.getRute(rute.getFlyttTil());
			System.out.println("Ruten var en stige og spiller " + ID + " flyttes til " + rute.getPosisjon());
		}
		
		return true;
	}
	
	public void flyttHjem() {
		System.out.println("Spiller " + ID + " trilte 6 3 ganger på rad og flyttet dermed hjem(1)");
		rute = new Rute(1,0,-1);
		hjemme = true;
	}
	
	public Rute getRute() {
		return rute;
	}

	public void setRute(Rute rute) {
		this.rute = rute;
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
