package com.ssafy.java.day0827;

import java.io.*;
import java.util.*;

//빵집 파이프문제
public class Main_15961_회전_초밥 {
    static int R, C, K, Answer = 0;
    static BufferedReader input;
    static StringBuilder output = new StringBuilder();
    static StringTokenizer tokens;
    static char[][] map;
    static int[][] dirs = {{1,1}, {0,1}, {-1,1}};
    static boolean[][] visited;
    static Stack<Pos> route = new Stack<>();

    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("input.txt"));
        input = new BufferedReader(new InputStreamReader(System.in));
        tokens = new StringTokenizer(input.readLine());
      
        R = Integer.parseInt(tokens.nextToken());
        C = Integer.parseInt(tokens.nextToken());
        map = new char[R][C];
        visited = new boolean[R][C];
       
        for(int r=0; r<R; r++) {
            map[r] = input.readLine().toCharArray();
        }
       
        for(int r=0; r<R; r++) {
        	route.push(new Pos(r, 0, new Pos[C]));
        	while(!route.isEmpty())
        		find(route.pop());
        }
        System.out.println(Answer);
    }
   
    static void find(Pos pos) {
    	boolean chk = false;
    	System.out.println(pos.r + ", " + pos.c);
    	int r = pos.r;
    	int c = pos.c;
    	Pos[] trace = pos.trace;
    	trace[c] = new Pos(r, c, null);
    	
    	if (pos.c == C-1) {
    		Answer++;
    		for(Pos a: trace)
    			visited[a.r][a.c] = true; 
    		route.clear();
    	}
    		
    	
    	for(int i=0; i<3; i++) {
    		int nr = r + dirs[i][0];
    		int nc = c + dirs[i][1];
    		if (isIn(nr, nc) && map[nr][nc] == '.' && !visited[nr][nc]) {
    			route.add(new Pos(nr, nc, trace));
    			chk = true;
    		}
    	}
    }
   
    static class Pos {
    	int r, c;
    	Pos[] trace;
	   
		public Pos(int r, int c, Pos[] trace) {
		super();
		this.r = r;
		this.c = c;
		this.trace = trace;
		}
		
		@Override
        public String toString() {
            return "[" + r + "," + c + "]";
        }
	}
    
    static boolean isIn(int r, int c) {
    	return r>=0 && r<R && c>=0 && c<C;
    }
}
