package client;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

import readfile.readcsvAd;

public class clientAd {
	public static void main(String[] args) {
		int serverPort = 1999;
		Socket socket = null;
		ObjectOutputStream toServer = null;
		ObjectInputStream fromServer = null;
		BufferedReader br = null;
		
		try {

			InetAddress serverHost = InetAddress.getByName("localhost");
			System.out.println("Connecting to server on port " + serverPort);
			socket = new Socket(serverHost, serverPort);
			System.out.println("Just connected to " + socket.getRemoteSocketAddress());
			
			toServer = new ObjectOutputStream(new BufferedOutputStream(socket.getOutputStream()));
			toServer.writeObject(readcsvAd.readData("advertising.csv"));
			toServer.flush();

			fromServer = new ObjectInputStream(new BufferedInputStream(socket.getInputStream()));
			double msgFromReply = (double) fromServer.readObject();
			System.out.println(msgFromReply);
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.exit(1);
		} finally {
			if (socket != null) {
				try {
					socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
