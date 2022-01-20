
public class Egenskap {
	
	private int[][] slanger;
	private int[][] stiger;
	
	public Egenskap() {
		this.slanger = new int[][]{{98,78},{95,75},{93,73},{87,24},{64,60},{62,18},{56,53},{49,11},{47,26},{16,6}};
		this.stiger = new int[][]{{2,38},{4,14},{8,31},{21,42},{28,84},{36,44},{51,67},{71,91},{80,100}};
	}
	
	public int giEgenskap(int rute) {
		for(int i = 0; i < slanger.length; i++) {
			if(rute == slanger[i][0]) {
				return slanger[i][1];
			}
			
		}
		for(int i = 0; i < stiger.length; i++) {
			if(rute == stiger[i][0]) {
				return stiger[i][1];
			}
		}
		return -1;
	}

}
