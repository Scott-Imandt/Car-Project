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
				
		LocalDate ld1 = LocalDate.of(2020, 1, 16);
		//LocalDate ld2 = LocalDate.of(2020, 2, 16);
		
		//selectedCar.addJob("Spark Plugs", 75000, 120, ld1, 0, RepairType.REPLACE);
		
		//selectedCar.UpdateJobs(LocalDate.now(), 90000);
		
		//selectedCar.jobCompleted(1, ld1, 90000);
		
		//selectedCar.UpdateJobs(LocalDate.now(), 90000);
		
		selectedCar.jobCompleted(0, ld1, 81000);
	
 		PrintRecipt Pr = new PrintRecipt(selectedCar);
 		
 		Pr.PrintToFile();

		//carDB.createCar("Mazda 6", 84000);
		//selectedCar = carDB.getCar(0);

		//selectedCar.addJob("Oil Change", 10000, 12, ld1, 70000, RepairType.REPLACE);
		//selectedCar.addJob("Brake Fluid", 60000, 36, ld1, 80000, RepairType.REPLACE);		
				
		
		sf.setStoredData(carDB);
		Save_File.saveData(sf);
	}

}
