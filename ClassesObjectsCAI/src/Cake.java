// CAKE OBJECT TEMPLATE CLASS 

// class
public class Cake {
	
	// fields
	private String cakeFlavour;
	private String secondCakeFlavour;
	private String frostingFlavour;
	private String frostingColour;
	private int numLayers;
	private String occasion;
	private boolean sprinkles;
	
	// constructor
	public Cake(String cakeFlavour, String secondCakeFlavour, 
			String frostingFlavour, String frostingColour,
			int numLayers, String occasion, boolean sprinkles) {
		super();
		this.cakeFlavour = cakeFlavour;
		this.secondCakeFlavour = secondCakeFlavour;
		this.frostingFlavour = frostingFlavour;
		this.frostingColour = frostingColour;
		this.numLayers = numLayers;
		this.occasion = occasion;
		this.sprinkles = sprinkles;
	}

	// getters + setters
	public String getCakeFlavour() {
		return cakeFlavour;
	}

	public void setCakeFlavour(String cakeFlavour) {
		this.cakeFlavour = cakeFlavour;
	}

	public String getSecondCakeFlavour() {
		return secondCakeFlavour;
	}

	public void setSecondCakeFlavour(String secondCakeFlavour) {
		this.secondCakeFlavour = secondCakeFlavour;
	}

	public String getFrostingFlavour() {
		return frostingFlavour;
	}

	public void setFrostingFlavour(String frostingFlavour) {
		this.frostingFlavour = frostingFlavour;
	}

	public String getFrostingColour() {
		return frostingColour;
	}

	public void setFrostingColour(String frostingColour) {
		this.frostingColour = frostingColour;
	}

	public int getNumLayers() {
		return numLayers;
	}

	public void setNumLayers(int numLayers) {
		this.numLayers = numLayers;
	}

	public String getOccasion() {
		return occasion;
	}

	public void setOccasion(String occasion) {
		this.occasion = occasion;
	}

	public boolean isSprinkles() {
		return sprinkles;
	}

	public void setSprinkles(boolean sprinkles) {
		this.sprinkles = sprinkles;
	}

	// to string method
	@Override
	public String toString() {
		return "Cake [cakeFlavour=" + cakeFlavour + ", secondCakeFlavour=" + secondCakeFlavour + ", frostingFlavour="
				+ frostingFlavour + ", frostingColour=" + frostingColour + ", numLayers=" + numLayers + ", occasion="
				+ occasion + ", sprinkles=" + sprinkles + "]";
	}
	
	

}
