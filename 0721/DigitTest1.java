package com.ssafy.java.day2.hw;

import java.util.Scanner;

public class DigitTest1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int [] num_count = new int [10];
		while (true) {
			System.out.println("숫자를 입력해 주세요.");
			Scanner scanner = new Scanner(System.in);
			int in_num = scanner.nextInt();
			if (in_num == 0) {
				break;
			} else {
				num_count[(int)(in_num/10)]++;
			}			
		}
		
		for(int i=0; i<10; i++) {
			if (num_count[i] == 0) {
				continue;
			} else {
				System.out.printf("%d : %d개\n", i, num_count[i]);
			}
		}		
	}
}
