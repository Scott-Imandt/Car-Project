package Controller;

import java.io.IOException;

import Model.Job;
import Model.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.skin.MenuButtonSkin;
import javafx.stage.Stage;

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
	
	@FXML MenuButtonSkin filter;
	@FXML RadioMenuItem Radio_JobName;
	@FXML RadioMenuItem Radio_MilesInterval;
	@FXML RadioMenuItem Radio_MonthInt;
	@FXML RadioMenuItem Radio_ExpectedDate;
	@FXML RadioMenuItem Radio_ExpectedMiles;
	@FXML RadioMenuItem Radio_PrevMiles;
	@FXML RadioMenuItem Radio_RepairReason;
	@FXML RadioMenuItem Radio_Needed;
	@FXML RadioMenuItem Radio_JobType;
	
	Job SelectedJob = null;
	
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
		
		// Default Items on list
		tableview_CarJobs.getColumns().add(col_JobName);
		Radio_JobName.setSelected(true);
		tableview_CarJobs.getColumns().add(col_ExpectedDate);
		Radio_ExpectedDate.setSelected(true);
		tableview_CarJobs.getColumns().add(col_ExpectedMiles);
		Radio_ExpectedMiles.setSelected(true);
		tableview_CarJobs.getColumns().add(col_Maintenence);
		Radio_Needed.setSelected(true);
		
		
		tableview_CarJobs.autosize();
				
		tableview_CarJobs.getItems().addAll(selectedCar.getJobs());
		
		
	}
	
	@FXML public void JobNameFilter(ActionEvent event) {
		
		if(Radio_JobName.isSelected()) {			
			tableview_CarJobs.getColumns().add(col_JobName);
		}
		else {
			tableview_CarJobs.getColumns().remove(col_JobName);
		}
		
	}
	
	@FXML public void MilesIntervalFilter(ActionEvent event) {
		
		if(Radio_MilesInterval.isSelected()) {			
			tableview_CarJobs.getColumns().add(col_MilesInt);
		}
		else {
			tableview_CarJobs.getColumns().remove(col_MilesInt);
		}
		
	}

	@FXML public void MonthIntervalFilter(ActionEvent event) {
		
		if(Radio_MonthInt.isSelected()) {			
			tableview_CarJobs.getColumns().add(col_MonthInt);
		}
		else {
			tableview_CarJobs.getColumns().remove(col_MonthInt);
		}
		
	}	
	
	@FXML public void ExpectedDateFilter(ActionEvent event) {
		
		if(Radio_ExpectedDate.isSelected()) {			
			tableview_CarJobs.getColumns().add(col_ExpectedDate);
		}
		else {
			tableview_CarJobs.getColumns().remove(col_ExpectedDate);
		}
		
	}	
	
	@FXML public void ExpectedMilesFilter(ActionEvent event) {
		
		if(Radio_ExpectedMiles.isSelected()) {			
			tableview_CarJobs.getColumns().add(col_ExpectedMiles);
		}
		else {
			tableview_CarJobs.getColumns().remove(col_ExpectedMiles);
		}
		
	}

	@FXML public void PrevMilesFilter(ActionEvent event) {
		
		if(Radio_PrevMiles.isSelected()) {			
			tableview_CarJobs.getColumns().add(col_LastMiles);
		}
		else {
			tableview_CarJobs.getColumns().remove(col_LastMiles);
		}
		
	}
	
	@FXML public void RepairReasonFilter(ActionEvent event) {
		
		if(Radio_RepairReason.isSelected()) {			
			tableview_CarJobs.getColumns().add(col_RepairReason);
		}
		else {
			tableview_CarJobs.getColumns().remove(col_RepairReason);
		}
		
	}
		
	@FXML public void NeededFilter(ActionEvent event) {
		
		if(Radio_Needed.isSelected()) {			
			tableview_CarJobs.getColumns().add(col_Maintenence);
		}
		else {
			tableview_CarJobs.getColumns().remove(col_Maintenence);
		}
		
	}
	
	@FXML public void JobTypeFilter(ActionEvent event) {
		
		if(Radio_JobType.isSelected()) {			
			tableview_CarJobs.getColumns().add(col_JobType);
		}
		else {
			tableview_CarJobs.getColumns().remove(col_JobType);
		}
		
	}
	
	@FXML public void AddJobsView(ActionEvent event) {
		
		try {
			Parent AddJobView = FXMLLoader.load(getClass().getResource("../View/AddJob.fxml"));
			Scene AddJobScene = new Scene(AddJobView);
			Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
			
			window.setScene(AddJobScene);
			window.show();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	@FXML public void DeleteJob(ActionEvent event) {
		
		// Add Clause to show that nothing is selected
		
		SelectedJob = tableview_CarJobs.getSelectionModel().getSelectedItem();
		
		tableview_CarJobs.getItems().removeAll(selectedCar.getJobs());
		
		selectedCar.getJobs().remove(SelectedJob);
		
		tableview_CarJobs.getItems().addAll(selectedCar.getJobs());
		
		SelectedJob = null;
	}
	
	@FXML public void CompletedJob(ActionEvent event) {
		
		SelectedJob = tableview_CarJobs.getSelectionModel().getSelectedItem();
		
		if(SelectedJob != null) {
			
			try {
				Parent CompleteJobView = FXMLLoader.load(getClass().getResource("../View/CompleteJob.fxml"));
				Scene CompleteJobScene = new Scene(CompleteJobView);
				Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
				
				window.setScene(CompleteJobScene);
				window.show();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}

}
