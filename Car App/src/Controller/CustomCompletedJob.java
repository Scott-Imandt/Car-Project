package Controller;

import java.io.IOException;

import Model.Main;
import Model.Save_File;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class CustomCompletedJob extends Main{

	
	@FXML TextField textfield_CustomName;
	@FXML TextField textfield_CompletedMiles;
	@FXML DatePicker datepicker_CompletedDate;
	@FXML TextField textfield_ProductName;
	@FXML TextArea  textarea_ProductLink;
	
	
	
	@FXML public void SubmitJob(ActionEvent event) {
		
		try{
			if(textfield_ProductName.getText().equals(null) && textarea_ProductLink.getText().equals(null)) {
				
				selectedCar.jobCompleted(textfield_CustomName.getText(), datepicker_CompletedDate.getValue(), Integer.valueOf(textfield_CompletedMiles.getText()));
				
			}
			else if(!(textfield_ProductName.getText().equals(null)) && !(textarea_ProductLink.getText().equals(null))){
				
				selectedCar.jobCompleted(textfield_CustomName.getText(), datepicker_CompletedDate.getValue(), Integer.valueOf(textfield_CompletedMiles.getText()),
						textfield_ProductName.getText(), textarea_ProductLink.getText());
			}
			
			//Save to DAT file
			sf.setStoredData(carDB);
			Save_File.saveData(sf);
			
			this.BackToJobs(event);
		}catch(Exception e){
			
			Alert a = new Alert(AlertType.ERROR);
			a.setHeaderText("Error caused by bad data!");
			a.setContentText("Error: "+ e);
			a.show();
			System.out.println(e);
			
		}	
		
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
	
}
