package Model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.time.LocalDate;

public class PrintRecipt {
	
	private Car selectedCar;
	private static String dataPath;
	
	
	public PrintRecipt(Car selectedCar) {
		this.selectedCar = selectedCar;
		PrintRecipt.dataPath = "src/Data/" + selectedCar.getCarName() + "-CarLog.txt";
	}
		
	public boolean PrintToFile() {
				
		FileWriter fw;
			
		try {
			fw = new FileWriter(dataPath);
			   BufferedWriter writer = new BufferedWriter(fw);
			   writer.write("Date: " + LocalDate.now() + "\t" + "Car Log Report");
			   writer.newLine();
			   writer.newLine();
			   writer.write(selectedCar.toString());
			   writer.newLine();
			   writer.write("COMPLETE JOB HISTORY");
			   writer.newLine();
			   writer.newLine();
			   writer.write(selectedCar.getCompletedJobs().toString());
			   	    
			   writer.close();
			   fw.close();
		} 
		catch (Exception e) {
			System.out.println(e);
			return false;
		}
					
		return true;
		
	}

	
}
