package model;

public class Vaccine {

	public Vaccine() {
		super();// TODO Auto-generated constructor stub
	}
	
	private int vaccine_ID;
	private String vaccineName;
	private String manufacturer;
	private String type;
	private String cost;
	public int getVaccine_ID() {
		return vaccine_ID;
	}
	public void setVaccine_ID(int vaccine_ID) {
		this.vaccine_ID = vaccine_ID;
	}
	public String getVaccineName() {
		return vaccineName;
	}
	public void setVaccineName(String vaccineName) {
		this.vaccineName = vaccineName;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getCost() {
		return cost;
	}
	public void setCost(String cost) {
		this.cost = cost;
	}

}
