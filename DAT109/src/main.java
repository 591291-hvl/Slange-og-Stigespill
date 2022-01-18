import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		
		int antallSpillere;
		
		do {
			System.out.println("Oppgi antall spillere mellom 2-4");
			 antallSpillere = Integer.parseInt(scanner.nextLine());
			
		}while(!(antallSpillere > 1 && antallSpillere < 5));
		
		Spiller spillere = new Spiller(antallSpillere);
		
		Brett brett = new Brett();
		
		Spill spill = new Spill(spillere, brett);
		
		spill.run();
		
		
//		System.out.println("Spiller 1 trillte 5 og flytter fra 1 til 6");
//		System.out.println("Skriv noe for å trill terning");
//		
//		System.out.println("Spiller 1 trillte 3 og flytter fra 6 til 9");
//		System.out.println("Skriv noe for å trill terning");
//		
//		System.out.println("Spiller 1 trillte 1 og flytter fra 9 til 10");
//		System.out.println("Skriv noe for å trill terning");
		
	}

}
