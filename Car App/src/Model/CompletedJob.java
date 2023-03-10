package Model;

import java.io.Serializable;
import java.time.LocalDate;

public class CompletedJob implements Serializable{
	
	private String jobName;
	private LocalDate completedDate;
	private int completedMileage;
	private String replacementProductName;
	private String replacementProductLink;
	
	
	public CompletedJob(String jobName, LocalDate completedDate, int completedMileage) {
		this.jobName = jobName;
		this.completedDate = completedDate;
		this.completedMileage = completedMileage;	
	}
	
	public CompletedJob(String jobName, LocalDate completedDate, int completedMileage, String replacementProductName, String replacementProductLink) {
		this.jobName = jobName;
		this.completedDate = completedDate;
		this.completedMileage = completedMileage;
		this.replacementProductLink = replacementProductLink;
		this.replacementProductName = replacementProductName;
	}
	
	@Override
	public String toString() {
		String temp = "";
		
		if(replacementProductName == null ) {
			temp += " Job Name: " + jobName + " Completed Date: " + completedDate + " Current Mileage: " + completedMileage + "\n";
			return temp;
		}
		
		temp += " Job Name: " + jobName + " Completed Date: " + completedDate + " Current Mileage: " + completedMileage + " Replacement Product: " + replacementProductName + " Product Link: " + replacementProductLink + "\n";
		return temp;
	}

}
