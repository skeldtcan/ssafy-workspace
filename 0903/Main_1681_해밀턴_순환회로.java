package com.ssafy.java.day0903;

import java.io.*;
import java.util.*;

public class Main_1681_해밀턴_순환회로 {
	static BufferedReader input;
	static StringTokenizer tokens;
	static int N, Answer = Integer.MAX_VALUE;
	static int[][] adjMatrix;

	public static void main(String[] args) throws Exception {
		input = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(input.readLine().trim());
		adjMatrix = new int[N][N];
		for(int r=0; r<N; r++) {
			tokens = new StringTokenizer(input.readLine().trim());
			for(int c=0; c<N; c++) {
				adjMatrix[r][c] = Integer.parseInt(tokens.nextToken());
			}
		}
		
		permu(N-1, new int[N], new boolean[N], 0);
		System.out.println(Answer);
		
	}
	
	static void permu(int r, int[] tmp, boolean[] visited, int cost) {
		if(Answer <= cost)
			return;
		if(r==0) {
			if(adjMatrix[tmp[N-1]][0] == 0)
				return;
			cost += adjMatrix[tmp[N-1]][0];
			//System.out.println(Arrays.toString(tmp) + " : " + cost);
			Answer = Math.min(Answer, cost);
			return;
		}
		for(int i=1; i<N; i++) {
			if(!visited[i] && adjMatrix[tmp[N-r-1]][i] != 0) {
				visited[i] = true;
				tmp[N-r] = i;
				//System.out.print(N-r+"번째: " + cost + " -> ");
				cost += adjMatrix[tmp[N-r-1]][i];
				//System.out.println(cost);
				permu(r-1, tmp, visited, cost);
				cost -= adjMatrix[tmp[N-r-1]][i];
				visited[i] = false;
			}
		}
	}
}
