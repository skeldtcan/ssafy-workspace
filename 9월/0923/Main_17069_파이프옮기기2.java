package com.ssafy.java.day0923;

import java.util.*;
import java.io.*;

public class Main_17069_파이프옮기기2 {
	static BufferedReader input;
	static StringTokenizer tokens;
    static int N, Answer=0;
    static int[][] map;
    static long[][][] chk;
    
	public static void main(String[] args) throws Exception{
		input = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(input.readLine());
		
		map = new int[N][N];
		chk = new long[N][N][3];
		chk[0][1][0] = 1;
		
		for(int r=0; r<N; r++) {
			tokens = new StringTokenizer(input.readLine());
			for (int c=0; c<N; c++) {
				map[r][c] = Integer.parseInt(tokens.nextToken());
			}
		}
		
		for(int r=0; r<N; r++) {
			for (int c=0; c<N; c++) {
				// 가로 탐색
				if(isIn(r,c-1) && map[r][c] != 1) {
					chk[r][c][0] += chk[r][c-1][0] + chk[r][c-1][2];
				}
				// 세로 탐색
				if(isIn(r-1,c) && map[r][c] != 1) {
					chk[r][c][1] += chk[r-1][c][1] + chk[r-1][c][2]; 
				}
				// 대각 탐색
				if(isIn(r-1, c-1) && map[r][c] != 1 && map[r-1][c] != 1 && map[r][c-1] != 1) {
					chk[r][c][2] += chk[r-1][c-1][0] + chk[r-1][c-1][1] + chk[r-1][c-1][2];
				}
			}
		}
		
			
		System.out.println(chk[N-1][N-1][0] + chk[N-1][N-1][1] + chk[N-1][N-1][2]);
		
	}
	
	static boolean isIn(int r, int c) {
		return r>=0 && r<N && c>=0 && c<N;
	}
}
