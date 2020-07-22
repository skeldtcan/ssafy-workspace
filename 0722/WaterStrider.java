package com.ssafy.java.day3.work;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WaterStrider {
	static long Answer;
    static int T, N, S;

    public static void main(String[] args) throws Exception {
    	System.setIn(new FileInputStream("Waterstrider.txt"));
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();// 테스트 케이스 수

        for (int t = 1; t <= T; t++) {
            N = sc.nextInt(); // 배열의 크기 NxN
            int[][] lake = new int[N][N];

            S = sc.nextInt();
            Answer = S;
            int[][] strider = new int[S][3];
            for (int k = 0; k < S; k++) {
                strider[k][0] = sc.nextInt();// 행위치
                strider[k][1] = sc.nextInt();// 열위치
                strider[k][2] = sc.nextInt();// 방향
                if (lake[strider[k][0]][strider[k][1]] == 1) Answer--;
                lake[strider[k][0]][strider[k][1]] = 1;
            }
            
            for (int i = 0; i < S; i++) {
                int row = strider[i][0];
                int col = strider[i][1];
                int dir = strider[i][2];

                if (dir == 1) {
                	if (row-6 < 0 || lake[row-3][col] == 1 || lake[row-5][col] == 1 || lake[row-6][col] == 1) Answer--;
                	else {
                		lake[row][col] = 0;
                		lake[row-6][col] = 1;
                	}
                } else if (dir == 2) {
                	if (row+6 >= N || lake[row+3][col] == 1 || lake[row+5][col] == 1 || lake[row+6][col] == 1) Answer--;
                	else {
                		lake[row][col] = 0;
                		lake[row+6][col] = 1;
                	}
                } else if (dir == 3) {
                	if (col-6 < 0 || lake[row][col-3] == 1 || lake[row][col-5] == 1 || lake[row][col-6] == 1) Answer--;
                	else {
                		lake[row][col] = 0;
                		lake[row][col-6] = 1;
                	}
                } else {
                	if (col+6 >= N || lake[row][col+3] == 1 || lake[row][col+5] == 1 || lake[row][col+6] == 1) Answer--;
                	else {
                		lake[row][col] = 0;
                		lake[row][col+6] = 1;
                	}
                }
            }
            System.out.println("#" + t + " " + Answer);
        }
    }
}

