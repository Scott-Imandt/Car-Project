package Model;

import java.util.ArrayList;

public class DefaultCarJobs {
	
	private ArrayList<Job> defaultJobs = new ArrayList<Job>();
	
	public DefaultCarJobs() {
		
		AddDefaultJobs();
	}
	
	public void AddDefaultJobs() {
		Job temp = new Job("Drive belt", 30000, 36, null, 0, RepairType.INSPECT);
		defaultJobs.add(temp);
		temp = new Job("Synthetic Oil and Filter", 10000, 12, null, 0, RepairType.REPLACE);
		defaultJobs.add(temp);
		temp = new Job("Regular Oil and Filter", 5000, 6, null, 0, RepairType.REPLACE);
		defaultJobs.add(temp);
		temp = new Job("FL22 Type Coolent", 120000, 120, null, 0, RepairType.REPLACE);
		defaultJobs.add(temp);
		temp = new Job("Other Type Coolent", 60000, 48, null, 0, RepairType.REPLACE);
		defaultJobs.add(temp);
		temp = new Job("Engine Air Filter", 37500, 36, null, 0, RepairType.REPLACE);
		defaultJobs.add(temp);
		temp = new Job("Fuel Lines and Hoses", 20000, 24, null, 0, RepairType.INSPECT);
		defaultJobs.add(temp);
		temp = new Job("Hoses and Tubes for Emission", 40000, 48, null, 0, RepairType.INSPECT);
		defaultJobs.add(temp);
		temp = new Job("Spark Plugs", 75000, 0, null, 0, RepairType.REPLACE);
		defaultJobs.add(temp);
		temp = new Job("Brake Line, Hose and Connections", 75000, 0, null, 0, RepairType.INSPECT);
		defaultJobs.add(temp);
		temp = new Job("Disc Brakes", 10000, 12, null, 0, RepairType.INSPECT);
		defaultJobs.add(temp);
		temp = new Job("Tire Rotation", 5000, 0, null, 0, RepairType.REPLACE);
		defaultJobs.add(temp);
		temp = new Job("Steering Operation and Linkages", 20000, 24, null, 0, RepairType.INSPECT);
		defaultJobs.add(temp);
		temp = new Job("Front and Rear Suspension, Ball Joints and Wheel Bearing Axial Play", 20000, 24, null, 0, RepairType.INSPECT);
		defaultJobs.add(temp);
		temp = new Job("Driveshaft Dust Boots", 20000, 24, null, 0, RepairType.INSPECT);
		defaultJobs.add(temp);
		temp = new Job("Bolts and Nuts on Chassis and body", 20000, 24, null, 0, RepairType.TIGHTEN);
		defaultJobs.add(temp);
		temp = new Job("Exhaust System and Heat Shields", 40000, 48, null, 0, RepairType.INSPECT);
		defaultJobs.add(temp);
		temp = new Job("Cabin Air Filter", 30000, 24, null, 0, RepairType.REPLACE);
		defaultJobs.add(temp);
		temp = new Job("Function of all Lights", 5000, 4, null, 0, RepairType.INSPECT);
		defaultJobs.add(temp);
		temp = new Job("Brake and Clutch Fluid level", 5000, 4, null, 0, RepairType.INSPECT);
		defaultJobs.add(temp);
		temp = new Job("All Locks and Hinges", 5000, 4, null, 0, RepairType.LUBRICATE);
		defaultJobs.add(temp);
		temp = new Job("Washer Fluid Level", 5000, 4, null, 0, RepairType.INSPECT);
		defaultJobs.add(temp);
		temp = new Job("Body Condition (Rust, Corrosion, Perforation)", 15000, 12, null, 0, RepairType.INSPECT);
		defaultJobs.add(temp);
		temp = new Job("Brake Pads", 10000, 0, null, 0, RepairType.INSPECT);
		defaultJobs.add(temp);
		temp = new Job("Brake Rotors", 50000, 0, null, 0, RepairType.INSPECT);
		defaultJobs.add(temp);
	}
	
	public Job getDefaultJob(int index) {
		return defaultJobs.get(index);
	}
	
	public ArrayList<Job> getArrayList(){
		return defaultJobs;
	}
	

}
