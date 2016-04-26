/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prefixcalculator;

import com.sun.corba.se.impl.activation.CommandHandler;
import java.awt.Insets;
import static java.awt.SystemColor.info;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Zachary Murphy
 */
public class PrefixCalc extends PrefixCalculator{
   
    public void start(Stage primaryStage) {
        PrefixCalculator one = new PrefixCalculator();
        
        
        //input for user command
        TextField cmdTextField = new TextField();
        cmdTextField.setPrefColumnCount(5);
        
        //will give results
        TextField resultTextField = new TextField();
        resultTextField.setPrefColumnCount(5);
        resultTextField.setEditable(false);
        
        
        //vbox to hold fields/labels
      VBox vBox1 = new VBox(10);
      Label cmdLabel = new Label("Command: ");
      Label resultLabel = new Label ("Results: ");

      vBox1.getChildren().addAll(cmdLabel, cmdTextField, resultLabel, resultTextField);
      
      
      //vobx to add to scene
     VBox vBox = new VBox(10);
     vBox.setPadding(new Insets(20));
     vBox.getChildren().addAll(vBox1);
     
      

      
      //setting all up
      primaryStage.setScene(new Scene(vBox));
      primaryStage.setTitle("Prefix Calculator Tool");
      primaryStage.show();
      
         
      
        
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch();
    }
    
}
