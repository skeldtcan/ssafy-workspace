package com.ssafy.java.day14;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.*;

public class Main_1863_종교 {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer tokens;
	static StringBuilder output = new StringBuilder();
	static int N, K;
	
	public static void main(String[] args) throws Exception{
		tokens = new StringTokenizer(input.readLine());
		Queue<Integer> llist = new LinkedList<Integer>();
		N = Integer.parseInt(tokens.nextToken());
		K = Integer.parseInt(tokens.nextToken());
		for(int i=1; i<=N; i++) {
			llist.add(i);
		}
		
		output.append("<");
		for(int i=0; i<N; i++) {
			for(int j=0; j<K-1; j++) {
				llist.add(llist.poll());
			}
			output.append(llist.poll()).append(", ");
		}
		output.delete(output.length() - 2, output.length()).append(">");
		System.out.println(output);
		
	}

}
