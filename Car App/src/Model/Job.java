package Model;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;



public class Job implements Serializable{
	
	private String jobName;					// Name of job that needs to be worked on 
	private final int mileagInterval;		// miles needed until job needs to be preformed
	private final int monthTimeInterval;	// Time in moth until job needs to be preformed
	private LocalDate LastPreformedDate;	// Date that the job was last preformed
	private LocalDate ExpectedDatetoPreform; // Date that the next job is expected to be completed
	private int lastPreformedMiles;			// Mileage since last Repair was completed
	private final RepairType jobEnum; 		// Type of job that need to be preformed
	private RepairReason repairReason;		// trigger for repair (Miles, time, both, Neither)
	private boolean needMaintenance;		// Trigger check to see if matinence is required

	
	
	
	public Job(String jobName, int mileagInterval, int monthTimeInterval, LocalDate lastPreformed, int lastPreformedMiles, RepairType jobEnum) {
		this.jobName = jobName;
		this.mileagInterval = mileagInterval;
		this.monthTimeInterval = monthTimeInterval;
		this.LastPreformedDate = lastPreformed;
		this.lastPreformedMiles= lastPreformedMiles;
		this.ExpectedDatetoPreform = calcExpectedDate();
		this.jobEnum = jobEnum;
	}
	
	public LocalDate calcExpectedDate() {
		if(this.LastPreformedDate == null) return null;
		
		return LastPreformedDate.plusMonths(monthTimeInterval);
	}
	
	public void jobCompleted(LocalDate lastPreformed, int lastPreformedMiles) {
		this.LastPreformedDate = lastPreformed;
		this.lastPreformedMiles= lastPreformedMiles;
		this.ExpectedDatetoPreform = calcExpectedDate();
		calcMaintenance(lastPreformedMiles, lastPreformed);		
	}
	
		
	public void calcMaintenance(int newMileage, LocalDate UpdatedTime) {
		//PROB NEED TO CHANGE
		repairReason = RepairReason.NO_REPAIR; // set repair reason to no Repair
		needMaintenance = false; // sets repair requirement to false
		
		
		// Miles Until Needed Maintenance
		if(newMileage - lastPreformedMiles >= mileagInterval) {
			repairReason = RepairReason.MILES; // set repair reason to MILES
			needMaintenance = true; // sets repair requirement to true
		}
		
		if(monthTimeInterval == 0) {
			//If Month Time Interval is not required
			return;
		}
		
		// Calendar time until needed Maintenance
		if(UpdatedTime.isAfter(ExpectedDatetoPreform)) {
			if(repairReason == RepairReason.MILES) {
				repairReason = RepairReason.MILES_AND_TIME; // set repair reason to MILES and time
				needMaintenance = true; // sets repair requirement to true
			}
			else {
				repairReason = RepairReason.TIME; // set repair reason to Time
				needMaintenance = true; // sets repair requirement to true
			}
		}
		
	}
	
	public String getJobName() {
		return jobName;
	}
	
	public int getMileagInterval() {
		return mileagInterval;
	}
	
	public int getMonthTimeInterval() {
		return monthTimeInterval;
	}
	
	public String getLastPreformedDate() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		return LastPreformedDate.format(formatter);
	}
	
	public String getExpectedDatetoPreform() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		return ExpectedDatetoPreform.format(formatter);
	}
	
	public String getExpectedMiles() {
		return String.valueOf(lastPreformedMiles+mileagInterval);
	}
	
	public String getLastPreformedMiles() {
		return String.valueOf(lastPreformedMiles);
	}
	
	public String getJobEnum() {
		return jobEnum.toString();
	}
	
	public RepairType getJobEnumType() {
		return jobEnum;
	}
	
	public String getRepairReason() {
		if(repairReason == null) {
			return "None";
		}
		return repairReason.toString();
	}
	
	public String getNeedMaintence() {
		return String.valueOf(needMaintenance);
	}
	
	@Override
	public String toString() {
		
		return "( " + "Job Name: " + jobName + ", Mileage Inverval: " + mileagInterval + ", MonthInterval: " + monthTimeInterval + ", Job Last Completed:" + LastPreformedDate + ", "
				+ "Expected Next Job Date: " + ExpectedDatetoPreform + ", Last Mileage for job: " + lastPreformedMiles+ ", Expected Mileage Repair: " + (lastPreformedMiles+mileagInterval) + ", Job Type: " + jobEnum +
				", Maintenance: " + needMaintenance + ", Maintenance Type:" + repairReason + " )";   
	}
	
	
	
}
