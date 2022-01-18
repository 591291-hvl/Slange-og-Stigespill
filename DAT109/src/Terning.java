import java.util.Random;

public class Terning {
	
	Random random = new Random();
	
	private int value;
	
	public Terning() {
		this.value = 0;
	}
	
	public int trill() {
		return random.nextInt(6) + 1;
//		return 6;
	}

}
