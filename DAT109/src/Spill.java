import java.util.Scanner;

public class Spill {
	
	private Spiller spillere;
	private Brett brett;
	private boolean ferdig;
	private Terning terning;
	
	public Spill(Spiller spillere, Brett brett) {
		this.spillere = spillere;
		this.brett = brett;
		this.ferdig = false;
		
		this.terning = new Terning();
	}

	
	public void run() {
		
		System.out.println("Spill starter");
		Scanner scanner = new Scanner(System.in);
		
		while(!ferdig) {
		
			Brikke[] brikker = spillere.getSpillere();
			for(int i = 0; i < brikker.length; i++) {
				//må ha en metode for å slutte spillet
				
				Brikke brikke = brikker[i];
				int antallLik = 0;
				
				
				//trill terninger
				int verdi;
				do {
					System.out.println("Skriv noe for å trill terning");
					scanner.nextLine();
					verdi = terning.trill();
					
					if(verdi == 6) {
						antallLik++;
					}else {
						antallLik = 0;
					}
					
					//spiller har rullet 6-ere 3 ganger på rad
					//-> plasser på bunnen igjen
					if(antallLik >= 3) {
						brikke.flyttHjem();
						antallLik = 0;
						//===========================================================
						//TODO PLZ FIKS BREAK, DEN GÅR IKKE UT ETTER SPILLET ER VUNNET
						//===========================================================
						break;
					}else {
						//flytt brikke
						brikke.flytt(verdi, brett.getAntall());
						if(brikke.getPosisjon() == 100) {
							brikke.setVunnet(true);
							ferdig = true;
							System.out.println("Spillet er ferdig");
							System.out.println("Spiller " + brikke.getID() + " har vunnet");
						}
					}
				}while(verdi == 6 && !ferdig);
				
				
				
				
				
			}
		
		}
		
	}
}
