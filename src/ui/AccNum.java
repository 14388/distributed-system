package ui;

import java.awt.*;
import java.awt.event.*;



public class AccNum extends Frame {
	
   private TextField textIn;
   private TextField textOut;
   private int sum = 0;
   
   public AccNum() {
	   
	   addWindowListener(new WindowAdapter(){  
	          public void windowClosing(WindowEvent e) {  
	              dispose();  
	          }  
	      });  
	   
      setLayout(new GridLayout(3, 3));

      add(new Label("Input a number: ")); 

      textIn = new TextField(10);
      add(textIn);        
      
      textIn.addActionListener(new textInListener());


      add(new Label("The Accumulated Sum is: ")); 

      textOut = new TextField(10); 
      textOut.setEditable(false);
      add(textOut);  
      setTitle("Accumulator Number");
      setSize(400, 150);
      setVisible(true);
   }

   public static void main(String[] args) {   
      new AccNum();
   }


   private class textInListener implements ActionListener {

      public void actionPerformed(ActionEvent evt) {

         int numberIn = Integer.parseInt(textIn.getText());
         sum += numberIn; 
         textIn.setText("");
         textOut.setText(sum + "");
      }
   }
}