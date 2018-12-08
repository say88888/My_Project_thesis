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
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import GUI.I_Set_Paths_for_Current_Simulation_Example;
import Input_Output_txt.Carpool.Read_the_file_PHP_Url;
 
public class Show_JavaFX_PHP extends Application {
	 static int method;
	 
	    @Override
	    public void start(final Stage stage) {
	 
	        Button buttonURL = new Button("member.php");
	        Button buttonURL1 = new Button("Map");
	  
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
	            	
	                String url = Read_the_file_PHP_Url.getUrl()+"/member.php";
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
	                
	    	     WebView browser2 = new WebView();
	    	     WebEngine webEngine2 = browser2.getEngine();
	                
	                String url = Read_the_file_PHP_Url.getUrl()+"/Drawpoints.html";
	                // Load a page from remote url.
	                webEngine2.load(url);
	                StackPane root2 = new StackPane();
	                Stage stage2 = new Stage();
	              
	                root2.setPadding(new Insets(5));
	                root2.getChildren().addAll(browser2);
	         
	                Scene scene2 = new Scene(root2);
	         
	                stage2.setTitle("JavaFX WebView");
	                stage2.setScene(scene2);
	                stage2.setWidth(600);
	                stage2.setHeight(600);
	                
	                 stage2.show();
	                
	                
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
	  Write_Path_to_PHP();
  }
  
  	static	void Write_Path_to_PHP() throws IOException{
		
		File f=new File(System.getProperty("user.dir"));
				
		   FileWriter fw1 = new FileWriter("Read_the_file_to_php_Generate_Data.txt");   
	
			fw1.write(f.getAbsolutePath()+"\\input\\"+I_Set_Paths_for_Current_Simulation_Example.filename());
			fw1.write("");
		   fw1.close();		
		   }
  
}