package com.ssafy.java.day0819.chat3;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {
	
	public static void main(String[] args) {
		try (ServerSocket ss = new ServerSocket(9999)) {
			System.out.println("Server is ready....");
			try{
				Socket socket = ss.accept();
				new SendThread(socket).start();
				new ReceiveThread(socket).start();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

}
