package Model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeMap;


public class Car implements Serializable{
	
	private String carName;
	private int currentMileage;
	private LocalDate lastUpdatedTime;
	private ArrayList<Job> jobs;
	private ArrayList<CompletedJob> cJobs;
	
	public Car(String carName, int miles) {
		this.carName = carName;
		this.currentMileage = miles;
		jobs = new ArrayList<Job>();
		cJobs = new ArrayList<CompletedJob>();
		lastUpdatedTime = LocalDate.now();
	}
	
	public boolean addJob(String jobName, int mileageInterval, int monthTimeInterval, LocalDate lastPreformed,  int LastPreformedMiles, RepairType jobEnum) {
	// This method Creates a job as stores it into the cars array of jobs
		try{
			Job temp = new Job(jobName, mileageInterval, monthTimeInterval, lastPreformed, LastPreformedMiles,jobEnum);	
			temp.calcMaintenance(currentMileage, lastUpdatedTime);
			jobs.add(temp);		
		}
		catch(Exception e){
			System.out.println(e);
			return false;
		}
		
		return true;
	}
	
	public void UpdateJobs(LocalDate UpdatedDate, int newMileage) {
		
		// sets new mileage then checks all jobs with updated information
		
		setCurrentMileage(newMileage);
		
		for(Job j : jobs) {
			
			j.calcMaintenance(currentMileage, UpdatedDate);
			
		}
		
		lastUpdatedTime = UpdatedDate;
		
	}
	
	public void jobCompleted(int jobIndex, LocalDate lastPreformed, int lastPreformedMiles) {
		this.jobs.get(jobIndex).jobCompleted(lastPreformed, lastPreformedMiles);
		CompletedJob cj = new CompletedJob(this.jobs.get(jobIndex).getJobName(),lastPreformed, lastPreformedMiles);
		cJobs.add(cj);
	}
	
	public void jobCompleted(int jobIndex, LocalDate lastPreformed, int lastPreformedMiles, String productName, String productLink) {
		this.jobs.get(jobIndex).jobCompleted(lastPreformed, lastPreformedMiles);
		CompletedJob cj = new CompletedJob(this.jobs.get(jobIndex).getJobName(),lastPreformed, lastPreformedMiles, productName, productLink);
		cJobs.add(cj);
	}
	
	public void jobCompleted(String jobName, LocalDate completedDate, int completedMileage) {
		CompletedJob temp = new CompletedJob(jobName, completedDate, completedMileage);
		cJobs.add(temp);
		
	}
	
	public void jobCompleted(String jobName, LocalDate completedDate, int completedMileage, String replacementProductName, String replacementProductLink) {
		CompletedJob temp = new CompletedJob(jobName, completedDate, completedMileage, replacementProductName, replacementProductLink);
		cJobs.add(temp);
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
	
	public ArrayList<CompletedJob> getCompletedJobs() {
		return cJobs;
	}
	
	public String getLastUpdatedTime() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		return lastUpdatedTime.format(formatter);
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
