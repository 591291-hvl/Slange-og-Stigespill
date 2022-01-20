
public class Rute {
	
	private int posisjon;
	private int flytt; //1 -> flytt opp, 0 -> ikke flytt, -1 -> flytt ned
	private int flyttTil; //hvor man flytter til
	
	public Rute(int posisjon, int flytt, int flyttTil) {
		this.posisjon = posisjon;
		this.flytt = flytt;
		this.flyttTil = flyttTil;
	}
	//need some way to find out if the square has some special property 
	//version 2
	
	public int getPosisjon() {
		return posisjon;
	}
	
	public int getFlytt() {
		return flytt;
	}
	
	public int getFlyttTil() {
		return flyttTil;
	}
	
	

}
