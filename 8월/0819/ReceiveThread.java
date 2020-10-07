package com.ssafy.java.day0819.chat3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ReceiveThread extends Thread{
	Socket socket;
	BufferedReader br;
	public ReceiveThread(Socket socket) {
		this.socket = socket;
		try {
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		while(true) {
			try {
				System.out.println(br.readLine());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
}
