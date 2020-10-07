package com.ssafy.java.day14;

import java.io.*;
import java.util.*;

public class Solution_9229_한빈이와_Spot_Mart {
	
	static int T, N, M, Answer;
	static BufferedReader input;
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int[] mart;
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		input = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(input.readLine());
		
		for(int t=1; t<=T; t++) {
			Answer = -1;
			tokens = new StringTokenizer(input.readLine());
			N = Integer.parseInt(tokens.nextToken());
			M = Integer.parseInt(tokens.nextToken());
			
			mart = new int[N];
			tokens = new StringTokenizer(input.readLine());
			for (int n=0; n<N; n++) {
				mart[n] = Integer.parseInt(tokens.nextToken()); 
			}
			makeCombination(2, 0, 0);
			output.append("#").append(t).append(" ").append(Answer).append("\n");
		}
		System.out.println(output);
	}
	
    static void makeCombination(int r, int start, int sum) {
        if (r == 0) {
            if (Answer < sum && sum <= M)
            	Answer = sum;
            return;
        }
        for (int i = start; i < mart.length; i++) {
            makeCombination(r - 1, i + 1, sum + mart[i]);
        }
    }
}
