/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prefixcalculator;

import com.sun.corba.se.impl.activation.CommandHandler;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Panel;
import static java.awt.SystemColor.info;
import java.awt.event.ActionListener;
import java.util.Scanner;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
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
     private TextField displayField; 
    private TextField resultField;
    private TextField cmdField;
   
   
  
    @Override
    public void start(Stage primaryStage) throws Exception {
        PrefixCalc one = new PrefixCalc();
      
        //setting up stuff for Prefix Exp
      Label prefixExp = new Label("Prefix Expression");
      TextField displayField = new TextField();
      displayField.setEditable(false);
      //Prefix Exp HBox
      HBox display = new HBox();
      display.getChildren().addAll(prefixExp, displayField);
      
      //result output set up
      Label result = new Label("Result Output: ");
      TextField resultField = new TextField();
      resultField.setEditable(false);
      
      //result hbox
      HBox results = new HBox();
      results.getChildren().addAll(result, resultField);
      
      
      
      //input line set up
      TextField cmdField = new TextField();
      Label cmdLabel = new Label("Enter Your Expression: ");
       
      
      
      //hbox for input line
      HBox cmd = new HBox();
      cmd.getChildren().addAll(cmdLabel, cmdField);
      
      Button submit = new Button("Calculate");
      
      //main vbox for all hboxes 
      VBox main = new VBox(20);
      main.getChildren().addAll(display, results, cmd, submit);
      EventHandler<ActionEvent> handle = new CmdTextListener();
      submit.setOnAction(handle);

      //majic for stage ;)
      primaryStage.setScene(new Scene(main));
      primaryStage.setTitle("My Program");
      primaryStage.show();
      
      
}

    
    //reads prefix input
      private class CmdTextListener implements EventHandler<ActionEvent>
              
    {
   
    

        @Override
        public void handle(ActionEvent event) {
            
            String pExpr = cmdField.getText();
            Node exprTree = buildExpr(new Scanner(pExpr));
            int value = eval(exprTree);
           displayField.setText(pExpr);
            resultField.setText(String.valueOf(value));
            
        }
       
        //reads tree and reutrns val
        private int eval(Node tree)
        {
            if (tree.left == null && tree.right == null) 
                return Integer.parseInt(tree.value);
            else
            {
                int leftOp = eval(tree.left);
                int rightOp = eval(tree.right);
                if (tree.value.equals("*"))
                    return leftOp * rightOp;
                if (tree.value.equals("+"))
                    return leftOp + rightOp;
            }           
            return 0;  // Will never be reached
        }
        //is it a number starting?
        private boolean isNumber(String s)
        {
            return Character.isDigit(s.charAt(0));
        }



        
        private class Node
        {
            String value;
            Node left, right;

            Node(String v, Node l, Node r)
            {
                value = v;
                left = l;
                right = r;
            }
        }
        
       //builds and reads tree
        
        Node buildExpr(Scanner sc)
        {
            String s = sc.next();
            if (isNumber(s))
                return new Node(s, null, null);
            else
            {
                // s is an operator, so build a non-leaf tree
                Node leftOp = buildExpr(sc);
                Node rightOp = buildExpr(sc);
                return new Node(s, leftOp, rightOp);
            }            
        }
     }
    public static void main(String[] args){
        launch(args);
    }


    }








