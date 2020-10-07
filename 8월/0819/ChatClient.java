package com.ssafy.java.day0819.chat3;

import java.io.IOException;
import java.net.Socket;

public class ChatClient {
	static String serverIp = "localhost";
	static int port = 9999;
	public static void main(String[] args) {
		
		try{
			Socket socket = new Socket(serverIp, port);
			System.out.println("연결 성공");
			new SendThread(socket).start();
			new ReceiveThread(socket).start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
