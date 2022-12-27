package Model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Save_File implements Serializable{
	
	private static final String dataPath = "src/Data/CarSaveFile.dat";
	private Car_Storage storedData;
	
	
	public Save_File() {}
	
	public Save_File(Car_Storage carStorage) {
		//set the Storage to the provided Car Storage data
		storedData = carStorage;
		
	}
	
	private static boolean dataFileExists() {
		File file = new File(dataPath);
		return file.exists();
	}
	
	public static Save_File loadData() {
		
		if(!dataFileExists()) {
			try {
				ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(dataPath));
				Save_File sf = new Save_File();
			    oos.writeObject(sf);
			    oos.close();
			}	
			catch(Exception e) {
				System.out.println(e);	
			}
		}	 
		Save_File sf = null;
		try {
		    ObjectInputStream ois = new ObjectInputStream(new FileInputStream(dataPath)); 
		    sf = (Save_File)(ois.readObject());
		    ois.close();
		}
		catch (Exception e){
		    System.out.println(e);
		    System.out.println("!-----------DELETE OLD FILE-----------!");
		}
		return sf;	
		
	}
	
	public static boolean saveData(Save_File sf){
        try{
        	ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(dataPath));
            oos.writeObject(sf);
            oos.close();
        }
        catch(Exception e){
        	System.out.println(e);
        }
        return true;
    }
	
	public void setStoredData(Car_Storage newCarStorage) {
		storedData = newCarStorage;
	}
	
	public Car_Storage getStoredData() {
		if(storedData == null) {
			Car_Storage temp = new Car_Storage();
			return temp;
		}
		return storedData;
	}

}
