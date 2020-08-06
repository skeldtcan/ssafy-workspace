package com.ssafy.java.day0806;

import java.io.*;
import java.util.*;

public class Main_2961_도영이가만든맛있는음식 {
	static BufferedReader input;
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N, Answer = 1000000000;
	static int[][] g;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		input = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(input.readLine());
		g = new int[N][2];
		
		for(int n=0; n<N; n++) {
			tokens = new StringTokenizer(input.readLine());
			g[n][0] = Integer.parseInt(tokens.nextToken());
			g[n][1] = Integer.parseInt(tokens.nextToken());
		}
		
		for(int i=1; i<=N; i++)
			comb(i, 0, new int[] {1,0});
		
		System.out.println(Answer);
	}
	
	static void comb(int r, int start, int[] taste) {
		if (r==0) {
			//끝내기전에 Answer랑 비교
			if (Answer > Math.abs(taste[0] - taste[1]))
				Answer = Math.abs(taste[0] - taste[1]);
			return;
		}
		
		for(int i=start; i<N; i++) {
			comb(r-1, i+1, new int[] {taste[0]*g[i][0], taste[1]+g[i][1]});
		}
	}
}
