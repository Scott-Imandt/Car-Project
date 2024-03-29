package Controller;

import java.io.IOException;
import java.util.ArrayList;

import Model.Job;
import Model.Save_File;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class CompletedJob extends CarOverview{
	
	int jobIndex;
	
	@FXML Label label_JobName;
	@FXML Label label_MileInt;
	@FXML Label label_MonthInt;
	@FXML Label label_RepairType;
	@FXML TextField textfield_CompletedMiles;
	@FXML DatePicker datepicker_CompletedDate;
	@FXML TextField textfield_ProductName;
	@FXML TextArea TextArea_ProductLink;
	@FXML Button button_BackToJobs;
	
	
	@Override
	@FXML public void initialize() {
		
		
		for(int i = 0; i < selectedCar.getJobs().size(); i++) {
							
			if(selectedCar.getJobs().get(i) == (SelectedJob)) {
				//if the selected job equals the array index
			
				jobIndex = i;
				break;
			}			
		}
		
		label_JobName.setText(selectedCar.getJobs().get(jobIndex).getJobName());
		label_MileInt.setText(String.valueOf(selectedCar.getJobs().get(jobIndex).getMileagInterval()));
		label_MonthInt.setText(String.valueOf(selectedCar.getJobs().get(jobIndex).getMonthTimeInterval()));
		label_RepairType.setText(selectedCar.getJobs().get(jobIndex).getJobEnum());
		
		
		//Set SelectedJob Back to null
		
		SelectedJob = null;
	}
	
	@FXML public void BackToJobs(ActionEvent event) {
		
		try {
			Parent CarOverviewView = FXMLLoader.load(getClass().getResource("../View/CarOverview.fxml"));
			Scene CarOverviewScene = new Scene(CarOverviewView);
			Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
			window.setResizable(true);
			window.setScene(CarOverviewScene);
			window.show();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	@FXML public void SubmitJob(ActionEvent event) {
		
		try {
					
			if(textfield_ProductName.getText() == "" && TextArea_ProductLink.getText() == "") {
			
				selectedCar.jobCompleted(jobIndex, datepicker_CompletedDate.getValue(), Integer.valueOf(textfield_CompletedMiles.getText()));
				
				//Save to DAT file
				sf.setStoredData(carDB);
				Save_File.saveData(sf);
				
				button_BackToJobs.fire();
			
			}
		
			else if(textfield_ProductName.getText() != "" && TextArea_ProductLink.getText() != "") {
				selectedCar.jobCompleted(jobIndex, datepicker_CompletedDate.getValue(), Integer.valueOf(textfield_CompletedMiles.getText()),
				textfield_ProductName.getText(), TextArea_ProductLink.getText());
				
				//Save to DAT file
				sf.setStoredData(carDB);
				Save_File.saveData(sf);
				
				button_BackToJobs.fire();

			}
		
		}
		catch(Exception e) {
			
			Alert a = new Alert(AlertType.ERROR);
			a.setHeaderText("Error caused by bad data!");
			a.setContentText("Error: "+ e);
			a.show();
			System.out.println(e);
			
			// add a label that can tell the user what the error is
		}
		
	}

}
