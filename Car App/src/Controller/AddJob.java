package Controller;

import java.io.IOException;
import java.util.ArrayList;

import Model.DefaultCarJobs;
import Model.Job;
import Model.Main;
import Model.RepairType;
import Model.Save_File;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
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
	@FXML MenuButton MenuButton_DefaultJobs;
	
	ObservableList<RepairType> repairList = FXCollections.observableArrayList();
	


	@FXML public void initialize() {
		
		repairList.add(RepairType.INSPECT);
		repairList.add(RepairType.REPLACE);
		repairList.add(RepairType.TIGHTEN);
		repairList.add(RepairType.LUBRICATE);
		
		
		SpinnerValueFactory<RepairType> valueFactory = 
				new SpinnerValueFactory.ListSpinnerValueFactory<RepairType>(repairList);
		
		spinner_RepairType.setValueFactory(valueFactory);
		
		MenuButton_DefaultJobs.getItems().remove(0);
		MenuButton_DefaultJobs.getItems().remove(0);
		
		AddMenuItemsAndActions();
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
			
			selectedCar.addJob(textfield_Name.getText(), Integer.valueOf(textfield_Miles.getText()) , 
					Integer.valueOf(textfield_Months.getText()), datepicker_PreDate.getValue(),
					Integer.valueOf(textfield_PreMIles.getText()), spinner_RepairType.getValue());
			
			Label_Error.setVisible(false);
			
			//Save to DAT file
			sf.setStoredData(carDB);
			Save_File.saveData(sf);
			
			button_BackToJobs.fire();
		}
		catch(Exception e) {
			System.out.println(e);
			
			Label_Error.setVisible(true);
		}
		
		
	}
	
	// OMG EWW Bad code have to FIX LATER 
	public void AddMenuItemsAndActions() {
		MenuItem m1;
		DefaultCarJobs DJobs = new DefaultCarJobs();
		
		m1 = new MenuItem(DJobs.getDefaultJob(0).getJobName());
		MenuButton_DefaultJobs.getItems().add(m1);
		m1.setOnAction(event ->{
			Job temp = DJobs.getDefaultJob(0);
			textfield_Name.setText(temp.getJobName());
			textfield_Miles.setText(String.valueOf(temp.getMileagInterval()));
			textfield_Months.setText(String.valueOf(temp.getMonthTimeInterval()));
			spinner_RepairType.getValueFactory().setValue(temp.getJobEnumType());
		});
		m1 = new MenuItem(DJobs.getDefaultJob(1).getJobName());
		MenuButton_DefaultJobs.getItems().add(m1);
		m1.setOnAction(event ->{
			Job temp = DJobs.getDefaultJob(1);
			textfield_Name.setText(temp.getJobName());
			textfield_Miles.setText(String.valueOf(temp.getMileagInterval()));
			textfield_Months.setText(String.valueOf(temp.getMonthTimeInterval()));
			spinner_RepairType.getValueFactory().setValue(temp.getJobEnumType());
		});
		m1 = new MenuItem(DJobs.getDefaultJob(2).getJobName());
		MenuButton_DefaultJobs.getItems().add(m1);
		m1.setOnAction(event ->{
			Job temp = DJobs.getDefaultJob(2);
			textfield_Name.setText(temp.getJobName());
			textfield_Miles.setText(String.valueOf(temp.getMileagInterval()));
			textfield_Months.setText(String.valueOf(temp.getMonthTimeInterval()));
			spinner_RepairType.getValueFactory().setValue(temp.getJobEnumType());
		});
		m1 = new MenuItem(DJobs.getDefaultJob(3).getJobName());
		MenuButton_DefaultJobs.getItems().add(m1);
		m1.setOnAction(event ->{
			Job temp = DJobs.getDefaultJob(3);
			textfield_Name.setText(temp.getJobName());
			textfield_Miles.setText(String.valueOf(temp.getMileagInterval()));
			textfield_Months.setText(String.valueOf(temp.getMonthTimeInterval()));
			spinner_RepairType.getValueFactory().setValue(temp.getJobEnumType());
		});
		m1 = new MenuItem(DJobs.getDefaultJob(4).getJobName());
		MenuButton_DefaultJobs.getItems().add(m1);
		m1.setOnAction(event ->{
			Job temp = DJobs.getDefaultJob(4);
			textfield_Name.setText(temp.getJobName());
			textfield_Miles.setText(String.valueOf(temp.getMileagInterval()));
			textfield_Months.setText(String.valueOf(temp.getMonthTimeInterval()));
			spinner_RepairType.getValueFactory().setValue(temp.getJobEnumType());
		});
		m1 = new MenuItem(DJobs.getDefaultJob(5).getJobName());
		MenuButton_DefaultJobs.getItems().add(m1);
		m1.setOnAction(event ->{
			Job temp = DJobs.getDefaultJob(5);
			textfield_Name.setText(temp.getJobName());
			textfield_Miles.setText(String.valueOf(temp.getMileagInterval()));
			textfield_Months.setText(String.valueOf(temp.getMonthTimeInterval()));
			spinner_RepairType.getValueFactory().setValue(temp.getJobEnumType());
		});
		m1 = new MenuItem(DJobs.getDefaultJob(6).getJobName());
		MenuButton_DefaultJobs.getItems().add(m1);
		m1.setOnAction(event ->{
			Job temp = DJobs.getDefaultJob(6);
			textfield_Name.setText(temp.getJobName());
			textfield_Miles.setText(String.valueOf(temp.getMileagInterval()));
			textfield_Months.setText(String.valueOf(temp.getMonthTimeInterval()));
			spinner_RepairType.getValueFactory().setValue(temp.getJobEnumType());
		});
		m1 = new MenuItem(DJobs.getDefaultJob(7).getJobName());
		MenuButton_DefaultJobs.getItems().add(m1);
		m1.setOnAction(event ->{
			Job temp = DJobs.getDefaultJob(7);
			textfield_Name.setText(temp.getJobName());
			textfield_Miles.setText(String.valueOf(temp.getMileagInterval()));
			textfield_Months.setText(String.valueOf(temp.getMonthTimeInterval()));
			spinner_RepairType.getValueFactory().setValue(temp.getJobEnumType());
		});
		m1 = new MenuItem(DJobs.getDefaultJob(8).getJobName());
		MenuButton_DefaultJobs.getItems().add(m1);
		m1.setOnAction(event ->{
			Job temp = DJobs.getDefaultJob(8);
			textfield_Name.setText(temp.getJobName());
			textfield_Miles.setText(String.valueOf(temp.getMileagInterval()));
			textfield_Months.setText(String.valueOf(temp.getMonthTimeInterval()));
			spinner_RepairType.getValueFactory().setValue(temp.getJobEnumType());
		});
		m1 = new MenuItem(DJobs.getDefaultJob(9).getJobName());
		MenuButton_DefaultJobs.getItems().add(m1);
		m1.setOnAction(event ->{
			Job temp = DJobs.getDefaultJob(9);
			textfield_Name.setText(temp.getJobName());
			textfield_Miles.setText(String.valueOf(temp.getMileagInterval()));
			textfield_Months.setText(String.valueOf(temp.getMonthTimeInterval()));
			spinner_RepairType.getValueFactory().setValue(temp.getJobEnumType());
		});
		m1 = new MenuItem(DJobs.getDefaultJob(10).getJobName());
		MenuButton_DefaultJobs.getItems().add(m1);
		m1.setOnAction(event ->{
			Job temp = DJobs.getDefaultJob(10);
			textfield_Name.setText(temp.getJobName());
			textfield_Miles.setText(String.valueOf(temp.getMileagInterval()));
			textfield_Months.setText(String.valueOf(temp.getMonthTimeInterval()));
			spinner_RepairType.getValueFactory().setValue(temp.getJobEnumType());
		});
		m1 = new MenuItem(DJobs.getDefaultJob(11).getJobName());
		MenuButton_DefaultJobs.getItems().add(m1);
		m1.setOnAction(event ->{
			Job temp = DJobs.getDefaultJob(11);
			textfield_Name.setText(temp.getJobName());
			textfield_Miles.setText(String.valueOf(temp.getMileagInterval()));
			textfield_Months.setText(String.valueOf(temp.getMonthTimeInterval()));
			spinner_RepairType.getValueFactory().setValue(temp.getJobEnumType());
		});
		m1 = new MenuItem(DJobs.getDefaultJob(12).getJobName());
		MenuButton_DefaultJobs.getItems().add(m1);
		m1.setOnAction(event ->{
			Job temp = DJobs.getDefaultJob(12);
			textfield_Name.setText(temp.getJobName());
			textfield_Miles.setText(String.valueOf(temp.getMileagInterval()));
			textfield_Months.setText(String.valueOf(temp.getMonthTimeInterval()));
			spinner_RepairType.getValueFactory().setValue(temp.getJobEnumType());
		});
		m1 = new MenuItem(DJobs.getDefaultJob(13).getJobName());
		MenuButton_DefaultJobs.getItems().add(m1);
		m1.setOnAction(event ->{
			Job temp = DJobs.getDefaultJob(13);
			textfield_Name.setText(temp.getJobName());
			textfield_Miles.setText(String.valueOf(temp.getMileagInterval()));
			textfield_Months.setText(String.valueOf(temp.getMonthTimeInterval()));
			spinner_RepairType.getValueFactory().setValue(temp.getJobEnumType());
		});
		m1 = new MenuItem(DJobs.getDefaultJob(14).getJobName());
		MenuButton_DefaultJobs.getItems().add(m1);
		m1.setOnAction(event ->{
			Job temp = DJobs.getDefaultJob(14);
			textfield_Name.setText(temp.getJobName());
			textfield_Miles.setText(String.valueOf(temp.getMileagInterval()));
			textfield_Months.setText(String.valueOf(temp.getMonthTimeInterval()));
			spinner_RepairType.getValueFactory().setValue(temp.getJobEnumType());
		});
		m1 = new MenuItem(DJobs.getDefaultJob(15).getJobName());
		MenuButton_DefaultJobs.getItems().add(m1);
		m1.setOnAction(event ->{
			Job temp = DJobs.getDefaultJob(15);
			textfield_Name.setText(temp.getJobName());
			textfield_Miles.setText(String.valueOf(temp.getMileagInterval()));
			textfield_Months.setText(String.valueOf(temp.getMonthTimeInterval()));
			spinner_RepairType.getValueFactory().setValue(temp.getJobEnumType());
		});
		m1 = new MenuItem(DJobs.getDefaultJob(16).getJobName());
		MenuButton_DefaultJobs.getItems().add(m1);
		m1.setOnAction(event ->{
			Job temp = DJobs.getDefaultJob(16);
			textfield_Name.setText(temp.getJobName());
			textfield_Miles.setText(String.valueOf(temp.getMileagInterval()));
			textfield_Months.setText(String.valueOf(temp.getMonthTimeInterval()));
			spinner_RepairType.getValueFactory().setValue(temp.getJobEnumType());
		});
		m1 = new MenuItem(DJobs.getDefaultJob(17).getJobName());
		MenuButton_DefaultJobs.getItems().add(m1);
		m1.setOnAction(event ->{
			Job temp = DJobs.getDefaultJob(17);
			textfield_Name.setText(temp.getJobName());
			textfield_Miles.setText(String.valueOf(temp.getMileagInterval()));
			textfield_Months.setText(String.valueOf(temp.getMonthTimeInterval()));
			spinner_RepairType.getValueFactory().setValue(temp.getJobEnumType());
		});
		m1 = new MenuItem(DJobs.getDefaultJob(18).getJobName());
		MenuButton_DefaultJobs.getItems().add(m1);
		m1.setOnAction(event ->{
			Job temp = DJobs.getDefaultJob(18);
			textfield_Name.setText(temp.getJobName());
			textfield_Miles.setText(String.valueOf(temp.getMileagInterval()));
			textfield_Months.setText(String.valueOf(temp.getMonthTimeInterval()));
			spinner_RepairType.getValueFactory().setValue(temp.getJobEnumType());
		});
		m1 = new MenuItem(DJobs.getDefaultJob(19).getJobName());
		MenuButton_DefaultJobs.getItems().add(m1);
		m1.setOnAction(event ->{
			Job temp = DJobs.getDefaultJob(19);
			textfield_Name.setText(temp.getJobName());
			textfield_Miles.setText(String.valueOf(temp.getMileagInterval()));
			textfield_Months.setText(String.valueOf(temp.getMonthTimeInterval()));
			spinner_RepairType.getValueFactory().setValue(temp.getJobEnumType());
		});
		m1 = new MenuItem(DJobs.getDefaultJob(20).getJobName());
		MenuButton_DefaultJobs.getItems().add(m1);
		m1.setOnAction(event ->{
			Job temp = DJobs.getDefaultJob(20);
			textfield_Name.setText(temp.getJobName());
			textfield_Miles.setText(String.valueOf(temp.getMileagInterval()));
			textfield_Months.setText(String.valueOf(temp.getMonthTimeInterval()));
			spinner_RepairType.getValueFactory().setValue(temp.getJobEnumType());
		});
		m1 = new MenuItem(DJobs.getDefaultJob(21).getJobName());
		MenuButton_DefaultJobs.getItems().add(m1);
		m1.setOnAction(event ->{
			Job temp = DJobs.getDefaultJob(21);
			textfield_Name.setText(temp.getJobName());
			textfield_Miles.setText(String.valueOf(temp.getMileagInterval()));
			textfield_Months.setText(String.valueOf(temp.getMonthTimeInterval()));
			spinner_RepairType.getValueFactory().setValue(temp.getJobEnumType());
		});
		m1 = new MenuItem(DJobs.getDefaultJob(22).getJobName());
		MenuButton_DefaultJobs.getItems().add(m1);
		m1.setOnAction(event ->{
			Job temp = DJobs.getDefaultJob(22);
			textfield_Name.setText(temp.getJobName());
			textfield_Miles.setText(String.valueOf(temp.getMileagInterval()));
			textfield_Months.setText(String.valueOf(temp.getMonthTimeInterval()));
			spinner_RepairType.getValueFactory().setValue(temp.getJobEnumType());
		});
		m1 = new MenuItem(DJobs.getDefaultJob(23).getJobName());
		MenuButton_DefaultJobs.getItems().add(m1);
		m1.setOnAction(event ->{
			Job temp = DJobs.getDefaultJob(23);
			textfield_Name.setText(temp.getJobName());
			textfield_Miles.setText(String.valueOf(temp.getMileagInterval()));
			textfield_Months.setText(String.valueOf(temp.getMonthTimeInterval()));
			spinner_RepairType.getValueFactory().setValue(temp.getJobEnumType());
		});
		m1 = new MenuItem(DJobs.getDefaultJob(24).getJobName());
		MenuButton_DefaultJobs.getItems().add(m1);
		m1.setOnAction(event ->{
			Job temp = DJobs.getDefaultJob(24);
			textfield_Name.setText(temp.getJobName());
			textfield_Miles.setText(String.valueOf(temp.getMileagInterval()));
			textfield_Months.setText(String.valueOf(temp.getMonthTimeInterval()));
			spinner_RepairType.getValueFactory().setValue(temp.getJobEnumType());
		});
	}



}
