package Controller;

import java.io.IOException;
import java.util.ArrayList;

import Model.Main;
import Model.RepairType;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddJob extends Main{
	
	@FXML TextField textfield_Name;
	@FXML TextField textfield_Miles;
	@FXML TextField textfield_Months;
	@FXML TextField textfield_PreMIles;
	@FXML DatePicker datepicker_PreDate;
	@FXML Label Label_Error;
	@FXML Button button_BackToJobs;
	@FXML Spinner<RepairType> spinner_RepairType = new Spinner<RepairType>();
	
	ObservableList<RepairType> repairList = FXCollections.observableArrayList();
	


	@FXML public void initialize() {
		
		repairList.add(RepairType.INSPECT);
		repairList.add(RepairType.REPLACE);
		repairList.add(RepairType.TIGHTEN);
		repairList.add(RepairType.LUBRICATE);
		
		
		SpinnerValueFactory<RepairType> valueFactory = 
				new SpinnerValueFactory.ListSpinnerValueFactory<RepairType>(repairList);
		
		spinner_RepairType.setValueFactory(valueFactory);
		
		
		
		
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
			
			selectedCar.addJob(textfield_Name.getText(), Integer.valueOf(textfield_Miles.getText()) , 
					Integer.valueOf(textfield_Months.getText()), datepicker_PreDate.getValue(),
					Integer.valueOf(textfield_PreMIles.getText()), spinner_RepairType.getValue());
			
			Label_Error.setVisible(false);
			
			button_BackToJobs.fire();
		}
		catch(Exception e) {
			System.out.println(e);
			
			Label_Error.setVisible(true);
		}
		
		
	}



}
