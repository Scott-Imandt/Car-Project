package Model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;


public class Car implements Serializable{
	
	private String carName;
	private int currentMileage;
	private ArrayList<Job> jobs;
	
	public Car(String carName, int miles) {
		this.carName = carName;
		this.currentMileage = miles;
		jobs = new ArrayList<Job>(); 
	}
	
	public boolean addJob(String jobName, int mileageInterval, int monthTimeInterval, LocalDate lastPreformed,  int LastPreformedMiles, RepairType jobEnum) {
	// This method Creates a job as stores it into the cars array of jobs
		try{
			Job temp = new Job(jobName, mileageInterval, monthTimeInterval, lastPreformed, LastPreformedMiles,jobEnum);	
			jobs.add(temp);		
		}
		catch(Exception e){
			System.out.println(e);
			return false;
		}
		
		return true;
	}
	
	public void UpdateJobs(LocalDate UpdatedDate) {
		
		// loop through the array for each car job
		for(Job j : jobs) {
			
			j.calcMaintenance(currentMileage, UpdatedDate);
			
		}
		
	}

	public String getCarName() {
		return carName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}

	public ArrayList<Job> getJobs() {
		return jobs;
	}
	
	public int getCurrentMileage() {
		return currentMileage;
	}

	public void setCurrentMileage(int currentMileage) {
		this.currentMileage = currentMileage;
	}

	public void setJobs(ArrayList<Job> jobs) {
		this.jobs = jobs;
	}
	
	@Override
	public String toString() {
		String temp = carName;
		temp += " " + "Mileage: " + currentMileage;
		temp += "\nJobs: [\n";
		
		for(Job j  : jobs) {
			
			temp = temp + j.toString();
			temp += "\n"; // need to change 
			
		}
		temp += "]";
		return temp;
		
	}
	
	

}
