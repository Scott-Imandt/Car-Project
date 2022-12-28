package Model;

import java.time.LocalDate;

public class Main {
	
	public static Car_Storage carDB = null;
	public static Car selectedCar = null;
	public static Save_File sf; 

	public static void main(String[] args) {
		
		sf = Save_File.loadData();
		carDB = sf.getStoredData();
		selectedCar = carDB.getCar(0);
		
		LocalDate ld1 = LocalDate.of(2022, 1, 16);
		//LocalDate ld2 = LocalDate.of(2020, 2, 16);
		
		selectedCar.addJob("Spark Plugs", 75000, 120, ld1, 0, RepairType.REPLACE);
	
 		PrintRecipt Pr = new PrintRecipt(selectedCar);
 		
 		Pr.PrintToFile();
       
		
		
				
		//LocalDate ld1 = LocalDate.of(2022, 1, 16);
		//LocalDate ld2 = LocalDate.of(2020, 2, 16);
		
		
		//carDB.createCar("Mazda 6", 84000);
		
		
		
		//selectedCar.setCarName("Mazda 3");
	
		//selectedCar.addJob("Oil Change", 10000, 12, ld1, 70000, RepairType.REPLACE);
		//selectedCar.addJob("Brake Fluid", 60000, 36, ld2, 80000, RepairType.REPLACE);
//		
		//selectedCar.getJobs().get(0).calcMaintenance(90000, LocalDate.now());
		//selectedCar.getJobs().get(0).jobCompleted(LocalDate.now(), 90000);
		
//		Car1.UpdateJobs(LocalDate.now());
		
//		System.out.println(carDB.getCar(0).equals(selectedCar));
		//System.out.println(selectedCar);
		
		
		
		sf.setStoredData(carDB);
		sf.saveData(sf);
	}

}
