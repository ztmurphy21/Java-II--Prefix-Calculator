/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prefixcalculator;

import com.sun.corba.se.impl.activation.CommandHandler;
import java.awt.Insets;
import static java.awt.SystemColor.info;
import java.util.Scanner;
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
import static jdk.nashorn.internal.runtime.JSType.isNumber;

/**
 *
 * @author Zachary Murphy
 */
public class PrefixCalc extends Application{
   @Override 
    public void start(Stage primaryStage) {
        PrefixCalculator one = new PrefixCalculator();
        
        
        //input for user command
        TextField inputTextField = new TextField();
        inputTextField.setPrefColumnCount(5);
        
        //will give results
        TextField resultTextField = new TextField();
        resultTextField.setPrefColumnCount(5);
        resultTextField.setEditable(false);
        
        EventHandler<ActionEvent> handler = 
                new CommandHandler(one, inputTextField, resultTextField);
        inputTextField.setOnAction(handler);
        
        
        //vbox to hold fields/labels
      VBox vBox1 = new VBox(10);
      Label cmdLabel = new Label("Command: ");
      Label resultLabel = new Label ("Results: ");

      vBox1.getChildren().addAll(cmdLabel, inputTextField, resultLabel, resultTextField);
      
      
      //vobx to add to scene
     VBox vBox = new VBox(30);
     
     vBox.getChildren().addAll(vBox1);
     
      

      
      //setting all up
      primaryStage.setScene(new Scene(vBox));
      primaryStage.setTitle("Prefix Calculator Tool");
      primaryStage.setHeight(250);
      primaryStage.setWidth(300);
      
      primaryStage.show();
      
         
      
        
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch();
    }
    
    //event handler
    class CommandHandler implements EventHandler<ActionEvent>{
        private PrefixCalculator one;
        private TextField inputTextField;
        private TextField resultTextField;
        
        
        //constructor for command hendler
        CommandHandler(PrefixCalculator preone, TextField iField, TextField rField ){
            one = preone;
            inputTextField = iField;
            resultTextField = rField;
        }
        @Override
        public void handle(ActionEvent event) {
            //THIS IS WHERE I AM STUCK AT WHAT TO DO
            
    }

}
}



