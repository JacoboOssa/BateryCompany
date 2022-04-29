package model;

public class RechargeableBattery extends Battery implements Rechargeable{

	public final static char BATTERY_LITIO = 'l';
	public final static char BATTERY_NIQUEL_CADIO = 'n';
	public final static double FACTOR_LITIO = 0.92;
	public final static double FACTOR_NIQUEL_CADIO = 0.80;

	private int chargerNumber;
	private char type;

	public RechargeableBattery(String name,double voltage,double cost,double capacity,int chargerNumber,char type){
		super(name,voltage,cost,capacity);
		this.chargerNumber = chargerNumber;
		this.type = type;
	}

	public int getChargerNumber(){
		return chargerNumber;
	}
	public void setChargerNumber(int chargerNumber){
		this.chargerNumber = chargerNumber;
	}

	public char getType(){
		return type;
	}
	public void setType(char type){
		this.type = type;
	}

	
	@Override
	public double calculateUsefulLifeCost(){
		double total=0;

		if (type=='l'){
			total += (cost*voltage*capacity)/(1000*chargerNumber*FACTOR_LITIO);	
		}
		if (type=='n'){
			total +=(cost*voltage*capacity)/(1000*chargerNumber*FACTOR_NIQUEL_CADIO);		
		}

		return total;
	}


	@Override
	public String toString(){
		return "Nombre de la bateria: " + getName() +"\n" +
		"Voltaje: " + voltage + "\n" + 
		"Costo: " + cost + "\n" + 
		"capacidad: " + capacity + "\n" +
		"Numero de Cargas: " + chargerNumber + "\n" +
		"Tipo: "  + type;
	}

	public int countBatteryRechargeable(){
		int totalBatteryRechargeable=0;
		if (type=='l' || type == 'n') {

			totalBatteryRechargeable++;	
		}
		return totalBatteryRechargeable;
	}

}