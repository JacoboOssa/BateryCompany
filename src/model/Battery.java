package model;

public class Battery{

	private String name;
	protected double voltage;
	protected double cost;
	protected double capacity;

	public Battery(String name,double voltage,double cost,double capacity){
		this.name =name;
		this.voltage = voltage;
		this.cost = cost;
		this.capacity = capacity;
	}

	public String toString(){
		return "Nombre bateria: " + name + "\n"+
		"Voltaje: " +voltage + "\n" +
		"Costo: " + cost + "\n" + 
		"Capacidad: " + capacity;
	}

	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name = name;
	}

	public double getVoltage(){
		return voltage;
	}
	public void setVoltage(double voltage){
		this.voltage = voltage;
	}

	public double getCost(){
		return cost;
	}
	public void setCost(double cost){
		this.cost = cost;
	}

	public double getCapacity(){
		return capacity;
	}
	public void setCapacity(double capacity){
		this.capacity = capacity;
	}


}