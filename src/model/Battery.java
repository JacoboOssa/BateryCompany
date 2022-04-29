package model;

public class Battery{

	protected String name;
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


}