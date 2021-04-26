package ui;

import java.awt.Button;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

import ui.UI;
import ui.UI.SubmitButtonListener;
import model.Student;

public class UI extends Frame{
	
	private TextField NameIn;
	private TextField GenIn;
	private TextField AgeIn;
	private TextField IDIn;
	private Button submit;
	private Button clear;
	private static Socket socket;
	
	public UI() { 
		addWindowListener(new WindowAdapter(){  
	          public void windowClosing(WindowEvent e) {  
	              dispose();  
	          }  
	      });  
	   
		setLayout(new GridLayout(5, 2, 3, 3));
		
		add(new Label("Name"));
		NameIn = new TextField();
		add(NameIn);
		
		add(new Label("Gender"));
		GenIn = new TextField();
		add(GenIn);
		
		add(new Label("Age"));
		AgeIn = new TextField();
		add(AgeIn);
		
		add(new Label("ID"));
		IDIn = new TextField();
		add(IDIn);
		
		submit = new Button("Submit");
		clear = new Button("Clear");
		add(submit);
		add(clear);
		
		// add event handler 
		submit.addActionListener(new SubmitButtonListener());
		
		setTitle("simple socket server");
		setSize(500,200);
		setVisible(true);
	}
	
	static void setUpConnectionToServer() throws IOException{
		socket = new Socket("localhost", 4999);

        PrintWriter pr = new PrintWriter(socket.getOutputStream());
        pr.println("hello from client");
        pr.flush();
	}


	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		try {
			setUpConnectionToServer();
			new UI();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
	}
	
	public class SubmitButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent event){			
			Student student = new Student(
					NameIn.getText(),
					GenIn.getText(),
					AgeIn.getText(),
					IDIn.getText());
			
			// pass object to server
			OutputStream outputStream;
			try {
				outputStream = socket.getOutputStream();
				ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
				objectOutputStream.writeObject(student);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
		}
	}

}
