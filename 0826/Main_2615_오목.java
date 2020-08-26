package com.ssafy.java.day0826;

import java.io.*;
import java.util.*;

public class Main_2615_오목 {
	static int N, M;
	static BufferedReader input;
	static StringBuilder output = new StringBuilder();
	static StringTokenizer tokens;
	static int[][] dirs = {{1, 0}, {1, 1}, {0, 1}, {-1, 1}};
	static int[][] map = new int[19][19];
	static boolean[][][] visited = new boolean[19][19][4];
	static Queue<int[]> qBlack = new LinkedList<>();
	static Queue<int[]> qWhite = new LinkedList<>();

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("input.txt"));
		input = new BufferedReader(new InputStreamReader(System.in));
		int black = 0;
		int white = 0;
		
		for(int n=0; n<19; n++) {
			tokens = new StringTokenizer(input.readLine());
			for(int m=0; m<19; m++) {
				map[n][m] = Integer.parseInt(tokens.nextToken());
				
			}
		}
		for(int m=0; m<19; m++) {
			for(int n=0; n<19; n++) {
				if (map[n][m] == 1) {
					black++;
					qBlack.add(new int[] {n, m});
				} else if (map[n][m] == 2) {
					white++;
					qWhite.add(new int[] {n, m});
				}
			}
		}
		
		
		if (black > white) {
			while(!qBlack.isEmpty() && output.length() == 0)
				bfs(qBlack.poll(), 1);
			while(!qWhite.isEmpty() && output.length() == 0)
				bfs(qWhite.poll(), 2);
		}
		else {
			while(!qWhite.isEmpty() && output.length() == 0)
				bfs(qWhite.poll(), 2);
			while(!qBlack.isEmpty() && output.length() == 0)
				bfs(qBlack.poll(), 1);
		}
		
		
		if (output.length()==0)
			System.out.println(0);
		else
			System.out.println(output);
	}
	static void bfs(int[] pos, int win) {
		int r = pos[0];
		int c = pos[1];
		
		for(int i=0; i<4; i++) {
			int length = 1;
			visited[r][c][i] = true;
			int nr = r+dirs[i][0];
			int nc = c+dirs[i][1];
			while(isIn(nr, nc) && map[nr][nc] == win && !visited[nr][nc][i]) {
				visited[nr][nc][i] = true;
				nr += dirs[i][0];
				nc += dirs[i][1];
				length++;
			}
			if (length == 5) {
				output.append(map[r][c]).append("\n").append(r+1).append(" ").append(c+1);
				break;
			}
		}
	}
	
	static boolean isIn(int r, int c) {
        return 0 <= r && r < 19 && 0 <= c && c < 19;
    }
}


