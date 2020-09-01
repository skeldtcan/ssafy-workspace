package com.ssafy.java.day0901;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14889_스타트링크 {
	static BufferedReader input;
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int N, Cnt, Answer = Integer.MAX_VALUE;
	static int[][] Table;
	static int[] Team;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		input = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(input.readLine());
		Table = new int[N][N];
		Team = new int[N/2];
		for(int r=0; r<N; r++) {
			tokens = new StringTokenizer(input.readLine());
			for(int c=0; c<N; c++) {
				Table[r][c] = Integer.parseInt(tokens.nextToken());
			}
		}
		
		combTeam(N/2, 0, Team);
		System.out.println(Answer);
	}
	
	static void combTeam(int r, int start, int[] tmp) {
		if(r==0) {
			if(Answer == 0)
				return;
			//System.out.println("=" +Arrays.toString(tmp));
			int[] a = new int[N/2];
			int[] b = new int[N/2];
			int aCnt = 0;
			int bCnt = 0;
			Cnt = 0;
			for (int i=0; i<N; i++) {
				if(Cnt < N/2 && isIn(i, tmp))
					a[aCnt++] = i;
				else
					b[bCnt++] = i;
			}
			//System.out.println("A: " +Arrays.toString(a));
			//System.out.println("B: " +Arrays.toString(b));
			comp(a, b);
			return;
		}
		for(int i=start; i<N; i++) {
			tmp[N/2-r] = i;
			combTeam(r-1, i+1, tmp);
		}
	}
	
	static void comp(int[] a, int[] b) {
		int A = 0;
		int B = 0;
		for (int i=0; i<N/2; i++) {
			for (int j=0; j<N/2; j++) {
				A += Table[a[i]][a[j]];
				B += Table[b[i]][b[j]];
			}
		}
		Answer = Math.min(Answer, Math.abs(A-B));
	}
	
	static boolean isIn(int a, int[] tmp) {
		for(int i=0; i<N/2; i++) {
			if (a == tmp[i]) {
				Cnt++;
				return true;
			}
		}
		return false;
	}
}
