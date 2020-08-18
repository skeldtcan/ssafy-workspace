package com.ssafy.java.day0818.hw;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ProductServer {

	public static void main(String[] args) {

        // 서버에서는 ServerSocket 필요
        try (ServerSocket ss = new ServerSocket(9999);) {
            System.out.println("server is ready..");
            while (true) {
                Socket forClient = ss.accept();
                // 클라이언트의 동작과 서버의 동작은 연계 된다.
                ObjectInputStream oin = new ObjectInputStream(forClient.getInputStream());
                Object read = oin.readObject();
                System.out.println("정보 수신 완료: " + read);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

	}

}
