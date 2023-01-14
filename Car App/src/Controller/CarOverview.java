package Controller;

import Model.Job;
import Model.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class CarOverview extends Main{
	
	@FXML Label label_CarName;
	@FXML TableView<Job> tableview_CarJobs;
	
	@FXML TableColumn<Job, String> col_JobName = new TableColumn<Job, String>("Job Name");
	@FXML TableColumn<Job, String> col_MilesInt = new TableColumn<Job, String>("Miles Interval");
	@FXML TableColumn<Job, String> col_MonthInt = new TableColumn<Job, String>("Month Interval");
	@FXML TableColumn<Job, String> col_ExpectedDate = new TableColumn<Job, String>("Expected Date");
	@FXML TableColumn<Job, String> col_ExpectedMiles = new TableColumn<Job, String>("Expected Miles");
	@FXML TableColumn<Job, String> col_LastMiles = new TableColumn<Job, String>("Previous Miles Job Preformened");
	@FXML TableColumn<Job, String> col_JobType = new TableColumn<Job, String>("Job Type");
	@FXML TableColumn<Job, String> col_RepairReason = new TableColumn<Job, String>("Repair Reason");
	@FXML TableColumn<Job, String> col_Maintenence = new TableColumn<Job, String>("Maintence Needed");
	
	
	
	@FXML public void initialize() {
		
		label_CarName.setText(selectedCar.getCarName());
		col_JobName.setCellValueFactory(new PropertyValueFactory<Job, String>("jobName"));
		col_MilesInt.setCellValueFactory(new PropertyValueFactory<Job, String>("mileagInterval"));
		col_MonthInt.setCellValueFactory(new PropertyValueFactory<Job, String>("monthTimeInterval"));
		col_ExpectedDate.setCellValueFactory(new PropertyValueFactory<Job, String>("ExpectedDatetoPreform"));
		col_ExpectedMiles.setCellValueFactory(new PropertyValueFactory<Job, String>("ExpectedMiles"));
		col_LastMiles.setCellValueFactory(new PropertyValueFactory<Job, String>("lastPreformedMiles"));
		col_JobType.setCellValueFactory(new PropertyValueFactory<Job, String>("jobEnum"));
		col_RepairReason.setCellValueFactory(new PropertyValueFactory<Job, String>("repairReason"));
		col_Maintenence.setCellValueFactory(new PropertyValueFactory<Job, String>("needMaintence"));
		
		
		tableview_CarJobs.getColumns().add(col_JobName);
		tableview_CarJobs.getColumns().add(col_MilesInt);
		tableview_CarJobs.getColumns().add(col_MonthInt);
		tableview_CarJobs.getColumns().add(col_ExpectedDate);
		tableview_CarJobs.getColumns().add(col_ExpectedMiles);
		tableview_CarJobs.getColumns().add(col_LastMiles);
		tableview_CarJobs.getColumns().add(col_JobType);
		tableview_CarJobs.getColumns().add(col_RepairReason);
		tableview_CarJobs.getColumns().add(col_Maintenence);
		
		tableview_CarJobs.autosize();
		tableview_CarJobs.getItems().addAll(selectedCar.getJobs());
	}

}
