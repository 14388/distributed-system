package ui;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import ui.Counter;
import ui.Counter.butCoListener;

public class Counter extends Frame {
	   private Label labCo;
	   private TextField textCo;
	   private Button butCo;
	   private int count = 0;
	   
	   public Counter () {
	      setLayout(new FlowLayout());
	      addWindowListener(new WindowAdapter(){  
	          public void windowClosing(WindowEvent e) {  
	              dispose();  
	          }  
	      });  

	      labCo = new Label("Counter");
	      add(labCo);	      
	      textCo = new TextField(count + "", 10);
	      textCo.setEditable(false);
	      add(textCo);
	      butCo = new Button("Count");
	      add(butCo);
	      butCoListener listener = new butCoListener();
	      butCo.addActionListener(listener);
	      setTitle("Counter");
	      setSize(400, 150);
	      setVisible(true);	     
	   }
	   public static void main(String[] args) {
	      Counter app = new Counter();
	   }
	   public class butCoListener implements ActionListener {
	      public void actionPerformed(ActionEvent evt) {
	         ++count;
	         textCo.setText(count + "");
	      }
	   }
	}
