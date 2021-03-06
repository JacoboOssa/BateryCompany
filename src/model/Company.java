package model;

public class Company{
	
    public static final int MAX_BATTERIES = 10;
	private Battery[] batteries;

	public Company() {
        this.batteries = new Battery[MAX_BATTERIES];
	}

    public Company(Battery[] batteries){
        this.batteries = batteries;
    }
	

    public void registerBattery(String name, double voltage, double cost, double capacity){
        int emtyPos = getEmtyPosition();
        batteries[emtyPos] = new Battery(name, voltage, cost, capacity);

    }

    public void registerRechargeableBattery(String name, double voltage, double cost, double capacity, int chargerNumber, char type) {
        int emtyPos = getEmtyPosition();
        batteries[emtyPos] = new RechargeableBattery(name, voltage, cost, capacity, chargerNumber ,type);  
    }

    public int getCountBatteryRechargeable(){
        int totalBatteryRechargeable = 0;

        if (batteries!=null){
            for (int i=0;i<MAX_BATTERIES;i++){
                if (batteries[i] instanceof RechargeableBattery){
                    totalBatteryRechargeable += ((RechargeableBattery)batteries[i]).countBatteryRechargeable();        
                }      
            }  
        }

        return totalBatteryRechargeable;
    }

    public double getCalculateUsefulLifeCost(){
        double total = 0;

        if (batteries!=null){
            for (int i=0;i<MAX_BATTERIES;i++){
                if (batteries[i] instanceof RechargeableBattery){
                    total += ((RechargeableBattery)batteries[i]).calculateUsefulLifeCost();        
                }      
            }  
        }

        return total;

    }

    
    private int getEmtyPosition() {
        int pos = -1;
        for (int i = 0; i < MAX_BATTERIES && pos == -1; i++) {
            if (batteries[i] == null) {
                pos = i;
            }
        }
        return pos;
    }

    public String showTotalBatteries() {
        int countBattery = 0;
        int countBatteryDesechable = 0;
        int countBatteryRechargeable = 0;
        if (batteries!=null){
            for (int i=0;i<MAX_BATTERIES;i++){
                if (batteries[i] instanceof RechargeableBattery) {
                    countBatteryRechargeable ++;  
                }
            }

            for (int i=0;i<MAX_BATTERIES;i++){
                if (batteries[i] instanceof Battery){
                    countBattery++;
                }     
            }

            countBatteryDesechable += countBattery- countBatteryRechargeable;     
        }
    	return "El total de baterias Desechables es: " + countBatteryDesechable + "\n" +
        "El total de baterias recargables es: " + countBatteryRechargeable;
    }
    
    public String showBatteriesInfo() {
        String str = "";

        if (batteries!=null){
            for (int i=0;i<MAX_BATTERIES;i++){
                if (batteries[i] instanceof RechargeableBattery){
                    str += "\nBateria Recargable " + "\n" + ((RechargeableBattery)batteries[i]).getName() + "\n" + "Costo de Vida: " + ((RechargeableBattery)batteries[i]).calculateUsefulLifeCost();    
                }
                else {
                    str += "\nBateria NO Recargable " + "\n" + ((Battery)batteries[i]).getName() + "\n" + "Costo de vida: 0";
                    
                }
                
            }
            
        }
    	return str;
    }
    

	public double calculateUsefulPromLifeCost(){
        int totalBattery = getCountBatteryRechargeable();
        double lifeCost = getCalculateUsefulLifeCost();
        double average = 0;

        average += lifeCost/totalBattery;

        return average;
		
	}

}
