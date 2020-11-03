package com.ssafy.java.day1103;

import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer tokens;
    static int R, C, Answer=0, N, Start;
    static boolean[] Map;

	public static void main(String[] args) throws Exception {
		tokens = new StringTokenizer(input.readLine());
		C = Integer.parseInt(tokens.nextToken());
		R = Integer.parseInt(tokens.nextToken());
		N = Integer.parseInt(input.readLine());
		Map = new boolean[(R+C)*2];
		
		for(int n=0; n<N; n++) {
			tokens = new StringTokenizer(input.readLine());
			int x = Integer.parseInt(tokens.nextToken());
			int y = Integer.parseInt(tokens.nextToken());
			if(x==1)
				Map[y] = true;
			else if(x==2)
				Map[2*C+R-y] = true;
			else if(x==3)
				Map[2*R+2*C-y] = true;
			else if(x==4)
				Map[C+y] = true;
		}
		tokens = new StringTokenizer(input.readLine());
		int x = Integer.parseInt(tokens.nextToken());
		int y = Integer.parseInt(tokens.nextToken());
		if(x==1)
			Start = y;
		else if(x==2)
			Start = 2*C+R-y;
		else if(x==3)
			Start = 2*R+2*C-y;
		else if(x==4)
			Start = C+y;
		
		//dfs(Start, 0, N);
		int dis=1;
		while(N>0) {
			int pos = trans(Start+dis);
			if(Map[pos]) {
				Map[pos] = false;
				Answer += dis;
				N--;
			}
			pos = trans(Start-dis);
			if(Map[pos]) {
				Map[pos] = false;
				Answer += dis;
				N--;
			}
			dis++;
		}
		System.out.println(Answer);
	}
	
	static int trans(int p) {
		if(p >= 2*(R+C))
			return p % (2*(R+C));
		else if(p < 0)
			return (p+2*(R+C)) % (2*(R+C));
		else
			return p;
	}
}
