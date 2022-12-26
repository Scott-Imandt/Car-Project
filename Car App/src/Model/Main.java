package Model;

import java.time.LocalDate;


public class Main {

	public static void main(String[] args) {
		Car Car1 = new Car("Mazda 6", 84000);
				
		LocalDate ld1 = LocalDate.of(2022, 1, 16);
		LocalDate ld2 = LocalDate.of(2020, 2, 16);
	
		Car1.addJob("Oil Change", 10000, 12, ld1, 70000, RepairType.REPLACE);
		Car1.addJob("Brake Fluid", 60000, 36, ld2, 80000, RepairType.REPLACE);
		
		Car1.UpdateJobs(LocalDate.now());
		
		System.out.println(Car1);
			
	}

}
