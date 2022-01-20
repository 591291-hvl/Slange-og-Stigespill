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

	public Spill() {
		
		this.ferdig = false;
		
		Scanner scanner = new Scanner(System.in);
		int antallSpillere;

		do {
			System.out.println("Oppgi antall spillere mellom 2-4");
			antallSpillere = Integer.parseInt(scanner.nextLine());

		} while (!(antallSpillere > 1 && antallSpillere < 5));

		spillere = new Spiller(antallSpillere);

		this.terning = new Terning();
	}

	// Oppretter ting i spiller
	// Setter brettet + spør hvem som vil spille
	public void settBrett() {

		brett = new Brett();

	}

	// Kjører spillet
	public void run() {

		System.out.println("Spill starter");
		Scanner scanner = new Scanner(System.in);

		while (!ferdig) {

			Brikke[] brikker = spillere.getSpillere();
			for (int i = 0; i < brikker.length; i++) {

				Brikke brikke = brikker[i];
				int antallLik = 0;

				// trill terninger
				int verdi;
				do {
					System.out.println("Skriv noe for å trill terning");
					scanner.nextLine();
					verdi = terning.trill();

					if (verdi == 6) {
						antallLik++;
					} else {
						antallLik = 0;
					}

					// spiller har rullet 6-ere 3 ganger på rad
					// -> plasser på bunnen igjen
					if (antallLik >= 3) {
						brikke.flyttHjem();
						antallLik = 0;
						break;
					} else {
						// flytt brikke
						brikke.flytt(verdi, brett.getAntall());
						if (brikke.getPosisjon() == 100) {
							brikke.setVunnet(true);
							ferdig = true;
							System.out.println("Spillet er ferdig");
							System.out.println("Spiller " + brikke.getID() + " har vunnet");
							//spill ferdig, slutt run()
							return;
						}
					}
				} while (verdi == 6 && !ferdig);

			}

		}

	}
}
