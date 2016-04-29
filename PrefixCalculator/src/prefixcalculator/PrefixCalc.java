package prefixcalculator;

import java.util.Scanner;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;



/**
 *
 * @author Zachary Murphy
 */
public class PrefixCalc extends Application{
     //private TextField displayField; 
    private TextField resultField;
    private TextField cmdField;
   
   
  
    @Override
    public void start(Stage primaryStage) throws Exception {
        PrefixCalc one = new PrefixCalc();
      
        //setting up stuff for Prefix Exp
      Label prefixExp = new Label("Prefix Expression");
    
      
      //result output set up
      Label result = new Label("Result Output: ");
      resultField = new TextField();
      resultField.setEditable(false);
      
      //result hbox
      HBox results = new HBox();
      results.getChildren().addAll(result, resultField);
      
      
      
      //input line set up
      cmdField = new TextField();
      Label cmdLabel = new Label("Enter Your Expression: ");
       
      
      
      //hbox for input line
      HBox cmd = new HBox();
      cmd.getChildren().addAll(cmdLabel, cmdField);
      
      //button to submit and calculate input
      Button submit = new Button("Calculate");
      
      //main vbox for all hboxes 
      VBox main = new VBox(20);
      main.getChildren().addAll( results, cmd, submit);
      EventHandler<ActionEvent> handle = new CmdTextListener();
      submit.setOnAction(handle);

      //majic for stage ;)
      primaryStage.setScene(new Scene(main));
      primaryStage.setTitle("Prefix Calculator");
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
           //displayField.setText(pExpr);
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








