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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CreateCar extends Main{
	
	
	@FXML TextField textfield_Name;
	@FXML TextField textfield_Miles;
	@FXML Button btn_Submit;
	@FXML Label label_ErrorMessage;
	
	
	
	
	@FXML public void CreateCarAction(ActionEvent event) {
				
		String carName = null;
		int carMiles = 0;
		
		try {
			carName = textfield_Name.getText();
			carMiles = Integer.valueOf(textfield_Miles.getText());
		}
		catch(NumberFormatException e) {
			
			label_ErrorMessage.setVisible(true);
			
			return;
		}
		
		label_ErrorMessage.setVisible(false);
		
		carDB.createCar(carName, carMiles);
		
		//Save to DAT file
		sf.setStoredData(carDB);
		Save_File.saveData(sf);
		
		try {
			Parent dashboardView = FXMLLoader.load(getClass().getResource("../View/DashBoard.fxml"));
			Scene dashboardScene = new Scene(dashboardView);
			Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
			
			window.setScene(dashboardScene);
			window.show();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	
	
	@FXML public void switchToDashboard(ActionEvent event) {
		
		try {
			Parent dashboardView = FXMLLoader.load(getClass().getResource("../View/DashBoard.fxml"));
			Scene dashboardScene = new Scene(dashboardView);
			Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
			
			window.setScene(dashboardScene);
			window.show();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
