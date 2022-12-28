package Model;

import java.io.BufferedWriter;
import java.io.FileWriter;

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
			   writer.write(selectedCar.toString());
			    
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
