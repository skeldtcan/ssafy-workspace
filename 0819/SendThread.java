package com.ssafy.java.day0819.chat3;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class SendThread extends Thread{
	// scanner를 통해 받은 입력을 서버로 쏘는 스레드
	Socket socket;
	BufferedWriter bw;
	
	public SendThread(Socket socket) {
		this.socket = socket;
		
		try {
			bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		Scanner scanner = new Scanner(System.in);
		while(true) {
			try {
				String line = scanner.nextLine();
				if(line.equalsIgnoreCase("x")) {
					break;
				}
				bw.write(line + "\n");
				bw.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		// 서버와의 접속 종료
		try {
			socket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		scanner.close();
	}
	
	

}
