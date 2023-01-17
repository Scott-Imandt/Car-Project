package Model;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{
	
	protected static Car_Storage carDB = null;
	public static Car selectedCar = null;
	public static Save_File sf; 

	public static void main(String[] args) {
		
		sf = Save_File.loadData();
		carDB = sf.getStoredData();
		
		//System.out.println(carDB.getCar(0).getJobs());
		//System.out.println(carDB.getCar(0).getCompletedJobs());
		
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		
		Parent root = FXMLLoader.load(getClass().getResource("/View/DashBoard.fxml"));
		
		
		Scene scene = new Scene(root);
		
		stage.setTitle("Car Tracker V0.5.0");
		stage.setScene(scene);
		stage.show(); // shows the window and start the app
	
	}
	
	
	@Override
	public void stop() {
		sf.setStoredData(carDB);
		Save_File.saveData(sf);
	}

}
