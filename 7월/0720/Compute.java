package com.ssafy.java.day1.hw;

import java.util.Scanner;

public class Compute {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("2개의 정수를 입력해주세요.");
		Scanner scanner = new Scanner(System.in);
		int num1 = scanner.nextInt();
		int num2 = scanner.nextInt();
		scanner.close();
		System.out.printf("곱=%d\n몫=%d\n",num1*num2, num1/num2);
	}

}
