package GUI.GUI_Carpool;
 
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import GUI.I_Set_Paths_for_Current_Simulation_Example;
import Input_Output_txt.Carpool.Read_the_file_PHP_Url;
 
public class Show_JavaFX_GoogleMap extends Application {
	 static int method;
	 
    @Override
    public void start(final Stage stage) {
 
        Button buttonURL = new Button("Ridesharing  beforce  map");
        Button buttonURL1 = new Button("Ridesharing  after  map");
  
        final WebView browser = new WebView();
        final WebEngine webEngine = browser.getEngine();
 
        buttonURL.setOnAction(new EventHandler<ActionEvent>() {	
            @Override
            public void handle(ActionEvent event) {
            	method=0;
            	try {
					Write_Path_to_PHP();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            	Read_the_file_PHP_Url.main();
            	
                String url = Read_the_file_PHP_Url.getUrl()+"/Ridesharing_beforce_map.php";
                // Load a page from remote url.
                webEngine.load(url);
            }
        });
 
        buttonURL1.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public void handle(ActionEvent event) {
            	method=0;
            	try {
					Write_Path_to_PHP();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
             	Read_the_file_PHP_Url.main();
                
                String url = Read_the_file_PHP_Url.getUrl()+"/Ridesharing_after_map.php";
                // Load a page from remote url.
                webEngine.load(url);
            }
        });

        VBox root = new VBox();
        root.setPadding(new Insets(5));
        root.setSpacing(5);
        root.getChildren().addAll(buttonURL, buttonURL1, browser);
 
        Scene scene = new Scene(root);
 
        stage.setTitle("JavaFX WebView");
        stage.setScene(scene);
        stage.setWidth(600);
        stage.setHeight(600);
 
        stage.show();
    }
 

  public static void main() throws IOException  {
	  launch();
  }
  
	static	void Write_Path_to_PHP() throws IOException{
		
		File f=new File(System.getProperty("user.dir"));
				
		   FileWriter fw1 = new FileWriter("Read_the_file_to_php_show_map.txt");
		   
			if(method==1){
			fw1.write(f.getAbsolutePath()+"\\output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()
					   +X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"Ridesharing_after_location_lat_and_lng.txt");
			 fw1.write("\r\n");
			 fw1.write(f.getAbsolutePath()+"\\output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()
					   +X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"Ridesharing_after_distance_Geton_and_Getoff.txt") ;
			 fw1.write("\r\n");
			}
		     if(method==0){
			fw1.write(f.getAbsolutePath()+"\\output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()
							   +X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"Ridesharing_beforce_location_lat_and_lng.txt");
			fw1.write("\r\n");
		    fw1.write(f.getAbsolutePath()+"\\output\\"+I_Set_Paths_for_Current_Simulation_Example.filename()
					   +X_Select_Algorithm_Type_to_Solve_the_Problem.path()+"Ridesharing_beforce_location_Geton_and_Getoff.txt") ;
		    fw1.write("\r\n");
		     }
		   fw1.close();		
		   }
  
}