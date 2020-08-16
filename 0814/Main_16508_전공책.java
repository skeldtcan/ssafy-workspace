package com.ssafy.java.day0817;

import java.io.*;
import java.util.*;

public class Main_16508_전공책 {

	static int N, Answer = Integer.MAX_VALUE;
	static String Str;
	static int[] bookCosts;
	static String[] bookNames;
	static BufferedReader input;
	static StringTokenizer tokens;
	
	public static void main(String[] args) throws Exception {
		input = new BufferedReader(new InputStreamReader(System.in));
		Str = input.readLine();
		N = Integer.parseInt(input.readLine());
		bookCosts = new int[N];
		bookNames = new String[N];
		
		for(int n=0; n<N; n++) {
			tokens = new StringTokenizer(input.readLine());
			bookCosts[n] = Integer.parseInt(tokens.nextToken());
			bookNames[n] = tokens.nextToken();
		}
		
		check();
		
		System.out.println(Answer == Integer.MAX_VALUE ? -1 : Answer);
		
	}
	static void check() {
		for(int i=1; i< (1<<N); i++) {
			int cost = 0;
			int len = Str.length();
			char[] str = Str.toCharArray();
			String totalString = "";
			
			for(int j = 0; j<N; j++) {
				if((i & (1<<j)) > 0) {
					cost += bookCosts[j];
					totalString += bookNames[j];
				}
			}
			
			
			int cnt = 0;
			for(int p=0; p<len; p++) {
				if (totalString.contains(""+str[p])){
					totalString = totalString.replaceFirst(""+str[p], "?");
					cnt++;
				} else {
					break;
				}
			}
			if (cnt == len) {
				Answer = Math.min(Answer, cost);
			}
		}
	}
}
