package post;

public enum KrxMarketType {
	ALL("��ü"), KOSPI("STK"), KOSDAQ("KSQ"), KONEX("KNX");
	private String marketType = "��ü";
	private KrxMarketType(String type) {
		this.marketType = type;
	}
	public String getMarketType() {
		return marketType;
	}
	
}
