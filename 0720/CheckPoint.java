package com.ssafy.java.day1.hw;

import java.util.Scanner;

public class CheckPoint {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("키와 몸무게를 자연수로 입력해주세요.");
		Scanner scanner = new Scanner(System.in);
		int height = scanner.nextInt();
		int weight = scanner.nextInt();
		int chk = weight+100-height;
		scanner.close();
		System.out.printf("비만수치는 %d입니다.\n", chk);
		if (chk > 0) {
			System.out.printf("당신은  비만이군요.\n");
		}
	}

}
