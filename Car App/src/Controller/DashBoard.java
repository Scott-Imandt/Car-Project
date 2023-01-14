package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

import Model.Main;

public class DashBoard extends Main{

	@FXML Label Label_CarName1;
	@FXML Label Label_CarMilage1;
	@FXML Label Label_CarName11;
	@FXML Label Label_CarMilage11;
	@FXML Label Label_CarName12;
	@FXML Label Label_CarMilage12;
	@FXML Label Label_CarName13;
	@FXML Label Label_CarMilage13;
	@FXML Label Label_CarName14;
	@FXML Label Label_CarMilage14;
	@FXML Label Label_CarName15;
	@FXML Label Label_CarMilage15;
	@FXML Label Label_CarName16;
	@FXML Label Label_CarMilage16;
	@FXML Label Label_CarName17;
	@FXML Label Label_CarMilage17;
	@FXML Label Label_CarName18;
	@FXML Label Label_CarMilage18;
	@FXML Label Label_CarName19;
	@FXML Label Label_CarMilage19;
	
	private ArrayList<Label> carNameList = new ArrayList<Label>();
	private ArrayList<Label> carMilageList = new ArrayList<Label>();
	
	@FXML public void initialize() {
		
		// add all Car Name labels to the arrayList
		carNameList.add(Label_CarName1);
		carNameList.add(Label_CarName11);
		carNameList.add(Label_CarName12);
		carNameList.add(Label_CarName13);
		carNameList.add(Label_CarName14);
		carNameList.add(Label_CarName15);
		carNameList.add(Label_CarName16);
		carNameList.add(Label_CarName17);
		carNameList.add(Label_CarName18);
		carNameList.add(Label_CarName19);
		
		//add all Car miles labels to the List
		carMilageList.add(Label_CarMilage1);
		carMilageList.add(Label_CarMilage11);
		carMilageList.add(Label_CarMilage12);
		carMilageList.add(Label_CarMilage13);
		carMilageList.add(Label_CarMilage14);
		carMilageList.add(Label_CarMilage15);
		carMilageList.add(Label_CarMilage16);
		carMilageList.add(Label_CarMilage17);
		carMilageList.add(Label_CarMilage18);
		carMilageList.add(Label_CarMilage19);
		
		System.out.println(carDB.getArrayList());
		
		for(int i =0; i<carDB.getArrayList().size(); i++) {
			
			carNameList.get(i).setVisible(true);
			carMilageList.get(i).setVisible(true);
			carNameList.get(i).setText(carDB.getCar(i).getCarName());
			carMilageList.get(i).setText(String.valueOf(carDB.getCar(i).getCurrentMileage()));
		}

	}
	
	
	@FXML public void switchToCreateCarScene(ActionEvent event) {
	
		try {
			Parent createCarView = FXMLLoader.load(getClass().getResource("../View/CreateCar.fxml"));
			Scene createCarScene = new Scene(createCarView);
			Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
			
			window.setScene(createCarScene);
			window.show();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	// selectors for cars NEED TO CHANGE
	
	@FXML public void CarSelected(MouseEvent event) {
		
		if(Label_CarName1.isVisible()) {
			
			selectedCar = carDB.getCar(0);
			
			
			// go to car Screens
			try {
				Parent carOverviewView = FXMLLoader.load(getClass().getResource("../View/CarOverview.fxml"));
				Scene carOverviewScene = new Scene(carOverviewView);
				Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
				
				window.setScene(carOverviewScene);
				window.show();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			
		}
		
		return;
		
	}
	
	
	
}
