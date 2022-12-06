package test;
public class Settings {

	
	public static String getBigTxtPath() {
		return "Data/big.txt.gz";
	}
	
	public static String getImdbPath() {
		return "Data/imdb-plots-20081003.list.gz";
	}
	
	public static String getSpellTestPath() {
		return "Data/spelltest.txt";
	}
	
	public static int numCorrectionsToReturn(){
		return 10;
	}
	
}