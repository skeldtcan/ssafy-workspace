package com.ssafy.java.day0825;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_1992_쿼드트리 {
	static int N, Answer=0;
	static BufferedReader input;
	static StringBuilder output = new StringBuilder();
	static int[][] map;

	public static void main(String[] args) throws Exception{
		input = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(input.readLine());
		map = new int[N][N];
		
		for (int i=0; i<N; i++) {
			String s = input.readLine();
			for (int j=0; j<N; j++) {
				map[i][j] = s.charAt(j)-'0';
			}
		}
		
		quad(N, map);
		System.out.println(output);
		
	}
	
	static void quad(int len, int[][] divMap) {
		boolean allSame = true;
		// 모두 같은 숫자인지 확인
		int sameInt = divMap[0][0];
		loop: for(int i=0; i<len; i++) {
			for(int j=0; j<len; j++) {
				if (divMap[i][j] != sameInt) {
					allSame = false;
					break loop;
				}
			}
		}
		// 모두 같은 숫자면 압축하고 반환
		if (allSame) {
			output.append(sameInt);
			return;
		}
		// 각 사분면에 저장할 좌표 r, c 생성
		int r=0;
		int c=0;
		// 제 1사분면
		int[][] divMap1 = new int[len/2][len/2];
		for(int i=0; i<len/2; i++) {
			c = 0;
			for(int j=0; j<len/2; j++) {
				divMap1[r][c++] = divMap[i][j];
			}
			r++;
		}
		// 제 2사분면
		r=0;
		int[][] divMap2 = new int[len/2][len/2];
		for(int i=0; i<len/2; i++) {
			c=0;
			for(int j=len/2; j<len; j++) {
				divMap2[r][c++] = divMap[i][j];
			}
			r++;
		}
		// 제 3사분면
		r=0;
		int[][] divMap3 = new int[len/2][len/2];
		for(int i=len/2; i<len; i++) {
			c=0;
			for(int j=0; j<len/2; j++) {
				divMap3[r][c++] = divMap[i][j];
			}
			r++;
		}
		//제 4사분면
		r=0;
		int[][] divMap4 = new int[len/2][len/2];
		for(int i=len/2; i<len; i++) {
			c=0;
			for(int j=len/2; j<len; j++) {
				divMap4[r][c++] = divMap[i][j];
			}
			r++;
		}
		
		// 최소단위면 각각 출력
		if (len==2) {
			output.append("(").append(divMap1[0][0]).append(divMap2[0][0])
			.append(divMap3[0][0]).append(divMap4[0][0]).append(")");
		}
		// 아니면 더 쪼개기
		else {
			output.append("(");
			quad(len/2, divMap1);
			quad(len/2, divMap2);
			quad(len/2, divMap3);
			quad(len/2, divMap4);
			output.append(")");
		}
	}
}
