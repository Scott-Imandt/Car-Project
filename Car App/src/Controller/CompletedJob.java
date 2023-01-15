package Controller;

import java.io.IOException;
import java.util.ArrayList;

import Model.Job;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
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
		
		ArrayList<Job> tempList = selectedCar.getJobs();
		for(int i = 0; i < tempList.size(); i++) {
			
			if(tempList.get(i).equals(SelectedJob)) {
				//if the selected job equals the array index
				
				jobIndex = i;
				break;
			}			
		}
		
		label_JobName.setText(tempList.get(jobIndex).getJobName());
		label_MileInt.setText(String.valueOf(tempList.get(jobIndex).getMileagInterval()));
		label_MonthInt.setText(String.valueOf(tempList.get(jobIndex).getMonthTimeInterval()));
		label_RepairType.setText(tempList.get(jobIndex).getJobEnum());
		
		
		
	}
	
	@FXML public void BackToJobs(ActionEvent event) {
		
		try {
			Parent CarOverviewView = FXMLLoader.load(getClass().getResource("../View/CarOverview.fxml"));
			Scene CarOverviewScene = new Scene(CarOverviewView);
			Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
			
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
				button_BackToJobs.fire();
			
			}
		
			else if(textfield_ProductName.getText() != "" && TextArea_ProductLink.getText() != "") {
				selectedCar.jobCompleted(jobIndex, datepicker_CompletedDate.getValue(), Integer.valueOf(textfield_CompletedMiles.getText()),
					textfield_ProductName.getText(), TextArea_ProductLink.getText());
			
				button_BackToJobs.fire();

			}
		
		}
		catch(Exception e) {
			System.out.println(e);
			// add a label that can tell the user what the error is
		}
		
	}

}
