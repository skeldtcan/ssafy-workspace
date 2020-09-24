package com.ssafy.java.day0924;

import java.util.*;
import java.io.*;

public class Main_9205_맥주마시면서걸어가기 {
	static BufferedReader input;
	static StringTokenizer tokens;
	static StringBuilder output = new StringBuilder();
	static int T, N;
	static String Answer;
	static List<Pos> list;
	static Queue<Pos> q;
	static Pos home, fes;
	
	public static void main(String[] args) throws Exception{
		input = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(input.readLine());
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(input.readLine());
			list = new LinkedList<>();
			q = new LinkedList<>();
			Answer = "sad";
			
			// 집 좌표
			tokens = new StringTokenizer(input.readLine());
			int x = Integer.parseInt(tokens.nextToken());
			int y = Integer.parseInt(tokens.nextToken());
			home = new Pos(x, y);
			
			for(int n=0; n<N; n++) {
				tokens = new StringTokenizer(input.readLine());
				x = Integer.parseInt(tokens.nextToken());
				y = Integer.parseInt(tokens.nextToken());
				list.add(new Pos(x, y));
			}

			// 축제 좌표
			tokens = new StringTokenizer(input.readLine());
			x = Integer.parseInt(tokens.nextToken());
			y = Integer.parseInt(tokens.nextToken());
			fes = new Pos(x, y);
			
			bfs();
			
			output.append(Answer).append("\n");
		}
		System.out.println(output);
	}
	
	static void bfs() {
		q.add(home);
		
		while(!q.isEmpty()) {
			Pos start = q.poll(); 
			if(Math.abs(start.x - fes.x) + Math.abs(start.y - fes.y) <= 1000) {
				Answer = "happy";
				return;
			}
			for(int i=list.size()-1; i>=0; i--) {
				if(Math.abs(start.x - list.get(i).x) + Math.abs(start.y - list.get(i).y) <= 1000) {
					q.add(list.remove(i));
				}
			}
		}
	}
	
	static class Pos{
		int x, y;

		public Pos(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("[x=").append(x).append(", y=").append(y).append("]");
			return builder.toString();
		}
	}
}
