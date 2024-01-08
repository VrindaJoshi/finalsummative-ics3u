package tests;

// template class for city 
public class City {

	String planet;
	String continent;
	String country;
	String name;
	String population;
	
	
	public City(String planet, String continent, String country, String name, String population) {
		super();
		this.planet = planet;
		this.continent = continent;
		this.country = country;
		this.name = name;
		this.population = population;
	}


	public String getPlanet() {
		return planet;
	}


	public void setPlanet(String planet) {
		this.planet = planet;
	}


	public String getContinent() {
		return continent;
	}


	public void setContinent(String continent) {
		this.continent = continent;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPopulation() {
		return population;
	}


	public void setPopulation(String population) {
		this.population = population;
	}


	@Override
	public String toString() {
		return "City [planet=" + planet + ", continent=" + continent + ", country=" + country + ", name=" + name
				+ ", population=" + population + "]";
	}
	
}
