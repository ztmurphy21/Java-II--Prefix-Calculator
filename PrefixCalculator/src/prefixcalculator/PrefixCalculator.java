/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prefixcalculator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javax.swing.JTextField;
import static jdk.nashorn.internal.runtime.JSType.isNumber;

/**
 *
 * @author Zachary Murphy
 */
public class PrefixCalculator {

  private TextField inputTextField;
  private TextField resultTextField;
  
  
  //called when expression is put in input field
  //runs command string into expression
  //calls methods buildExp
  private class CmdTextListener implements ActionListener{
      public void actionPerformed(ActionEvent evt){
          String pExpr = inputTextField.getText();
          Node exprTree = buildExpr(new Scanner(pExpr));
          int value = eval(exprTree);
          resultTextField.setText(String.valueOf(value));
          
      }
  }
 //Node constructor for this program BINARY TREE 
  private class Node{
      String value;
      Node left, right;
      Node(String v, Node l, Node r){
          value = v;
          left = l;
          right = r;
      }
  }
  
  /*
  Passs scanner with input exp
  this checks to see if it is number
  then returns it by first if statement
  else statement uses recurision 
  */
  Node buildExpr(Scanner sc){
      String s = sc.next();
      if(isNumber(s)){
          return new Node(s, null, null);
          
      }
      else{
          //s is an operator, so build a non-leaf tree
          Node leftOp = buildExpr(sc);
          Node rightOp= buildExpr(sc);
          return new Node(s, leftOp, rightOp);
      }
  }
  
  /*
  uses binary tree to get value recurision
  
  */
  private int eval(Node tree){
      if(tree.left == null && tree.right == null){
          return Integer.parseInt(tree.value);
      }
      else{
          int leftOp = eval(tree.left);
          int rightOp = eval(tree.right);
          if(tree.value.equals("*")){
              return leftOp * rightOp;
          }
          if(tree.value.equals("+")){
              return leftOp + rightOp;
          }
          return 0; //won't be reached
      }
  }
  
    public static void main(String[] args) {
        
    }
    
    
}
