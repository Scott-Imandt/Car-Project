package Model;

import java.io.Serializable;
import java.util.ArrayList;

public class Car_Storage implements Serializable{
	
	private ArrayList<Car> carStorage = new ArrayList<Car>(); // Storage for all Car Objects
	
	
	public ArrayList<Car> getArrayList() {
	// get ArrayList of cars
		return carStorage;
	}
	
	private boolean addCarStorage(Car c) {
	// add A car object to the Car storage 
		try{
			carStorage.add(c);
		}
		catch(Exception e){
			System.out.println(e);
			return false;
		}
		
		return true;
	}
	
	
	public Car getCar(int index) {
		// gets the car from the provided index
		
		Car temp = null;
		
		try {
			 temp =  carStorage.get(index);
		 
		}
		catch(Exception e) {
			 System.out.println(e);
			 return null;
		}
		 
		return temp; 
	}
	
	public boolean removeCar(int index) {
		// removes a car from the car storage
		
		try {
			carStorage.remove(index);
				
		}
		catch(Exception e) {
			System.out.println(e);
			return false;
		}
		
		return true;
	}
	
	
	public Car createCar(String carName, int miles) {
		//Create car and store in car Storage
		
		Car temp = new Car(carName, miles);
		this.addCarStorage(temp);
		
		return temp;
		
	}
	
	
	
	
	

}
