package com.ssafy.java.day1105;

import java.io.*;
import java.util.*;

public class Solution {
	static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder output;
    static int T, N, Answer, Cnt;
    static char[][] Map;
    static boolean[][] Visited;
    static int[][] Dirs = {{-1,0}, {-1,1}, {0,1}, {1,1}, {1,0}, {1,-1}, {0,-1}, {-1,-1}};

	public static void main(String[] args) throws Exception{
		T = Integer.parseInt(input.readLine());
        
        for(int t=1; t<=T; t++) {
        	N = Integer.parseInt(input.readLine());
            output = new StringBuilder();
            Answer = 0;
            Cnt = 0;
            Map = new char[N][N];
            Visited = new boolean[N][N];
            
            for(int r=0; r<N; r++) {
            	String line = input.readLine();
            	for(int c=0; c<N; c++)
            		Map[r][c] = line.charAt(c); 
            }
            
            for(int r=0; r<N; r++)
            	for(int c=0; c<N; c++)
            		if(Map[r][c] == '.') {
            			chk(r,c);
            			Answer++;
            		}
            
            for(int r=0; r<N; r++)
            	for(int c=0; c<N; c++)
            		if(!Visited[r][c] && Map[r][c] == '0')
            			bfs(r, c);
            
            output.append("#").append(t).append(" ").append(Answer);
            System.out.println(output);
        }// end T
	}// end main
	static void bfs(int r, int c) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {r, c});
		Visited[r][c] = true;
		
		while(!q.isEmpty() ) {
			int[] pos = q.poll();
			for(int i=0; i<8; i++) {
				int nr = pos[0] + Dirs[i][0];
				int nc = pos[1] + Dirs[i][1];
				if(isIn(nr, nc) && !Visited[nr][nc]) {			// 방문한 적이 없을 때
					if(Map[nr][nc] == '*') {					// 지뢰면 패스
						Visited[nr][nc] = true;
						continue;
					}
					else if(Map[nr][nc] == '0') {				// 0이면 방문하고 q에 추가
						Visited[nr][nc] = true;
						Answer--;
						q.add(new int[] {nr, nc});
					}
					else {										// 나머지 숫자면 방문처리만
						Visited[nr][nc] = true;
						Answer--;
					}
				}
			}
		}
	}
	static void chk(int r, int c) {
		int mine = 0;
		for(int i=0; i<8; i++) {
			int nr = r + Dirs[i][0];
			int nc = c + Dirs[i][1];
			if(isIn(nr, nc) && Map[nr][nc] == '*')
				mine++;
		}
		Map[r][c] = (char)(mine + '0');
	}
	static boolean isIn(int r, int c) {
		return c>=0 && c<N && r>=0 && r<N; 
	}
}
